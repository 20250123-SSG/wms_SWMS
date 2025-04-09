package com.swms.shoes.view;

import com.swms.common.AnsiColor;
import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.model.dto.ShoesSelectOptionDto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 신발 리스트 조회 및 페이지네이션
public class ShoesView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);
    private String message = null;

    public List<ShoesSelectDto> selectShoesList(ShoesSelectOptionDto shoesSelectOptionDto) {
        int page = 1;

        while (true) {
            List<ShoesSelectDto> list = shoesController.selectShoesList(shoesSelectOptionDto, page);

            if (list.isEmpty()) {
                if (page > 1) {
                    --page;
                    list = shoesController.selectShoesList(shoesSelectOptionDto, page);
                    message = "⚠\uFE0F 마지막 페이지 입니다.";
                } else {
                    message = "⚠\uFE0F 신발 정보가 없습니다.";
                }
            }
            System.out.println(AnsiColor.BRIGHT_BLUE + " ─────────────────────────────────────────────" + AnsiColor.RESET);
            if (message != null) {
                System.out.println(AnsiColor.BRIGHT_RED + "                " + message + AnsiColor.RESET);
                message = null;
            }
            System.out.println(AnsiColor.BRIGHT_YELLOW + "                현재 페이지 : " + page + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                1. 다음 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                2. 이전 페이지" + AnsiColor.RESET);
            System.out.println(AnsiColor.GREEN + "                3. 재고 상품상세보기" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.GREEN + "                0. 뒤로 가기" + AnsiColor.RESET);
            System.out.print("""
                    >> 입력 : """);

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    page++;
                    break;
                case "2":
                    if (page == 1) {
                        message = "⚠\uFE0F 첫 페이지 입니다.";
                        break;
                    }
                    page--;
                    break;
                case "3":
                    return list;
                case "0":
                    System.exit(0);
            }

        }


    }

    // TODO: 데이터처리 controller에서 하도록 변경하기
    public ShoesDto selectShoesDetail(List<ShoesSelectDto> pageShoesList) {
        System.out.print(AnsiColor.BRIGHT_WHITE + """
        🔍 상세조회할 상품의 번호를 입력하세요.
        >> 입력 : """ + AnsiColor.RESET);
        //TODO: shoesDTO에 shoes_id를 추가하는게 좋을 듯. 우선은 이름으로 진행

        ShoesSelectDto shoesInfo = pageShoesList.get(Integer.parseInt(sc.nextLine()) - 1); // 상품상세보기
        ShoesDto shoes = shoesController.selectShoesDetail(shoesInfo.getShoesName());
        return shoes;
    }
}
