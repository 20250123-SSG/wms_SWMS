package com.swms.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
    private String userName;
    private String auth;
    private int money;
    private String phone;
    private String address;
}
