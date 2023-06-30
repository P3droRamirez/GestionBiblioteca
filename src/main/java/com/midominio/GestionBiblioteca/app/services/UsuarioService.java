package com.midominio.GestionBiblioteca.app.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

public interface UsuarioService {

	List<Usuario> listar();
	Page<Usuario> listar(Pageable pageable);
	List<Usuario> findByLogin (String login);
	List<Usuario> findByEmail (String email);
	List<Usuario> findByDireccion (String direccion);
}
