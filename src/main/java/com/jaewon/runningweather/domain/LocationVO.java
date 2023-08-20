package com.jaewon.runningweather.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LocationVO {
    private String nx;
    private String ny;

    public LocationVO(String nx, String ny) {
        this.nx = nx;
        this.ny = ny;
    }
}
