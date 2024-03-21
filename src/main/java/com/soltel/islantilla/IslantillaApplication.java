package com.soltel.islantilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class IslantillaApplication {

	@RequestMapping(value = "/inicio")
    public String index() {
        return "<h1>Bienvenidos a Islantilla!</h1>";
    }
	
	@RequestMapping(value = "/menu")
    public String menu() {
        return "<h1>Menu Principal</h1>";
    }
	
	@RequestMapping(value = "/fin")
    public String fin() {
        return "<h1>Fin Aplicación</h1>";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(IslantillaApplication.class, args);
	}

}
