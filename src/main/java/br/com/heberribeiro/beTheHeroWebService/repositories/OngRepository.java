package br.com.heberribeiro.beTheHeroWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.heberribeiro.beTheHeroWebService.domain.Ong;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {

}
