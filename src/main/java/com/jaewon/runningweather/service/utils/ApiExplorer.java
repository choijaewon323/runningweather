package com.jaewon.runningweather.service.utils;

import com.jaewon.runningweather.dto.WeatherResponseDto;
import com.jaewon.runningweather.service.secret.SecretKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiExplorer {
    private static final String URL = " http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst";

    public static List<WeatherResponseDto> explore(String base_date, String base_time, String nx, String ny)
            throws IOException, JSONException {
        StringBuilder urlBuilder = new StringBuilder(URL);

        String pageNo = "1";
        String numOfRows = "1000";
        String dataType = "json";
        String enc = "UTF-8";

        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + SecretKey.getEncodingKey());
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(pageNo, enc));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, enc)); // 한 페이지 결과 수
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, enc)); // 요청 자료 형식
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(base_date, enc)); // 발표 날짜
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(base_time, enc)); // 발표 시간
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, enc)); // x 좌표값
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, enc)); // y 좌표값

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        System.out.println("응답 코드 : " + conn.getResponseCode());

        BufferedReader rd;

        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        String result = sb.toString();

        System.out.println(result);

        // json parsing

        JSONObject jsonObject = new JSONObject(result);
        String response = jsonObject.getString("response");

        jsonObject = new JSONObject(response);
        String body = jsonObject.getString("body");

        jsonObject = new JSONObject(body);
        String items = jsonObject.getString("items");

        jsonObject = new JSONObject(items);
        JSONArray jsonArray = jsonObject.getJSONArray("item");

        List<WeatherResponseDto> resultList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            String fcstValue = jsonObject.getString("fcstValue");
            String category = jsonObject.getString("category");
            String fcstTime = jsonObject.getString("fcstTime");

            if (category.equals("SKY")) {

                WeatherResponseDto dto = new WeatherResponseDto();

                dto.setFcstTime(fcstTime);
                System.out.print(fcstTime + " : ");
                if (fcstValue.equals("1")) {
                    dto.setWeather("맑음");
                    System.out.println("맑음");
                } else if (fcstValue.equals("2")) {
                    dto.setWeather("비");
                    System.out.println("비");
                } else if (fcstValue.equals("3")) {
                    dto.setWeather("구름");
                    System.out.println("구름");
                } else if (fcstValue.equals("4")) {
                    dto.setWeather("흐림");
                    System.out.println("흐림");
                }

                resultList.add(dto);
            }
        }

        return resultList;
    }
}
