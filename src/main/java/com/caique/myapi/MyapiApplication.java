package com.caique.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caique.myapi.domain.Usuario;
import com.caique.myapi.repositories.UsuarioRepository;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario0 = new Usuario(null, "Caique Moreira", "caiquemo", "1234");
		Usuario usuario1 = new Usuario(null, "Caique Leite", "caiquemole", "1234");
		
		usuarioRepository.saveAll(Arrays.asList(usuario0, usuario1));
	}

}
