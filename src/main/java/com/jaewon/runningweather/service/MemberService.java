package com.jaewon.runningweather.service;

import com.jaewon.runningweather.domain.Member;
import com.jaewon.runningweather.dto.MemberRequestDto;
import com.jaewon.runningweather.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void register(MemberRequestDto memberRequestDto) {
        memberRepository.save(new Member(memberRequestDto.getEmail(), memberRequestDto.getLocation(), memberRequestDto.getReservedTime()));
    }
}
