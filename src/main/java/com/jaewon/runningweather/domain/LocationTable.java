package com.jaewon.runningweather.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LocationTable {
    private static final HashMap<String, LocationVO> map = new HashMap<>();

    public LocationTable() {
        map.put("seoul", new LocationVO("60", "127"));
        map.put("busan", new LocationVO("98","76"));
        map.put("daegu", new LocationVO("89","90"));
        map.put("incheon", new LocationVO("55","124"));
        map.put("gwangju", new LocationVO("58","74"));
        map.put("daejeon", new LocationVO("67","100"));
        map.put("ulsan", new LocationVO("102","84"));
        map.put("sejong", new LocationVO("66","103"));
        map.put("gyeonggi", new LocationVO("60","120"));
        map.put("chungcheongNorth", new LocationVO("69","107"));
        map.put("chungcheongSouth", new LocationVO("68","100"));
        map.put("jeonraNorth", new LocationVO("63","89"));
        map.put("jeonraSouth", new LocationVO("51","67"));
        map.put("kyeongsangNorth", new LocationVO("89","91"));
        map.put("kyeongsandSouth", new LocationVO("91","77"));
        map.put("jeju", new LocationVO("52","38"));
        map.put("kangwon", new LocationVO("73","134"));
    }

    public static LocationVO getLocation(String location) {
        return map.get(location);
    }
}
