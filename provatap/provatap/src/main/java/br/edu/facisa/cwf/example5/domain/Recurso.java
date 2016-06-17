package br.edu.facisa.cwf.example5.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recurso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6764010918958690360L;
	
	
	@Id
	private String id;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String destiny;
	
	public Recurso(){}

	public Recurso(String id, String name, String destiny) {
		super();
		this.id = id;
		this.name = name;
		this.destiny = destiny;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestiny() {
		return destiny;
	}

	public void setDestiny(String destiny) {
		this.destiny = destiny;
	};
	
	
	
}
