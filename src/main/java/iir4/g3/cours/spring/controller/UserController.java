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
import iir4.g3.cours.spring.model.Utilisateur;
import iir4.g3.cours.spring.repository.ProjetRepository;
import iir4.g3.cours.spring.repository.UserRepository;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public void ajouter(@RequestBody Utilisateur p)
	{
		System.out.print("User "+p.getNom());
		userRepository.save(p);
	}
	@GetMapping
	public List<Utilisateur> get()
	{
		return userRepository.findAll();
	}
	@PutMapping
	public void modifier(@RequestBody Utilisateur p)
	{
		Utilisateur pp = userRepository.findById(p.getId()).get();
		if(pp!=null)
		{
			pp.setNom(p.getNom());
			pp.setEmail(p.getEmail());
			userRepository.save(pp);
		}
		
	}
	@DeleteMapping("/{id}")
	public void suppr(@PathVariable int id)
	{
		userRepository.deleteById(id);
		
	}
	@GetMapping("/{id}")
	public Utilisateur get(@PathVariable int id)
	{
		return userRepository.findById(id).get();
		
	}
	
}
