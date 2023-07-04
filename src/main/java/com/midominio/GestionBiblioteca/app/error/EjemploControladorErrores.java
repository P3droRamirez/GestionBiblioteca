package com.midominio.GestionBiblioteca.app.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class EjemploControladorErrores {

	
	@GetMapping("/probandoerror404")
	public String error404(Model model) {
		return "error/404";
	}

	@GetMapping("/vistanoexiste")
	public String m2(Model model) {
		return "noexiste";
	}
	
	@GetMapping("/null-pointer")
	public String m3() {
		String s = null;
		s.length();
		// como no va a llegar al return, saltará antes el otro error
		return "template-no existe";
	}
}
