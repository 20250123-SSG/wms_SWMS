package com.offline.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class OfflinesaelDto {
    private int saleNo;
    private String shoeCode;
    private String storeCode;
    private int quantity;
    private String saleDate;
}
