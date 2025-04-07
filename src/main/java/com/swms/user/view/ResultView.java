package com.swms.user.view;

public class ResultView {
    public static void handleDuplicateId() {
        System.out.println("~~~ 중복된 아이디 입니다. 다시 입력해주세요 ~~~");
    }

    public static void handleAuth(String auth) {
        System.out.printf("~~~ %s는 없는 권한 입니다. 다시 입력해주세요 ~~~", auth);
        System.out.println();
    }

    public static void signupResult(String type, int result) {
        System.out.println("📢 " + type + " " + (result > 0 ? "이 완료되었습니다. 로그인을 시도해주세요" : "이 되지 않았습니다."));
    }

    public static void updateResult(String type, int result){
        System.out.println("📢 " + type + " " +  (result > 0 ? "변경이 완료되었습니다." : "변경에 실패했습니다.") );
    }
    public static void displayResult(String type, int result){ // type:"메뉴 등록"|"메뉴 수정"|"메뉴 삭제" / result:최종결과
        System.out.println("📢 " + type + " " +  (result > 0 ? "성공!" : "실패!") );
    }
}




