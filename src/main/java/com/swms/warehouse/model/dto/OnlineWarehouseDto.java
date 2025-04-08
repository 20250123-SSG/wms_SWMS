package com.swms.warehouse.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OnlineWarehouseDto {
    private int onlineWarehouseId;
    private int shoesId;
    private int quantity;
    private String brandName;
    private String shoesType;
    private String shoesName;
    private int size;
}
