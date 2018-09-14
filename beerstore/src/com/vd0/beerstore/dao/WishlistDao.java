package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.beer.Wishlist;

public class WishlistDao implements Dao<Wishlist> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();

	@Override
	public void adicionar(Wishlist t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Wishlist t) {
		try {
			buscaPorId(t.getId());
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage().toString();
		}		
		
	}

	@Override
	public void excluir(Wishlist t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Wishlist> listar() {
		return em.createQuery("select a from Wishlist a").getResultList();
	}

	@Override
	public Wishlist buscaPorId(Long id) {
		return em.find(Wishlist.class, id);
	}

}
