package com.swms.shoes.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoesDto {
    private int shoesCode;
    private int brandNo;
    private int typeNo;
    private String category;
    private String shoesName;
    private Integer price;
    private Integer size;
}
