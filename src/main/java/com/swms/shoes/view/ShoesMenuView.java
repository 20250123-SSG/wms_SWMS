package com.swms.shoes.view;

import com.swms.common.AnsiColor;
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


    public String MainView (UserDto userDto) {

        while (true) {
            ShoesSelectOptionDto ShoesSelectOptionDto = new ShoesSelectOptionDto();
            System.out.println(AnsiColor.BRIGHT_BLUE + "=======================================================" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "           👋 신발 쇼핑몰에 오신 것을 환영합니다!👟" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "      아래 단계를 따라 원하는 신발을 조회하고 구매해보세요" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BRIGHT_YELLOW + "              📌 신발을 고르는 순서 안내:" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + """
                       1️⃣ 종류 선택 → 2️⃣ 브랜드 선택 → 3️⃣ 신발 정렬 옵션 선택
                    """ + AnsiColor.RESET);

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

            int buyQuantity = Integer.parseInt(inputQuantity(orderShoes.getQuantity()));

            switch (action) {
                case "1":
                    //  돈 체크하는거
                    onlineOrderController.checkMoney(userDto, orderShoes.getShoesPrice(), buyQuantity);

                    onlineOrderController.onlineOrder(userDto, orderShoes, buyQuantity); // 구매
                    return "\uD83C\uDF89 구매가 완료되었습니다! 감사합니다 \uD83D\uDE0A";
                case "2":
                    shoesController.insertToCart(userDto, orderShoes);
                    return "\uD83E\uDDFA 장바구니에 상품이 담겼습니다!";
            }

        }


        // 받은 아이디에 선택에 맞게 조회 뿌리기
    }


    public String userActionView() {
        String action;

        while (true) {
            System.out.println(AnsiColor.BRIGHT_BLUE + "--------------------------------------------" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_YELLOW + "  원하시는 기능을 선택하세요." + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BRIGHT_WHITE + "  1.  구매하기" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_WHITE + "  2.  장바구니" + AnsiColor.RESET);
            System.out.println();
            System.out.println(AnsiColor.BRIGHT_WHITE + "  0.  뒤로가기" + AnsiColor.RESET);
            System.out.println(AnsiColor.BRIGHT_BLUE + "  ----------------------------------" + AnsiColor.RESET);
            System.out.print(AnsiColor.BRIGHT_WHITE + "  >> 입력 : " + AnsiColor.RESET);
            action = sc.nextLine();

            if (action.equals("1") || action.equals("2") || action.equals("0")) {
                return action;
            }

            System.out.println(AnsiColor.RED + "잘못된 입력입니다. 1, 2, 0 중에서 선택해주세요." + AnsiColor.RESET);
        }
    }

    public String inputSize() {
        //size 한번더 출력해주면 좋을 듯
        System.out.print("구매하시려는 사이즈를 입력해주세요 (ex. 230): ");
        String size = sc.nextLine();
        return size;
    }

    public String inputQuantity(int warehouseQuantity) {


        while (true) {
            try {
                System.out.println(AnsiColor.BRIGHT_BLUE + "📦 구매 가능한 수량은 " + warehouseQuantity + "개 입니다." + AnsiColor.RESET);
                System.out.print(AnsiColor.BRIGHT_WHITE + "🛒 구매하려는 수량을 입력해주세요 : " + AnsiColor.RESET);
                String quantity = sc.nextLine();

                int inputQty = Integer.parseInt(quantity);

                if (inputQty > warehouseQuantity) {
                    System.out.println(AnsiColor.RED + "❗ 구매 가능한 수량보다 많이 입력하였습니다. 다시 입력해주세요." + AnsiColor.RESET);
                } else if (inputQty <= 0) {
                    System.out.println(AnsiColor.RED + "❗ 1개 이상 입력해주세요." + AnsiColor.RESET);
                } else {
                    return quantity;
                }

            } catch (NumberFormatException e) {
                System.out.println(AnsiColor.RED + "❗ 숫자만 입력해주세요." + AnsiColor.RESET);
            }
        }
    }

}
