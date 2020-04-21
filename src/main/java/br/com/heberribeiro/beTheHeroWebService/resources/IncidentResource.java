package br.com.heberribeiro.beTheHeroWebService.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.heberribeiro.beTheHeroWebService.domain.Incident;
import br.com.heberribeiro.beTheHeroWebService.services.IncidentService;

@RestController
@RequestMapping
public class IncidentResource {
	
	@Autowired
	private IncidentService incidentService;
	
	@GetMapping(value = "/incidents")
	public ResponseEntity<List<Incident>> findAll() {
		
		List<Incident> incidents = incidentService.findAll();
		
		return ResponseEntity.ok().body(incidents);		
	}
	
	@PostMapping(value = "/incidents")
	public ResponseEntity<Void> insert(@RequestBody Incident incident, @RequestHeader Integer ong_id) {
		
		Incident obj = incidentService.insert(incident, ong_id);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
	}
	
	@DeleteMapping(value = "/incidents/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		incidentService.delete(id);
		
		return ResponseEntity.noContent().build();		
	}

}
