package com.swms.shoes.view;

import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDetailDto;
import com.swms.shoes.model.dto.ShoesDto;

import java.util.*;

public class ShoesMenuView {
    private ShoesController shoesController = new ShoesController();
    private Scanner sc = new Scanner(System.in);

    private ShoesOptionView optionView = new ShoesOptionView(); // type, brand, sorting 선택
    private ShoesView shoesView = new ShoesView();

    // TODO: 뷰 나누기...
    public void NavigationView() {

        while (true) {
            String type = optionView.inputType(); // 1. 신발종류 선택
            String brand = optionView.inputBrand(); // 2. 브랜드 선택
            List<String> sorting = optionView.inputSorting(); // 3. 정렬 선택

            //searchOptionMap으로 조회조건 넘기기
            Map<String, Object> searchOptionMap = new HashMap<>();

            searchOptionMap.put("type", Integer.parseInt(type));
            searchOptionMap.put("brand", Integer.parseInt(brand));
            searchOptionMap.put("sortBy", sorting.get(0));
            searchOptionMap.put("ascDesc", sorting.get(1));
            searchOptionMap.put("offset", 0);



            // 4. 조회옵션으로 신발목록 출력 (페이지네이션)
            List<ShoesDto> shoesList = shoesView.selectShoesList(searchOptionMap);
            // 5. 상세조회
            ShoesDetailDto shoes = shoesView.selectShoesDetail(shoesList);

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
