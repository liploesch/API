package com.filipeloesch.application.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.filipeloesch.application.entities.User;
import com.filipeloesch.application.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria", "maria@gmail.com", "999999999");
		User u2 = new User(null, "Filipe", "filipe@gmail.com", "888888888");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
