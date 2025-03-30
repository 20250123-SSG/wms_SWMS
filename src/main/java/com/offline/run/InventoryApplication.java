package com.offline.run;
import com.offline.dto.OfflineStackDto;

import com.offline.service.ShoeService;

import java.util.Scanner;
public class InventoryApplication {
    public static void main(String[] args) {
        // 메뉴번호로 메뉴검색
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 신발 번호: ");
        String code = sc.nextLine();

        OfflineStackDto shoes = new ShoeService().shoesSearch(code);
        System.out.println(shoes);
    }


}



