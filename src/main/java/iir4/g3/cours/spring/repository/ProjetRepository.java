package iir4.g3.cours.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iir4.g3.cours.spring.model.Projet;


@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer>{

}
