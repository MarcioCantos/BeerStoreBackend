package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.Produtor;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class ProdutorService implements IService<Produtor> {
	
	Dao<Produtor> produtorDao = FabricaDao.createDaoProdutor();

	@Override
	public void adicionarCliente(Produtor t) {
		produtorDao.adicionar(t);
		
	}

	@Override
	public void editar(Produtor t) throws ServiceException {
		
		if(t.getId() == null) {
			throw new ServiceException("Produtor inexistente.");
		}
		
		produtorDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		
		if(id == null) {
			throw new ServiceException("Produtor inexistente.");
		}
		
		produtorDao.excluir(buscaPorId(id));
		
	}

	@Override
	public Produtor buscaPorId(Long id) throws ServiceException {
		return produtorDao.buscaPorId(id);
	}

	@Override
	public List<Produtor> listarTodos() {
		return produtorDao.listar();
	}

}
