package com.midominio.GestionBiblioteca.app.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.midominio.GestionBiblioteca.app.models.dao.UsuarioDao;
import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findByLogin(String login) {
		return null;
	}

	@Override
	public List<Usuario> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByDireccion(String direccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> listar(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
