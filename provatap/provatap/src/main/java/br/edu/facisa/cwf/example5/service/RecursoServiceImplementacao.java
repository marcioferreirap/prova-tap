package br.edu.facisa.cwf.example5.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example5.domain.Recurso;
import br.edu.facisa.cwf.example5.repository.RecursoRepository;

@Service
@Validated
public class RecursoServiceImplementacao implements RecursoService{

	private final RecursoRepository repository;	
	
    @Autowired
    public RecursoServiceImplementacao(final RecursoRepository repository) {
        this.repository = repository;
        
    }
	
	@Override
	@Transactional
    public Recurso save(@NotNull @Valid final Recurso r) {
    	
        Recurso existing;
        boolean idRec = repository.exists(r.getId());
        
        if (idRec) {
        	existing = null;
        	System.out.println("Já tem ID, seu cabra!");
			}else{
            existing = repository.save(r);
            }
    return existing;
    }   	

	@Override
	public Recurso getById(String id) {
		return repository.findOne(id);
	}

	
	
	
	@Override
	public List<Recurso> listAllRecursos() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(final Recurso participante) {
		Recurso existing = repository.findOne(participante.getId());
		if(existing != null)
		{repository.delete(participante);
		}
		
	}

	@Override
	public void update(final Recurso r) {
		Recurso existing = repository.findOne(r.getId()); 
		if(existing != null)
		{  repository.save(r);
		}
		 
	}

}
