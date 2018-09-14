package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.Imagens;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class ImagensService implements IService<Imagens> {
	
	Dao<Imagens> imagensDao = FabricaDao.createDaoImagens();

	@Override
	public void adicionarCliente(Imagens t) {
		imagensDao.adicionar(t);
		
	}

	@Override
	public void editar(Imagens t) throws ServiceException {
		if(t.getId() == null) {
			throw new ServiceException("Imagem inexistente.");
		}
		imagensDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		if(id == null) {
			throw new ServiceException("Wishlist inexistente.");
		}
		imagensDao.excluir(buscaPorId(id));
	}

	@Override
	public Imagens buscaPorId(Long id) throws ServiceException {
		return imagensDao.buscaPorId(id);
	}

	@Override
	public List<Imagens> listarTodos() {
		return imagensDao.listar();
	}

}
