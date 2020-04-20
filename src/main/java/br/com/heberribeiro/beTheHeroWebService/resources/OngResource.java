package br.com.heberribeiro.beTheHeroWebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.repositories.OngRepository;

@RestController
@RequestMapping
public class OngResource {
	
	@Autowired
	private OngRepository ongRepository;
	
	@GetMapping(value = "/ongs")
	public ResponseEntity<List<Ong>> findAll() {
		
		List<Ong> ongs = ongRepository.findAll();
		
		return ResponseEntity.ok().body(ongs);		
	}

}
