package com.swms.shoes.model.dto;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShoesDetailDto extends ShoesDto {
    private List<Integer> sizeList;
}
