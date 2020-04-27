package br.com.heberribeiro.beTheHeroWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.repositories.OngRepository;

@Service
public class OngService {
	
	@Autowired
	private OngRepository ongRepository;
	
	
	public List<Ong> findAll(Pageable pageable) {		
		return ongRepository.findAll(pageable).getContent();		
	}
	
	public Ong insert(Ong ong) {
		ong.setId(null);
		Ong obj = ongRepository.save(ong);
		
		return obj;
	}

}
