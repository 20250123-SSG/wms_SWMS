package com.swms.store.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OfflineSaleStatsDto {
    private String date;        // 일자 또는 월 (예: 2025-04-07 또는 2025-04)
    private int totalQuantity;  // 총 판매 수량
    private int totalRevenue;   // 총 매출액
}