/**
 * 
 */
package com.vd0.beerstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.vd0.beerstore.entity.Endereco;


/**
 * @author Marcio Cantos
 *
 */
public class EnderecoDao implements Dao<Endereco> {

	static EntityManager em = Conexao.getInstance().createEntityManager();	
	
	@Override
	public void adicionar(Endereco t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		
	}

	@Override
	public void editar(Endereco t) {
		try {
			buscaPorId(t.getId());				
			em.merge(t);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.getMessage().toString();
		}
		
	}

	@Override
	public void excluir(Endereco t) {
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listar() {
		return em.createQuery("select a from Endereco a").getResultList();
	}

	@Override
	public Endereco buscaPorId(Long id) {
		return em.find(Endereco.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listarPorCliente(Long id){
		return em.createQuery("SELECT e FROM Endereco e WHERE e.cliente.id = :clienteId")
			    .setParameter("clienteId", id)
			    .getResultList();
	}

}
