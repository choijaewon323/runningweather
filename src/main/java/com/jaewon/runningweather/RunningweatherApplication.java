package com.jaewon.runningweather;

import com.jaewon.runningweather.service.utils.ApiExplorer;
import com.jaewon.runningweather.service.utils.MailSender;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@EnableScheduling
@SpringBootApplication
public class RunningweatherApplication {

	public static void main(String[] args) throws IOException, JSONException {
		SpringApplication.run(RunningweatherApplication.class, args);
	}

}
