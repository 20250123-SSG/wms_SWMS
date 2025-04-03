package com.swms.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
    private int userId;
    private String userName;
    private String auth;
    private String phone;
    private String address;
    private int money;
}
