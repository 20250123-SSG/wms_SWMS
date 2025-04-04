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
}

