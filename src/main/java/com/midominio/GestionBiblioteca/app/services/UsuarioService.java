package com.midominio.GestionBiblioteca.app.services;

import java.util.List;

import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

public interface UsuarioService {

	List<Usuario> findByLogin (String login);
	List<Usuario> findByEmail (String email);
	List<Usuario> findByDireccion (String direccion);
}
