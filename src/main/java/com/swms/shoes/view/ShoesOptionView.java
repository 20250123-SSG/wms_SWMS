package com.swms.shoes.view;

import com.swms.common.AnsiColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 옵션 선택 뷰
public class ShoesOptionView {
    private Scanner sc = new Scanner(System.in);
    public String inputType() {
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  1.  👟 스니커즈" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  2.  👟 런닝화" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  3.  👞 구두" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  4.  🥿 샌들" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  5.  🥾 부츠" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.BRIGHT_WHITE + "  0.  프로그램 종료" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_YELLOW + " 🔎 찾으시는 상품의 종류를 선택해주세요." + AnsiColor.RESET);
        System.out.print("""
                >> 입력 : """);

        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public String inputBrand() {
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  1.  나이키" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  2.  아디다스" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  3.  뉴발란스" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  4.  크록스" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  5.  반스" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.BRIGHT_WHITE + "  0.  프로그램 종료" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_YELLOW + "  📢 찾으시는 브랜드를 선택해주세요." + AnsiColor.RESET);
        System.out.print(AnsiColor.BRIGHT_WHITE + ">> 입력 : " + AnsiColor.RESET);
        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public List<String> inputSorting() {
        List<String> sortingOption = new ArrayList<>();
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  1.  📅 최신순" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  2.  💸 낮은가격순" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_WHITE + "  3.  💰 높은가격순" + AnsiColor.RESET);
        System.out.println();
        System.out.println(AnsiColor.BRIGHT_WHITE + "  0.  프로그램 종료" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
        System.out.println(AnsiColor.BRIGHT_YELLOW + "  📂 정렬 옵션을 선택해주세요." + AnsiColor.RESET);
        System.out.print(AnsiColor.BRIGHT_WHITE + ">> 입력 : " + AnsiColor.RESET);

        switch (sc.nextLine()) {
            case "1":
                sortingOption = List.of("shoes_id", "ASC");
                break;
            case "2":
                sortingOption = List.of("shoes_price", "ASC");
                break;
            case "3":
                sortingOption = List.of("shoes_price", "DESC");
                break;
            case "0":
                System.exit(0);
                break;

        }
        return sortingOption;
    }
}
