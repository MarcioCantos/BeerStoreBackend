package com.vd0.beerstore.dao;

import java.util.List;

public interface Dao<T> {
	
	public void adicionar(T t);

	public void editar(T t);

	public void excluir(T t);

	public List<T> listar();
	
	public T buscaPorId(Long id);


}
