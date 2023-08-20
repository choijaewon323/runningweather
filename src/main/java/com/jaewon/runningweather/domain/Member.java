package com.jaewon.runningweather.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "RESERVED_TIME")
    private String reservedTime;

    public Member(String email, String location, String reservedTime) {
        this.email = email;
        this.location = location;
        this.reservedTime = reservedTime;
    }
}
