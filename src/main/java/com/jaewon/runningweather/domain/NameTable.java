package com.jaewon.runningweather.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NameTable {
    private static final HashMap<String, String> nameTable = new HashMap<>();

    public NameTable() {
        nameTable.put("seoul", "서울특별시");
        nameTable.put("busan", "부산광역시");
        nameTable.put("daegu", "대구광역시");
        nameTable.put("incheon", "인천광역시");
        nameTable.put("gwangju", "광주광역시");
        nameTable.put("daejeon", "대전광역시");
        nameTable.put("ulsan", "울산광역시");
        nameTable.put("sejong", "세종특별자치시");
        nameTable.put("gyeonggi", "경기도");
        nameTable.put("chungcheongNorth", "충청북도");
        nameTable.put("chungcheongSouth", "충청남도");
        nameTable.put("jeonraNorth", "전라북도");
        nameTable.put("jeonraSouth", "전라남도");
        nameTable.put("kyeongsangNorth", "경상북도");
        nameTable.put("kyeongsandSouth", "경상남도");
        nameTable.put("jeju", "제주특별자치도");
        nameTable.put("kangwon", "강원특별자치도");
    }

    public static String getName(String location) {
        return nameTable.get(location);
    }
}
