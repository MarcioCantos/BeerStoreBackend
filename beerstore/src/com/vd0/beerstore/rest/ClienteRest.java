package com.vd0.beerstore.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vd0.beerstore.entity.Cliente;
import com.vd0.beerstore.entity.Endereco;
import com.vd0.beerstore.service.Facade;
import com.vd0.beerstore.service.ServiceException;

import io.swagger.annotations.Api;

@Path("/clienterest")
@Api(value="/clienterest")
public class ClienteRest implements IRest<Cliente> {

	// http://localhost:8080/beerstore/rest
	
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void adicionar(Cliente cliente) {
		
		try {
			for(Endereco e: cliente.getEnderecos()) {
				e.setCliente(cliente);
			}
			new Facade().adicionarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Cliente cliente) {
		try {
			new Facade().editarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@PathParam("id") Long id) {	
		try {
			new Facade().excluirCliente(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar() throws ServiceException {
		return new Facade().listarClientes();
	}
	
	@Override
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(@PathParam("id") Long id) throws ServiceException {
		return new Facade().buscarClientePorId(id);
	}
	
}
