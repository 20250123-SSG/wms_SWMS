package com.swms.user.model.dto;

public class UserDto {
    private String userName;
    private String auth;
    private int money;
    private String phone;
    private String address;

    public UserDto() {
    }

    public UserDto(String userName, String auth, int money, String phone, String address) {
        this.userName = userName;
        this.auth = auth;
        this.money = money;
        this.phone = phone;
        this.address = address;
    }
}
