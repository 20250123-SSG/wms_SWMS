package com.swms.run;

import com.swms.run.page.MainPage;
import com.swms.run.page.LoginPage;
import com.swms.user.model.dto.UserDto;

public class Application {

    public static void main(String[] args) {

    while (true) {
        // 로그인 or 회원가입
        UserDto user = LoginPage.loginPage();
        if (user == null) return;

        // 홈페이지
        MainPage.mianPage(user);
    }

    }
}
