package com.swms.shoes.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoesOrderDto {
    // shoes_id와 size가 정해진 단 하나의 신발에 대한 정보 (Order로 넘겨줄 dto)
    private Integer shoesId;
    private ShoesDto shoes;
    private String size;
}
