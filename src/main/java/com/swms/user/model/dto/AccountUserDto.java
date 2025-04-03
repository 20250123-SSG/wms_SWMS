package com.swms.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AccountUserDto {
    private int userId;  // PK
    private String account;
    private String password;
    private String userName;
    private int auth;
    private String phone;
    private String address;
}