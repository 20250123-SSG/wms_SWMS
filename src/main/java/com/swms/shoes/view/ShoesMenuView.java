package com.swms.shoes.view;

import com.swms.order.controller.OnlineOrderController;
import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.dto.ShoesOrderDto;
import com.swms.shoes.model.dto.ShoesSelectDto;
import com.swms.shoes.model.dto.ShoesSelectOptionDto;
import com.swms.user.model.dto.UserDto;

import java.util.*;

public class ShoesMenuView {
    private ShoesController shoesController = new ShoesController();
    private OnlineOrderController onlineOrderController = new OnlineOrderController();
    private Scanner sc = new Scanner(System.in);

    private ShoesOptionView optionView = new ShoesOptionView(); // type, brand, sorting 선택
    private ShoesView shoesView = new ShoesView();


    public void MainView(UserDto userDto) {

        while (true) {
            ShoesSelectOptionDto ShoesSelectOptionDto = new ShoesSelectOptionDto();

            String type = optionView.inputType(); // 1. 신발종류 선택
            ShoesSelectOptionDto.setType(Integer.parseInt(type));

            String brand = optionView.inputBrand(); // 2. 브랜드 선택
            ShoesSelectOptionDto.setBrand(Integer.parseInt(brand));

            List<String> sorting = optionView.inputSorting(); // 3. 정렬 선택
            ShoesSelectOptionDto.setSortBy(sorting.get(0));
            ShoesSelectOptionDto.setAscDesc(sorting.get(1));

            // 4. 조회옵션으로 신발목록 출력
            List<ShoesSelectDto> shoesList = shoesView.selectShoesList(ShoesSelectOptionDto);
            // 5. 상세조회
            ShoesDto shoes = shoesView.selectShoesDetail(shoesList);

            // 6. 사용자동작선택 (구매/장바구니)
            String action = userActionView();
            String size = inputSize();

            // 창고포함 신발 정보 들고오기
            ShoesDto orderShoes = shoesController.getShoes(shoes, size); // 사이즈 선택하고, 해당 shoes_id구해서 shoesDto에 set하는 함수

            String buyQuantity = inputQuantity(orderShoes.getQuantity());


            switch (action) {
                case "1":
                    // 구매단으로shoes 넘기기
                    onlineOrderController.checkMoney(userDto, orderShoes);
                    onlineOrderController.checkWarehouseStock(userDto, orderShoes);
                    onlineOrderController.onlineOrder(userDto, orderShoes);
                    break; // 구매하기 (shoes활용)
                case "2":
                    shoesController.insertToCart(userDto, orderShoes);
                    break; // 장바구니
            }

        }


        // 받은 아이디에 선택에 맞게 조회 뿌리기
    }


    public String userActionView() {
        System.out.println(
                """
                        \n
                        ----------------------------------
                        원하시는 기능을 선택하세요.
                        
                        1. 구매하기
                        2. 장바구니 
                        
                        0. 뒤로가기
                        ----------------------------------
                        >> 입력 : """);
        return sc.nextLine();
    }

    public String inputSize() {
        //size 한번더 출력해주면 좋을 듯
        System.out.print("구매하시려는 사이즈를 입력해주세요 (ex. 230): ");
        String size = sc.nextLine();
        return size;
    }

    public String inputQuantity(int warehouseQuantity) {


        while (true) {
            System.out.print("구매하려는 수량를 입력해주세요 : ");
            String quantity = sc.nextLine();

            System.out.println("구매 가능한 수량은 " + warehouseQuantity + "개 입니다.");

            if (warehouseQuantity < Integer.parseInt(quantity)) {
                System.out.println("❗ 구매 가능한 수량보다 많이 입력하였습니다. 다시 입력해주세요.");
            } else {

                return quantity;
            }

        }
    }

}
