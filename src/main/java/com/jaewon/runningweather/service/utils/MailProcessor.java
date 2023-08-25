package com.jaewon.runningweather.service.utils;

import com.jaewon.runningweather.domain.LocationTable;
import com.jaewon.runningweather.domain.LocationVO;
import com.jaewon.runningweather.domain.Member;
import com.jaewon.runningweather.domain.NameTable;
import com.jaewon.runningweather.dto.WeatherResponseDto;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MailProcessor {
    public static void process(List<Member> memberList) throws JSONException, IOException {

        if (memberList == null) {
            return;
        }

        for (Member member : memberList) {
            String email = member.getEmail();
            String location = member.getLocation();
            LocationVO locationVO = LocationTable.getLocation(location);
            String reservedTime = member.getReservedTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Calendar calendar = Calendar.getInstance();

            if (reservedTime.equals("0000")) {
                calendar.add(Calendar.DATE, -1);
            }

            String today = sdf.format(calendar.getTime());

            String subTime = TimeConverter.convert(reservedTime);

            List<WeatherResponseDto> responseDtos = ApiExplorer.explore(today, subTime, locationVO.getNx(), locationVO.getNy());

            StringBuilder result = new StringBuilder();

            result.append(NameTable.getName(location));
            result.append("의 날씨\n");

            for (WeatherResponseDto responseDto : responseDtos) {
                result.append(responseDto.getFcstTime());
                result.append(" : ");
                result.append(responseDto.getWeather());
                result.append('\n');
            }

            MailSender.send(String.valueOf(result), email);
        }
    }
}
