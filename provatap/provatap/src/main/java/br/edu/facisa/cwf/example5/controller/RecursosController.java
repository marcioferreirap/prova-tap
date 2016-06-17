package br.edu.facisa.cwf.example5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example5.domain.Recurso;
import br.edu.facisa.cwf.example5.service.RecursoService;

@RestController
public class RecursosController {

	private final RecursoService recursoService;

	@Autowired
	public RecursosController(final RecursoService recursoService) {
		this.recursoService = recursoService;
	}
	
	@RequestMapping(value="/recurso", method = RequestMethod.GET)
	
	public ResponseEntity< List<Recurso> > listAllUsers() {
		return new ResponseEntity< List<Recurso> >
		(recursoService.listAllRecursos(), HttpStatus.OK);
	}
	@RequestMapping(value = "/recurso/{id}",method = RequestMethod.GET)
	public ResponseEntity<Recurso> getUser(@PathVariable String id) {
		
		Recurso recurso = recursoService.getById(id);
		
		return recurso == null ? 
				new ResponseEntity<Recurso>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Recurso>(recurso, HttpStatus.OK);
	}
	
	@RequestMapping(value="/recurso", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Recurso recurso) {

		try {
			recursoService.save(recurso);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/recurso", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody Recurso r) {

		try {
			recursoService.update(r);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "recurso/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Recurso> deleteUserPorId(@PathVariable String id) {
		try {
			Recurso recurso = recursoService.getById(id);
			recursoService.deleteById(recurso);
			
			return new ResponseEntity<Recurso>(recurso, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Recurso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public RecursoService getUserService() {
		return recursoService;
	}
	
}
