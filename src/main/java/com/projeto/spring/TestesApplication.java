package com.projeto.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projeto.spring.domain.Role;
import com.projeto.spring.domain.Usuario;
import com.projeto.spring.repositories.RoleRepository;
import com.projeto.spring.repositories.UsuarioRepository;

@SpringBootApplication
public class TestesApplication implements CommandLineRunner {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UsuarioRepository userRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(TestesApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Raífe Ferreira", "17125834760", "raife.tec@gmail.com", new BCryptPasswordEncoder().encode("123"));
		Usuario user2 = new Usuario(null, "Miro Grajauma", "25874196360", "mrgrau@gmail.com", new BCryptPasswordEncoder().encode("123"));
		Usuario user3 = new Usuario(null, "Joselito Silva", "96332114760", "silva.joselito@gmail.com", new BCryptPasswordEncoder().encode("123"));
		Usuario user4 = new Usuario(null, "Andressa martins", "98714785260", "dressa_martins@gmail.com", new BCryptPasswordEncoder().encode("123"));
		
		Role role1 = new Role(null, "ROLE_ADMIN");
		Role role2 = new Role(null, "ROLE_OPERACIONAL");
		Role role3 = new Role(null, "ROLE_TERCEIRO");
		
		
		//user1.getRoles().addAll(Arrays.asList(role1));
		role1.getUsuarios().addAll(Arrays.asList(user1, user4));
		role2.getUsuarios().addAll(Arrays.asList(user2));
		role3.getUsuarios().addAll(Arrays.asList(user3));
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		roleRepository.saveAll(Arrays.asList(role1, role2, role3));
		
		
		
	}

}
