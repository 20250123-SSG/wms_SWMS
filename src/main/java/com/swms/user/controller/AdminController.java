package com.swms.user.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.user.model.dto.UserDto;
import com.swms.user.model.service.AccountService;
import com.swms.user.model.service.AdminService;
import com.swms.user.view.AdminView;
import com.swms.user.view.ResultView;

import java.util.Map;

public class AdminController {
    private AdminService admintService = new AdminService();

    public void registShoes(Map<String, String> requestParam) {
        // 요청시 전달된 데이터 => MenuDto 옮기기
        ShoesDto menu = ShoesDto.builder()
                .shoesId(Integer.valueOf(requestParam.get("id")))
                .shoesTypeId(Integer.valueOf(requestParam.get("typeid")))
                .brandId(Integer.valueOf(requestParam.get("brand")))
                .shoesName(requestParam.get("name"))
                .shoesPrice(requestParam.get("price"))
                .size(Integer.parseInt(requestParam.get("size")))
                .build();

        int result = admintService.registShoes(menu);
        ResultView.displayResult("신발 등록", result);

    }

    public void modifyShoes(Map<String, String> requestParam) {
        ShoesDto menu = ShoesDto.builder()
                .shoesId(Integer.valueOf(requestParam.get("id")))
                .shoesTypeId(Integer.valueOf(requestParam.get("typeid")))
                .brandId(Integer.valueOf(requestParam.get("brand")))
                .shoesName(requestParam.get("name"))
                .shoesPrice(requestParam.get("price"))
                .size(Integer.parseInt(requestParam.get("size")))
                .build();

        int result = admintService.modifyShoes(menu);
        ResultView.displayResult("신발 수정", result);
    }
    public void removeShoes(String id) {

        int result = admintService.removeShoes( Integer.parseInt(id) );
        ResultView.displayResult("신발 삭제", result);

    }

}
