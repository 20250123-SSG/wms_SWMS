package com.swms.shoes.model.dto;

public class ShoesOptionDto {
    private Integer shoesTypeId;
    private Integer brandId;

    public ShoesOptionDto(Integer brandId, Integer shoesTypeId) {
        this.brandId = brandId;
        this.shoesTypeId = shoesTypeId;
    }
}
