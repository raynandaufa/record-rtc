package com.app.recording.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.app.recording.controller" })
public class RecordingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordingApplication.class, args);
	}

}
