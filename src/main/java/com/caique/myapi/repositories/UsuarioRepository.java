package com.caique.myapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caique.myapi.domain.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
