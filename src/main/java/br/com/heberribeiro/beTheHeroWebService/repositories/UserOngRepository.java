package br.com.heberribeiro.beTheHeroWebService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.heberribeiro.beTheHeroWebService.domain.UserOng;

@Repository
public interface UserOngRepository extends JpaRepository<UserOng, Integer> {

}
