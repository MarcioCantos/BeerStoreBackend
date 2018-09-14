package com.vd0.beerstore.service;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.EnderecoDao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.Endereco;


public class EnderecoService implements IService<Endereco> {
	
	Dao<Endereco> enderecoDao = FabricaDao.createDaoEndereco();

	@Override
	public void adicionarCliente(Endereco endereco) {		
		enderecoDao.adicionar(endereco);
	}
	
	@Override
	public void editar(Endereco endereco) throws ServiceException {
		
		if(endereco.getId() == null) {
			throw new ServiceException("Endereço inexistente.");
		}
		//cadastra endereço
		enderecoDao.editar(endereco);		
	}
	
	@Override
	public void deletar(Long id) throws ServiceException {
		
		if(id == null) {
			throw new ServiceException("Endereço inexistente.");
		}
		
		enderecoDao.excluir(buscaPorId(id));		
	}
	
	@Override
	public Endereco buscaPorId(Long id) throws ServiceException {
		return enderecoDao.buscaPorId(id);
	}
	
	@Override
	public List<Endereco> listarTodos(){
		return enderecoDao.listar();
	}
	
	public List<Endereco> listarPorCliente(Long id){
		return new EnderecoDao().listarPorCliente(id);
	}
}
