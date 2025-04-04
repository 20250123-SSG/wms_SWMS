package com.swms.store.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StoreDto {
    private int onlineWarehouseId;
    private int shoesId;
    private int quantity;
}
