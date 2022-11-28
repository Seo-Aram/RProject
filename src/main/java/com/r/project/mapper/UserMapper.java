package com.r.project.mapper;

import com.r.project.model.LoginInfo;
import com.r.project.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface UserMapper {
    public UserInfo selectLoginInfoById(String userId) throws SQLException;

    public int updateUUIDByUserIdx(long userIdx, String uuid) throws SQLException;
}
