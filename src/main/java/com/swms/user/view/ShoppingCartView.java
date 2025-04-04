package com.swms.user.view;

import com.swms.user.controller.ShoppingCartController;
import com.swms.user.model.dto.ShoppingCartDto;


import java.util.List;

public class ShoppingCartView {
    public static void checkCartList(List<ShoppingCartDto> list){
        System.out.println(list);
        if (list.isEmpty()){
            System.out.println("==장바구니가 아직 등록되지 않았습니다==");
        }else {
            for (ShoppingCartDto cart : list){
                System.out.printf("%s\t%d\t%d",
                        cart.getShoesName(),
                        cart.getShoesPrice(),
                        cart.getSize());

            }


        }
    }
}
