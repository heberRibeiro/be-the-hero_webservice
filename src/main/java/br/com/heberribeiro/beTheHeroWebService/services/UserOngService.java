package br.com.heberribeiro.beTheHeroWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heberribeiro.beTheHeroWebService.domain.UserOng;
import br.com.heberribeiro.beTheHeroWebService.repositories.UserOngRepository;

@Service
public class UserOngService {
	
	@Autowired
	private UserOngRepository userOngRepository;
	
	
	public List<UserOng> findAll() {		
		return userOngRepository.findAll();		
	}

}
