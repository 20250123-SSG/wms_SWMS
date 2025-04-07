package com.swms.store.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StoreDto {
    private int storeId;
    private int userId;
    private String storeName;
    private String storePhone;
    private String storeAddress;
}
