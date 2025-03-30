package com.offline.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class StoreDto {
    private String storeCode;
    private String storeName;
    private String manaGer;
    private String storePhone;
    private String storeAddress;
}
