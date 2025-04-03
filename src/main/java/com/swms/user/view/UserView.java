package com.swms.user.view;

import com.swms.user.model.dto.UserDto;

import java.util.Scanner;

public class UserView {
    private Scanner sc = new Scanner(System.in);

    public void myInfo() {
        System.out.println("\n~~~ 로그인 정보를 작성해주세요 ~~~");
        System.out.println("> 아이디: ");
        String id = sc.nextLine();
        System.out.println("> 비밀번호: ");
        String password = sc.nextLine();

    }

}
