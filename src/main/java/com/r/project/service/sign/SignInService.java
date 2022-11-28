package com.r.project.service.sign;

import com.r.project.mapper.UserMapper;
import com.r.project.model.LoginInfo;
import com.r.project.model.UserInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Log4j2
@Service
public class SignInService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private BCryptPasswordEncoder passwordEncoder;

    public UserInfo signIn(String userId, String userPw) throws SQLException {
        UserInfo userInfo = userMapper.selectLoginInfoById(userId);
        log.info(userInfo);
        if(userInfo != null) {
            if (!passwordEncoder.matches(userPw, userInfo.getUserPw())) {
                // 로그인 실패
                userInfo = null;
            }
        }

        return userInfo;
    }

    public int updateUUUID(long userIdx, String uuid) throws SQLException {
        return userMapper.updateUUIDByUserIdx(userIdx, uuid);
    }
}
