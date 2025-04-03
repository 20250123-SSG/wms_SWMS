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
    private String shoesPrice;
    private Integer size;

    // 맨처음 brand와


    public ShoesDto(String shoesName, String shoesPrice) {
        this.shoesName = shoesName;
        this.shoesPrice = shoesPrice;
    }

}

