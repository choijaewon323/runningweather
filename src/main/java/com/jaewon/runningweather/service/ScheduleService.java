package com.jaewon.runningweather.service;

import com.jaewon.runningweather.domain.Member;
import com.jaewon.runningweather.repository.MemberRepository;
import com.jaewon.runningweather.service.utils.MailProcessor;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService {
    private final MemberRepository memberRepository;

    public ScheduleService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Seoul")
    @Transactional
    public void run0() throws JSONException, IOException {
        List<Member> memberList = memberRepository.findAll();

        MailProcessor.process(memberList);
    }
}
