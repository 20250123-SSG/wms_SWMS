package com.swms.shoes.view;

import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.*;

public class ShoesMenuView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);
    private Map<String, Object> map = new HashMap<>();


    private ShoesOptionView optionView = new ShoesOptionView(); // type, brand, sorting 선택

    // TODO: 뷰 나누기...
    public void NavigationView() {

        while (true) {
            String type = optionView.inputType(); // 1. 신발종류 선택
            String brand = optionView.inputBrand(); // 2. 브랜드 선택
            List<String> sorting = optionView.inputSorting(); // 3. 정렬 선택


            //map으로 조회조건 넘기기
            map.put("type", Integer.parseInt(type));
            map.put("brand", Integer.parseInt(brand));
            map.put("sortBy", sorting.get(0));
            map.put("ascDesc", sorting.get(1));
            map.put("offset", 0);

            // 4. 조회옵션으로 신발목록 출력 (페이지네이션)
            List<ShoesDto> pageShoesList = selectShoesList();  //ShoesDetailDto shoes =

            // 5. 상세조회
            ShoesDetailDto shoes = selectShoesDetail(pageShoesList);

            // 6. 사용자동작선택 (구매/장바구니/좋아요)
            String action = userActionView();
            switch (action) {
                case "1":
                    break; // 구매하기 (shoes활용)
                case "2":
                    break; // 장바구니
                case "3":
                    break; // 좋아요
            }

        }
        // 받은 아이디에 선택에 맞게 조회 뿌리기
    }





    public List<ShoesDto> selectShoesList(){
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
                    return pageShoesList;
                case "0":
                    System.exit(0);
            }
        }
    }

    public ShoesDetailDto selectShoesDetail(List<ShoesDto> pageShoesList){
        System.out.println("상세조회할 상품의 번호를 입력하세요.");
        //TODO: shoesDTO에 shoes_id를 추가하는게 좋을 듯. 우선은 이름으로 진행
        ShoesDto shoesInfo = pageShoesList.get(Integer.parseInt(sc.nextLine())); // 상품상세보기
        ShoesDetailDto shoes = shoesController.selectShoesDetail(shoesInfo.getShoesName());
        return shoes;
    }

    public String userActionView(){
        System.out.println(
                        """
                        \n
                        ----------------------------------
                        원하시는 기능을 선택하세요.
                        
                        1. 구매하기
                        2. 장바구니 
                        3. 좋아요 
                        
                        0. 뒤로가기
                        ----------------------------------
                        >> 입력 : 
                        """);
        return sc.nextLine();
    }
}
