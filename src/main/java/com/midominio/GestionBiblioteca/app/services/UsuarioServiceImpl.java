package com.midominio.GestionBiblioteca.app.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.midominio.GestionBiblioteca.app.models.dao.UsuarioDao;
import com.midominio.GestionBiblioteca.app.models.entities.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	public List<Usuario> listar() {
		return (List<Usuario>)usuarioDao.findAll();
	}

	@Override
	public Page<Usuario> listar(Pageable pageable) {
		return usuarioDao.findAll(pageable);
	}



	

	

	










}
