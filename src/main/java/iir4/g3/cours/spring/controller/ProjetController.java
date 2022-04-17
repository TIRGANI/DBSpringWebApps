package iir4.g3.cours.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iir4.g3.cours.spring.model.Projet;
import iir4.g3.cours.spring.repository.ProjetRepository;



@RestController
@RequestMapping("/projets")
public class ProjetController {
	@Autowired
	private ProjetRepository projetRepository;

	@PostMapping
	public void ajouter(@RequestBody Projet p)
	{
		System.out.print("Projet "+p.getDescription());
		projetRepository.save(p);
	}
	@GetMapping
	public List<Projet> get()
	{
		return projetRepository.findAll();
	}
	@PutMapping
	public void modifier(@RequestBody Projet p)
	{
		Projet pp = projetRepository.findById(p.getIdProjet()).get();
		if(pp!=null)
		{
			pp.setDescription(p.getDescription());
			projetRepository.save(pp);
		}
		
	}
	@DeleteMapping("/{id}")
	public void suppr(@PathVariable int id)
	{
		projetRepository.deleteById(id);
		
	}
	@GetMapping("/{id}")
	public Projet get(@PathVariable int id)
	{
		return projetRepository.findById(id).get();
		
	}
	
}
