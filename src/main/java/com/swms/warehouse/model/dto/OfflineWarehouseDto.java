package com.swms.warehouse.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OfflineWarehouseDto {
    private int offlineWarehouseId;
    private int storeId;
    private int shoesId;
    private int quantity;
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int size;
}
