package com.r.project.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {
    private long userIdx;
    private String uuid;
    private String userId;
    private long regDate;
}
