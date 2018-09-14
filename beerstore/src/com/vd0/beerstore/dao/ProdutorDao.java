package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.beer.Produtor;

public class ProdutorDao implements Dao<Produtor> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();

	@Override
	public void adicionar(Produtor t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Produtor t) {
		try {
			buscaPorId(t.getId());
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}

	@Override
	public void excluir(Produtor t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produtor> listar() {
		return em.createQuery("select a from Produtor a").getResultList();
	}

	@Override
	public Produtor buscaPorId(Long id) {
		return em.find(Produtor.class, id);
	}

}
