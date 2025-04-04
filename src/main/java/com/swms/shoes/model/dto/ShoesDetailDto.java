package com.swms.shoes.model.dto;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoesDetailDto {
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int shoesPrice;
    private List<Integer> sizeList;
}
