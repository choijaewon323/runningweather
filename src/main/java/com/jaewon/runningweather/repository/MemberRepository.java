package com.jaewon.runningweather.repository;

import com.jaewon.runningweather.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByReservedTime(String reservedTime);
}
