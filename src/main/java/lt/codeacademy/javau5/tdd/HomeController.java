package lt.codeacademy.javau5.tdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	MainService service;	
	
	
	@GetMapping("/daiktas")
	public Daiktas getDaiktas() {


		return new Daiktas(1L, "");
	}
	
	
	@GetMapping("/api/daiktai")
	public List<Daiktas> getAll(){
		return service.getAll();
	}
	
}
