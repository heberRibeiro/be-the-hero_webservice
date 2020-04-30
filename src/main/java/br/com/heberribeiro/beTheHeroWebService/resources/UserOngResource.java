package br.com.heberribeiro.beTheHeroWebService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.heberribeiro.beTheHeroWebService.domain.UserOng;
import br.com.heberribeiro.beTheHeroWebService.services.UserOngService;

@RestController
@RequestMapping
public class UserOngResource {

	@Autowired
	private UserOngService userOngService;

	@GetMapping(value = "/users")
	public ResponseEntity<List<UserOng>> findAll() {
		List<UserOng> users = userOngService.findAll();

		return ResponseEntity.ok().body(users);

	}

}
