package com.offline.dto;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class OfflineStackDto {
    private int no;
    private String shoeCode;
    private String storeCode;
    private int quantity;
}
