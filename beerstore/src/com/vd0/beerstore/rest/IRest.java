package com.vd0.beerstore.rest;

import java.util.List;

import com.vd0.beerstore.service.ServiceException;

public interface IRest<T> {

	public void adicionar(T t);
	
	
	public void editar(T t);
	
	
	public void excluir(Long id);
	
	
	public List<T> listar() throws ServiceException;
		
	public T buscarPorId(Long id) throws ServiceException;
}
