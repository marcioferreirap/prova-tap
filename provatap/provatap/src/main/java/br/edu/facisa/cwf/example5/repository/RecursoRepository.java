package br.edu.facisa.cwf.example5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.facisa.cwf.example5.domain.Recurso;


public interface RecursoRepository extends JpaRepository<Recurso, String>{

	public Repository findByName(String name);
	public Repository findByNameAndDestiny(String name, String destiny);
	
}
