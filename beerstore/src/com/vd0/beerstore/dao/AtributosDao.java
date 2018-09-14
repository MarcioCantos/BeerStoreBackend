package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.beer.Atributos;

public class AtributosDao implements Dao<Atributos> {

	static EntityManager em = Conexao.getInstance().createEntityManager();
	
	@Override
	public void adicionar(Atributos t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Atributos t) {
		try {
			buscaPorId(t.getId());
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}

	@Override
	public void excluir(Atributos t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atributos> listar() {
		return em.createQuery("select a from Cerveja a").getResultList();
	}

	@Override
	public Atributos buscaPorId(Long id) {
		return em.find(Atributos.class, id);
	}
	

}
