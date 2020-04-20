package br.com.heberribeiro.beTheHeroWebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heberribeiro.beTheHeroWebService.domain.Incident;
import br.com.heberribeiro.beTheHeroWebService.repositories.IncidentRepository;

@RestController
@RequestMapping
public class IncidentResource {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@GetMapping(value = "/incidents")
	public ResponseEntity<List<Incident>> findAll() {
		
		List<Incident> incidents = incidentRepository.findAll();
		
		return ResponseEntity.ok().body(incidents);		
	}

}
