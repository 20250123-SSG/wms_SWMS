package com.swms.shoes.controller;

import com.swms.shoes.model.dto.ShoesDto;
import com.swms.shoes.model.service.ShoesManagementService;
import com.swms.user.view.ResultView;

import java.util.Map;

public class ShoesManagementController {
    private ShoesManagementService shoesManagementService = new ShoesManagementService();

    public void registShoes(Map<String, String> requestParam) {
        ShoesDto menu = ShoesDto.builder()
                .shoesId(Integer.valueOf(requestParam.get("id")))
                .shoesTypeId(Integer.valueOf(requestParam.get("typeid")))
                .brandId(Integer.valueOf(requestParam.get("brand")))
                .shoesName(requestParam.get("name"))
                .shoesPrice(requestParam.get("price"))
                .size(Integer.parseInt(requestParam.get("size")))
                .build();

        int result = shoesManagementService.registShoes(menu);
        ResultView.displayResult("신발 등록", result);

    }

    public void modifyShoes(Map<String, String> requestParam) {
        ShoesDto menu = ShoesDto.builder()
                .shoesId(Integer.valueOf(requestParam.get("id")))
                .shoesName(requestParam.get("name"))
                .shoesPrice(requestParam.get("price"))
                .size(Integer.parseInt(requestParam.get("size")))
                .build();

        int result = shoesManagementService.modifyShoes(menu);
        ResultView.displayResult("신발 수정", result);
    }
    public void removeShoes(String id) {

        int result = shoesManagementService.removeShoes( Integer.parseInt(id) );
        ResultView.displayResult("신발 삭제", result);

    }

}
