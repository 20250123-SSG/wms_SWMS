package com.swms.user.model.dto;

public class CartOptionDto {
    private Integer shoesTypeId;
    private Integer brandId;

    public CartOptionDto(Integer brandId, Integer shoesTypeId) {
        this.brandId = brandId;
        this.shoesTypeId = shoesTypeId;
    }
}
