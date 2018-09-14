package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.Atributos;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class AtributosService implements IService<Atributos> {
	
	Dao<Atributos> atributosDao = FabricaDao.createDaoAtributos();

	@Override
	public void adicionarCliente(Atributos t) {
		atributosDao.adicionar(t);
		
	}

	@Override
	public void editar(Atributos t) throws ServiceException {
		if(t.getId() == null) {
			throw new ServiceException("Cliente inexistente.");
		}
		
		atributosDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		if(id == null) {
			throw new ServiceException("Cliente inexistente.");
		}
		
		atributosDao.excluir(buscaPorId(id));
		
	}

	@Override
	public Atributos buscaPorId(Long id) throws ServiceException {
		return atributosDao.buscaPorId(id);
	}

	@Override
	public List<Atributos> listarTodos() {
		return atributosDao.listar();
	}

}
