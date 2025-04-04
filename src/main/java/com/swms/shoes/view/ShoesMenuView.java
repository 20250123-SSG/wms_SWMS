package com.swms.shoes.view;

import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.*;

public class ShoesMenuView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);
    private Map<String, Object> map = new HashMap<>();

    public void NavigationView() {

        while (true) {
            System.out.println("====================================");
            System.out.println("XYZ-Mart에 방문해주셔서 감사합니다.");

            String type = inputType(); // 1. 신발종류 선택
            String brand = inputBrand(); // 2. 브랜드 선택
            List<String> sorting = inputSorting(); // 3. 정렬 선택


            //map으로 조회조건 넘기기
            map.put("type", Integer.parseInt(type));
            map.put("brand", Integer.parseInt(brand));
            map.put("sortBy", sorting.get(0));
            map.put("ascDesc", sorting.get(1));
            map.put("offset", 0);



            pagination();

        }
        // 받은 아이디에 선택에 맞게 조회 뿌리기
    }


    public String inputType() {
        System.out.print("""
                ====================================
                찾으시는 상품의 종류를 선택해주세요.
               
                1. 스니커즈
                2. 런닝화
                3. 구두
                4. 샌들
                5. 부츠 
                
                0. 프로그램 종료
                ====================================
                >> 입력 :\t""");

        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public String inputBrand() {
        System.out.print("""
                ====================================
                찾으시는 브랜드를 선택해주세요.
                
                1. 나이키
                2. 아디다스
                3. 뉴발란스
                4. 크록스
                5. 반스
                
                0. 프로그램 종료
                ========================
                >> 입력 :\t""");

        String input = sc.nextLine();

        if("0".equals(input)){
            System.exit(0);
        }

        return input;
    }

    public List<String> inputSorting() {
        List<String> sortingOption = new ArrayList<>();
        System.out.print("""
                
                ---------------------------------------------------
                정렬 옵션을 선택해주세요.
                1. 최신순   2. 낮은가격순   3. 높은가격순  \s
                
                0. 프로그램 종료 \s
                ---------------------------------------------------
                >> 입력 :\t""");

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

    public void pagination(){
        int offset = 0;
        while(true){
            List<ShoesDto> pageShoesList = shoesController.selectShoesList(map);
            System.out.println("""
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
                    System.out.println("상세조회할 상품의 번호를 입력하세요.");
                    //TODO: shoesDTO에 shoes_id를 추가하는게 좋을 듯. 우선은 이름으로 진행
                    ShoesDto shoes = pageShoesList.get(Integer.parseInt(sc.nextLine())); // 상품상세보기
                    shoesController.selectShoesDetail(shoes.getShoesName());
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
