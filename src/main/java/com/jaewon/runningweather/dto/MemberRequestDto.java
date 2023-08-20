package com.jaewon.runningweather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String email;
    private String location;
    private String reservedTime;

    public MemberRequestDto(String email, String location, String reservedTime) {
        this.email = email;
        this.location = location;
        this.reservedTime = reservedTime;
    }
}
