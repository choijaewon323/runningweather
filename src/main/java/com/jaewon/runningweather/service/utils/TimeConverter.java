package com.jaewon.runningweather.service.utils;

public class TimeConverter {
    public static String convert(String time) {
        StringBuilder result = new StringBuilder(time.substring(0, 2));

        if (result.charAt(0) == '0' && result.charAt(1) == '0') {
            return "2300";
        }

        if (result.charAt(1) == '0') {
            result.setCharAt(1, '9');
            char temp = result.charAt(0);
            int ch = (int) temp;
            result.setCharAt(0, (char)(ch - 1));
        } else {
            char temp = result.charAt(1);
            int ch = (int) temp;
            result.setCharAt(1, (char)(ch - 1));
        }

        result.append("00");
        return result.toString();
    }
}
