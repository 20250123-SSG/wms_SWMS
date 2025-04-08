package com.swms.store.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OfflineSaleDto {
    private int offlineSaleId;
    private int storeId;
    private int shoesId;
    private int quantity;
    private LocalDateTime saleDate;
    private String storeName;
    private String storePhone;
    private String storeAddress;
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int shoesPrice;
    private String size;
}
