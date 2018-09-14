package com.vd0.beerstore.service.beer;

import java.util.List;

import com.vd0.beerstore.dao.Dao;
import com.vd0.beerstore.dao.FabricaDao;
import com.vd0.beerstore.entity.beer.Wishlist;
import com.vd0.beerstore.service.IService;
import com.vd0.beerstore.service.ServiceException;

public class WishlistService implements IService<Wishlist> {
	
	Dao<Wishlist> wishlistDao = FabricaDao.createDaoWishlist();

	@Override
	public void adicionarCliente(Wishlist t) {
		wishlistDao.adicionar(t);
		
	}

	@Override
	public void editar(Wishlist t) throws ServiceException {
		if(t.getId() == null) {
			throw new ServiceException("Wishlist inexistente.");
		}
		wishlistDao.editar(t);
		
	}

	@Override
	public void deletar(Long id) throws ServiceException {
		if(id == null) {
			throw new ServiceException("Wishlist inexistente.");
		}
		wishlistDao.excluir(buscaPorId(id));
		
	}

	@Override
	public Wishlist buscaPorId(Long id) throws ServiceException {
		return wishlistDao.buscaPorId(id);
	}

	@Override
	public List<Wishlist> listarTodos() {
		return wishlistDao.listar();
	}

}
