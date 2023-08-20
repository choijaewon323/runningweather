package com.jaewon.runningweather.controller;

import com.jaewon.runningweather.dto.MemberRequestDto;
import com.jaewon.runningweather.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/v1/api/member")
    public void create(@RequestBody MemberRequestDto memberRequestDto) {
        memberService.register(memberRequestDto);
    }
}
