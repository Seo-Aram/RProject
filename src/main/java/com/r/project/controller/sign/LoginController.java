package com.r.project.controller.sign;

import com.r.project.model.LoginInfo;
import com.r.project.model.UserInfo;
import com.r.project.service.sign.SignInService;
import com.r.project.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Log4j2
@Controller
@RequestMapping("/sign/in")
public class LoginController {

    @Autowired
    private SignInService signInService;

    @GetMapping
    public String signIn(){
        return "/sign/login";
    }

    @PostMapping
    public void signIn(
            @RequestParam("userId") String userId,
            @RequestParam("userPw") String userPw,
            @RequestParam(name="isRemember", required = false) boolean isRemember,
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes redirectAttributes
    ) throws IOException, SQLException {

        UserInfo userInfo = signInService.signIn(userId, userPw);
        if(userInfo == null) {
            redirectAttributes.addFlashAttribute("result","e"); // 1회성 소멸
            response.sendRedirect("/sign/in");
            return;
        }

        if(isRemember) {
            UUID uuid = UUID.randomUUID();
            userInfo.setUuid(uuid.toString());
            int result = signInService.updateUUUID(userInfo.getUserIdx(), uuid.toString());

            if(result > 0) {
                request.getSession(true).setAttribute("loginInfo", userInfo.toLoginInfo());
                Cookie cookie = Util.findCookie(request.getCookies(), "loginInfo");
                if(cookie == null) {
                    cookie = new Cookie("loginInfo", uuid.toString());
                } else {
                    cookie.setValue(uuid.toString());
                }
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);

                log.warn("cookie create");
            }
        }
        redirectAttributes.addFlashAttribute("result","t");
        response.sendRedirect("/sign/in");
    }
}
