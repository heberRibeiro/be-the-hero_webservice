package br.com.heberribeiro.beTheHeroWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.domain.UserOng;
import br.com.heberribeiro.beTheHeroWebService.repositories.OngRepository;
import br.com.heberribeiro.beTheHeroWebService.repositories.UserOngRepository;

@Service
public class OngService {
	
	@Autowired
	private OngRepository ongRepository;
	
	@Autowired
	private UserOngRepository userOngRepository;
	
	
	public List<Ong> findAll(Pageable pageable) {		
		return ongRepository.findAll(pageable).getContent();		
	}
	
	public Ong insert(Ong ong, Integer user_ong_id) {
		ong.setId(null);
		UserOng userOng = userOngRepository.getOne(user_ong_id);
		ong.setUserOng(userOng);
		userOng.getOngs().add(ong);
		Ong obj = ongRepository.save(ong);
		
		return obj;
	}

}
