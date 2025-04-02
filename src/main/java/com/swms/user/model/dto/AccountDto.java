package com.swms.user.model.dto;

public class AccountDto {
    private String id;
    private String password;

    public AccountDto() {
    }

    public AccountDto(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
