package com.emsi.microService;

import com.emsi.microService.entities.Compte;
import com.emsi.microService.enums.AccountType;
import com.emsi.microService.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
     @Bean
	CommandLineRunner start(CompteRepository compteRepo){
		return args -> {
			for(int i =0;i<10;i++){
				Compte compte = Compte.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.courant:AccountType.epargne)
						.currency("MAD")
						.solde(10000+Math.random()*90000)
						.dateCreation(new Date())
						.build();
				compteRepo.save(compte);
			}
		};
	 }
}
