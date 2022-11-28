package com.r.project.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserInfo {
    private long userIdx;
    private String uuid;
    private String userId;
    private String userPw;
    private String userName;
    private long regDate;
    private String eMail;
    private int nation;
    private String phone;
    private String address1;
    private String address2;
    private String postNum;
    private String location;
    private int bYear;
    private int bMonth;
    private int bDay;

    public LoginInfo toLoginInfo() {
        return LoginInfo.builder()
                .userId(userId)
                .userIdx(userIdx)
                .uuid(uuid)
                .regDate(regDate)
                .build();
    }
}
