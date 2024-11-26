package io.wulfcodes.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.wulfcodes.mvc.model.data.ClubData;

@SpringBootApplication
public class MVCApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MVCApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ClubData clubData = ClubData.getBuilder().setId(567L).setTitle("Swayam").build();
	}
}
