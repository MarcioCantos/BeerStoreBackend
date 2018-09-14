package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import com.vd0.beerstore.entity.beer.Cerveja;

public class CervejaDao implements Dao<Cerveja> {
	
	static EntityManager em = Conexao.getInstance().createEntityManager();

	@Override
	public void adicionar(Cerveja t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Cerveja t) {
		try {
			buscaPorId(t.getId());				
			em.merge(t);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}

	@Override
	public void excluir(Cerveja t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cerveja> listar() {
		return em.createQuery("select a from Cerveja a").getResultList();
	}

	@Override
	public Cerveja buscaPorId(Long id) {
		return em.find(Cerveja.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cerveja> listarPorAtributo(){
		return em.createQuery("select a from Cerveja a").getResultList();
	}

}
