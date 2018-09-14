package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.Cliente;


/**
 * @author Marcio Cantos.
 *
 */
public class ClienteDao implements Dao<Cliente> {
	
	//Cria Entity Manager para utilização
	static EntityManager em = Conexao.getInstance().createEntityManager();	
	

	/**
	 * Adiciona Cliente a base de dados
	 */
	@Override
	public void adicionar(Cliente t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Cliente t) {
		try {
			buscaPorId(t.getId());				
			em.merge(t);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}

	@Override
	public void excluir(Cliente t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		return em.createQuery("select a from Cliente a").getResultList();
	}

	@Override
	public Cliente buscaPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	

}
