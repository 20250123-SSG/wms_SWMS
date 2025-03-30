package com.offline.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class ShoesDto {
    private String shoeCode;
    private String brandNo;
    private String shoeNo;
    private String categort;
    private String shoeName;
    private int price;
    private int size;
}
