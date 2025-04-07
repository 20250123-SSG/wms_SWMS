package com.swms.warehouse.view;

import java.util.Scanner;

public class ResultView {
    private Scanner sc = new Scanner(System.in);


    public static void displayResult(String type, int result){ // type:"메뉴 등록"|"메뉴 수정"|"메뉴 삭제" / result:최종결과
        System.out.println("📢 " + type + " " +  (result > 0 ? "완료 되었습니다." : "실패 되었습니다.") );
    }
}
