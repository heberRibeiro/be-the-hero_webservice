package br.com.heberribeiro.beTheHeroWebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<Ong>> findAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit, 
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		
		Direction sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.ASC : Direction.DESC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "name"));
		
		List<Ong> ongs = ongService.findAll(pageable);
		
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
