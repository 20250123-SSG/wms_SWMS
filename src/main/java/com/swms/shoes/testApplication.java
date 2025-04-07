package com.swms.shoes;

import com.swms.shoes.controller.ShoesController;
import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.view.ShoesMenuView;
import com.swms.user.model.dto.UserDto;

public class testApplication {
    public static void main(String[] args) {

        ShoesController shoesController = new ShoesController();
        UserDto user = new UserDto(4, "qwer",1,"010-9378-8677", "rewq", 215000);
        ShoesDto shoes = new ShoesDto(2,"나이키","스니커즈","에어 맥스 90",159000,"230");
        shoesController.insertToCart(user, shoes);

    }
}
