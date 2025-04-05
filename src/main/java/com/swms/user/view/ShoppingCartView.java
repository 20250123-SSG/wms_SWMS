package com.swms.user.view;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.controller.ShoppingCartController;
import com.swms.user.model.dto.ShoppingCartDto;


import java.util.List;

public class ShoppingCartView {
    public static void checkCartList(List<ShoesDto> list){

        if (list.isEmpty()){
            System.out.println("==장바구니가 아직 등록되지 않았습니다==");
        }else {
            for (ShoesDto cart : list){
                System.out.printf("장바구니 :신발명: %s\t가격: %s\t사이즈: %d \n",
                        cart.getShoesName(),
                        cart.getShoesPrice(),
                        cart.getSize());

            }


        }
    }
}
