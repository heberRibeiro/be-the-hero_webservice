package br.com.heberribeiro.beTheHeroWebService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.heberribeiro.beTheHeroWebService.domain.Incident;
import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.repositories.IncidentRepository;
import br.com.heberribeiro.beTheHeroWebService.repositories.OngRepository;
import br.com.heberribeiro.beTheHeroWebService.services.exceptions.ObjectNotFoundException;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository incidentRepository;

	@Autowired
	private OngRepository ongRepository;

	public List<Incident> findAll() {
		return incidentRepository.findAll();
	}

	public Incident insert(Incident incident, Integer ong_id) {
		incident.setId(null);
		Ong ong = ongRepository.getOne(ong_id);
		incident.setOng(ong);
		ong.getIncidents().add(incident);
		Incident obj = incidentRepository.save(incident);

		return obj;
	}

	public void delete(Integer id) {
		try {
			incidentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Object not exist in data base");
		}
	}

}
