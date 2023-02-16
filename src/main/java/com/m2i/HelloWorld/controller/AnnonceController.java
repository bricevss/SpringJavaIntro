package com.m2i.HelloWorld.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.HelloWorld.entity.Annonce;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {
	
//	List<Annonce> annonces = new ArrayList<>();
//	
//	@GetMapping
//	public List<Annonce> getAll(){
//		return annonces;
//	}
//	
//	@GetMapping("/{id}")
//	public Annonce getById(@PathVariable int id) {
//		return annonces.get(id);
//	}
//	
//	@PostMapping
//	public void addAnnonce(@RequestBody Annonce a) {
//		annonces.add(a);
//	}
//	
//	@PutMapping("/{id}")
//	public void updateAnnonce(@RequestBody Annonce a, @PathVariable ("id") int id) {
//		Annonce annoncesList = annonces.get(id);
//		
//		annoncesList.setTitre(a.getTitre());
//		annoncesList.setDescription(a.getDescription());
//		annoncesList.setPrice(a.getPrice());
//		annoncesList.setDate(a.getDate());
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteAnnonce(@PathVariable ("id") int id) {
//		annonces.remove(id);
//	}
		
	@GetMapping
	public static List<Annonce> getAll(){

		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			return em.createQuery("From Annonce", Annonce.class).getResultList();
		}
		finally {
			
		}
	}
	
	@GetMapping("/{id}")
	public static Annonce getById(@PathVariable int id) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	

			return em.find(Annonce.class, id);
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}

	}
	
	@PostMapping
	public void addAnnonce(@RequestBody Annonce a) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();

			em.persist(a);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}

	}
	
	@PutMapping("/{id}")
	public void updateAnnonce(@RequestBody Annonce a, @PathVariable ("id") int id) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Annonce annoncesList = em.find(Annonce.class, id);
			
			annoncesList.setTitre(a.getTitre());
			annoncesList.setDescription(a.getDescription());
			annoncesList.setPrice(a.getPrice());
			annoncesList.setDate(a.getDate());

			
			em.persist(annoncesList);
			
			trans.commit();
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
			
		}
	
	@DeleteMapping("/{id}")
	public void deleteAnnonce(@PathVariable ("id") int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();	
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			Annonce a = em.find(Annonce.class, id);
			em.remove(a);
			trans.commit();
			
		}finally {
			if(em!=null) em.close();
			if(emf!=null) emf.close();
		}
	}
	
}
