package br.com.heberribeiro.beTheHeroWebService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.heberribeiro.beTheHeroWebService.domain.Incident;
import br.com.heberribeiro.beTheHeroWebService.domain.Ong;
import br.com.heberribeiro.beTheHeroWebService.repositories.IncidentRepository;
import br.com.heberribeiro.beTheHeroWebService.repositories.OngRepository;

@SpringBootApplication
public class BeTheHeroWebServiceApplication implements CommandLineRunner {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private OngRepository ongRepository;

	public static void main(String[] args) {
		SpringApplication.run(BeTheHeroWebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Ong ong1 = new Ong(null, "Ong 01", "email 01", "whatsapp 01", "city 01", "uf 01");
		Ong ong2 = new Ong(null, "Ong 02", "email 02", "whatsapp 02", "city 02", "uf 02");
		
		Incident inc01 = new Incident(null, "Incident 01", "description 01", 150.0, ong1);
		Incident inc02 = new Incident(null, "Incident 02", "description 02", 200.0, ong1);
		Incident inc03 = new Incident(null, "Incident 03", "description 03", 170.0, ong2);
		
		List<Incident> incidents = new ArrayList<>();
		incidents.add(inc01);
		incidents.add(inc02);
		
		ong1.getIncidents().addAll(Arrays.asList(inc01, inc02));
		ong2.getIncidents().addAll(Arrays.asList(inc03));
		
		ongRepository.saveAll(Arrays.asList(ong1, ong2));
		incidentRepository.saveAll(Arrays.asList(inc01, inc02, inc03));
		
		
	}

}
