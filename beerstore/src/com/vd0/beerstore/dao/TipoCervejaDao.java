package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.beer.TipoCerveja;

public class TipoCervejaDao implements Dao<TipoCerveja> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();

	@Override
	public void adicionar(TipoCerveja t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(TipoCerveja t) {
		try {
			buscaPorId(t.getId());
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage().toString();
		}		
	}

	@Override
	public void excluir(TipoCerveja t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoCerveja> listar() {
		return em.createQuery("select a from TipoCerveja a").getResultList();
	}

	@Override
	public TipoCerveja buscaPorId(Long id) {
		return em.find(TipoCerveja.class, id);
	}
	
}
