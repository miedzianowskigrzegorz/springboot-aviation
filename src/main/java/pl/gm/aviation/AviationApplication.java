package pl.gm.aviation;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.gm.aviation.adapter.persistence.jpa.JpaAirportEntity;
import pl.gm.aviation.adapter.persistence.jpa.JpaAirsideEntity;
import pl.gm.aviation.adapter.persistence.jpa.JpaHangarEntity;
import pl.gm.aviation.adapter.persistence.jpa.JpaPlaneEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AviationApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AviationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
