package dev.franzon.readlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ReadLockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadLockApplication.class, args);
	}

}
