package com.vd0.beerstore.service;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.Cliente;


public class ClienteService implements IService<Cliente> {
	
	Dao<Cliente> clienteDao = FabricaDao.createDaoCliente();
	
	@Override
	public void adicionarCliente(Cliente cliente) {		
		clienteDao.adicionar(cliente);
	}
	
	@Override
	public void editar(Cliente cliente) throws ServiceException {
		
		if(cliente.getId() == null) {
			throw new ServiceException("Cliente inexistente.");
		}
		//cadastra cliente
		clienteDao.editar(cliente);		
	}
	
	@Override
	public void deletar(Long id) throws ServiceException {
		
		if(id == null) {
			throw new ServiceException("Aluno inexistente.");
		}
		
		clienteDao.excluir(buscaPorId(id));		
	}
	
	@Override
	public Cliente buscaPorId(Long id) throws ServiceException {
		return clienteDao.buscaPorId(id);
	}
	
	@Override
	public List<Cliente> listarTodos(){
		return clienteDao.listar();
	}
	
}
