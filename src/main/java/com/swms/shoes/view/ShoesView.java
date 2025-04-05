package com.swms.shoes.view;


import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 신발 리스트 조회 및 페이지네이션
public class ShoesView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);

    public List<ShoesDto> selectShoesList(Map<String, Object> map){
        int offset = 0;
        while(true){
            List<ShoesDto> pageShoesList = shoesController.selectShoesList(map);
            System.out.print("""
                \n
                1. 이전페이지
                2. 다음페이지
                3. 상품상세보기 
                
                0. 프로그램 종료
                ---------------------------------------------------
                >> 입력 : """);

            String input = sc.nextLine();

            switch(input){
                case "1":
                    offset -= 10;
                    map.put("offset", offset);
                    break;
                case "2":
                    offset += 10;
                    map.put("offset", offset);
                    break;
                case "3":
                    return pageShoesList;
                case "0":
                    System.exit(0);
            }
        }
    }


    public ShoesDetailDto selectShoesDetail(List<ShoesDto> pageShoesList){
        System.out.print("""
                        상세조회할 상품의 번호를 입력하세요.
                        >> 입력 : """);
        //TODO: shoesDTO에 shoes_id를 추가하는게 좋을 듯. 우선은 이름으로 진행
        ShoesDto shoesInfo = pageShoesList.get(Integer.parseInt(sc.nextLine())); // 상품상세보기
        ShoesDetailDto shoes = shoesController.selectShoesDetail(shoesInfo.getShoesName());
        return shoes;
    }
}
