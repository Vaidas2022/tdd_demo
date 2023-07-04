package lt.codeacademy.javau5.tdd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	@Autowired
	DaiktasRepository repo;
	
	public Daiktas getDaiktas() {		
		return new Daiktas();
	}

	public Daiktas saveDaiktas(Daiktas daiktas) {
		
		return repo.save(daiktas);
	}

	public Daiktas getById(Long id) {		
		return repo.findById(id).orElse(null);
	}

	public List<Daiktas> getAll() {		
		return repo.findAll();
	}
	
	

}
