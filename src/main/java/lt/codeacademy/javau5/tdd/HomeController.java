package lt.codeacademy.javau5.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/daiktas")
	public Daiktas getDaiktas() {

		return new Daiktas(1L, "");
	}
	
}
