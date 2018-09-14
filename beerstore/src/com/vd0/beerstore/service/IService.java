package com.vd0.beerstore.service;

import java.util.List;

public interface IService<T> {
	
	public void adicionarCliente(T t);
	
	public void editar(T t) throws ServiceException;
	
	public void deletar(Long id) throws ServiceException;
	
	public T buscaPorId(Long id) throws ServiceException;
	
	public List<T> listarTodos();
	
}
