package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.Cerveja;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class CervejaService implements IService<Cerveja> {
	
	Dao<Cerveja> cervejaDao = FabricaDao.createDaoCerveja();

	@Override
	public void adicionarCliente(Cerveja t) {
		cervejaDao.adicionar(t);
		
	}

	@Override
	public void editar(Cerveja t) throws ServiceException {
		if(t.getId() == null) {
			throw new ServiceException("Cerveja inexistente.");
		}
		cervejaDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		if(id == null) {
			throw new ServiceException("Cliente inexistente.");
		}
		cervejaDao.excluir(buscaPorId(id));
		
	}

	@Override
	public Cerveja buscaPorId(Long id) throws ServiceException {
		return cervejaDao.buscaPorId(id);
	}

	@Override
	public List<Cerveja> listarTodos() {
		return cervejaDao.listar();
	}

}
