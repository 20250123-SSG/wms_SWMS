package com.swms.shoes.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ShoesSelectOptionDto {
    private int type;
    private int brand;
    private String sortBy;
    private String ascDesc;
    private int offset;
}

