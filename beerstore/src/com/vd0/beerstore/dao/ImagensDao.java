package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.beer.Imagens;

public class ImagensDao implements Dao<Imagens> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();

	@Override
	public void adicionar(Imagens t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Imagens t) {
		try {
			buscaPorId(t.getId());
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage().toString();
		}	
		
	}

	@Override
	public void excluir(Imagens t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imagens> listar() {
		return em.createQuery("select a from Imagens a").getResultList();
	}

	@Override
	public Imagens buscaPorId(Long id) {
		return em.find(Imagens.class, id);
	}

}
