package com.vd0.beerstore.service;

import java.util.List;

import com.vd0.beerstore.entity.Cliente;
import com.vd0.beerstore.entity.Endereco;


public class Facade {

	//Cliente Service
	public void adicionarCliente(Cliente cliente) throws ServiceException {
		new ClienteService().adicionarCliente(cliente);
	}
	
	public void editarCliente(Cliente cliente) throws ServiceException {
		new ClienteService().editar(cliente);
	}
	
	public void excluirCliente(Long id) throws ServiceException {
		new ClienteService().deletar(id);
	}
	
	public Cliente buscarClientePorId(Long id) throws ServiceException {
		return new ClienteService().buscaPorId(id);
	}
	
	public List<Cliente> listarClientes() throws ServiceException {
		return new ClienteService().listarTodos();
	}
	
	//Endereço Service
	public void adicionarEndereco(Endereco endereco) throws ServiceException {
		new EnderecoService().adicionarCliente(endereco);
	}
	
	public void editarEndereco(Endereco endereco) throws ServiceException {
		new EnderecoService().editar(endereco);
	}
	
	public void excluirEndereco(Long id) throws ServiceException {
		new EnderecoService().deletar(id);
	}	
	
	public List<Endereco> listarEndereco() throws ServiceException {
		return new EnderecoService().listarTodos();
	}
	
	public List<Endereco> listarEnderecoPorCliente(Long id) throws ServiceException {
		return new EnderecoService().listarPorCliente(id);
	}
	
	public Endereco buscarEnderecoPorId(Long id) throws ServiceException {
		return new EnderecoService().buscaPorId(id);
	}
	
}
