package br.edu.facisa.cwf.example5.service;

import java.util.List;

import br.edu.facisa.cwf.example5.domain.Recurso;

public interface RecursoService {

	Recurso save(Recurso recurso);
	Recurso getById(String id);
	List<Recurso> listAllRecursos();
	void deleteById(Recurso recurso);
	void update(Recurso recurso);
	
	
}
