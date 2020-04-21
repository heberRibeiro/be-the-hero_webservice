package br.com.heberribeiro.beTheHeroWebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.services.OngService;

@RestController
@RequestMapping
public class OngResource {
	
	@Autowired
	private OngService ongService;
	
	@GetMapping(value = "/ongs")
	public ResponseEntity<List<Ong>> findAll() {
		
		List<Ong> ongs = ongService.findAll();
		
		return ResponseEntity.ok().body(ongs);		
	}
	
	@PostMapping(value = "/ongs")
	public ResponseEntity<Void> insert(@RequestBody Ong ong) {
		Ong obj = ongService.insert(ong);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
