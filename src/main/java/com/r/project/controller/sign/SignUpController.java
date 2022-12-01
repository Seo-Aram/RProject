package com.r.project.controller.sign;

import com.r.project.model.UserInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/sign/up")
public class SignUpController {

    @GetMapping
    public String signUp(){
        return "/sign/register";
    }

    @PostMapping
    public void signUp(
            @RequestParam(required = false)UserInfo userInfo,
            HttpServletRequest request,
            HttpServletResponse response
            ){

    }
}
