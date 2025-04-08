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
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int shoesPrice;
    private String size;
    private Integer quantity;

}
