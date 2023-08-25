package com.jaewon.runningweather.service;

import com.jaewon.runningweather.domain.Member;
import com.jaewon.runningweather.repository.MemberRepository;
import com.jaewon.runningweather.service.utils.MailProcessor;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ScheduleService {
    private final MemberRepository memberRepository;

    public ScheduleService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Scheduled(cron = "0 0 0-23 * * *", zone = "Asia/Seoul")
    @Transactional
    public void run() throws JSONException, IOException {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String reservedTime = now.format(formatter);

        List<Member> memberList = memberRepository.findByReservedTime(reservedTime);

        MailProcessor.process(memberList);
    }
}
