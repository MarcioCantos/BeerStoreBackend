package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.TipoCerveja;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class TipoCervejaService implements IService<TipoCerveja> {
	
	Dao<TipoCerveja> tipoCervejaDao = FabricaDao.createDaoTipoCerveja();

	@Override
	public void adicionarCliente(TipoCerveja t) {
		tipoCervejaDao.adicionar(t);
		
	}

	@Override
	public void editar(TipoCerveja t) throws ServiceException {
		if(t.getId() == null) {
			throw new ServiceException("Tipo de Cerveja inexistente.");
		}
		tipoCervejaDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		if(id == null) {
			throw new ServiceException("Tipo de Cerveja inexistente.");
		}
		tipoCervejaDao.excluir(buscaPorId(id));
		
	}

	@Override
	public TipoCerveja buscaPorId(Long id) throws ServiceException {
		return tipoCervejaDao.buscaPorId(id);
	}

	@Override
	public List<TipoCerveja> listarTodos() {
		return tipoCervejaDao.listar();
	}

}
