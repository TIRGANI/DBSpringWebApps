package iir4.g3.cours.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Projet {
	@Id
	private int idProjet;
	private String description;
	
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	
	
	public int getIdProjet() {
		return idProjet;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}