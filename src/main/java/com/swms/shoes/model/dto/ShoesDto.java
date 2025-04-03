package com.swms.shoes.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoesDto {
    private Integer shoesId;
    private Integer shoesTypeId;
    private Integer brandId;
    private String shoesName;
    private Integer shoesPrice;
    private Integer size;

    public ShoesDto(Integer shoesTypeId, Integer brandId) {
        this.shoesTypeId = shoesTypeId;
        this.brandId = brandId;
    }
}

