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

import com.vd0.beerstore.entity.Endereco;
import com.vd0.beerstore.service.Facade;
import com.vd0.beerstore.service.ServiceException;

import io.swagger.annotations.Api;

@Path("/enderecorest")
@Api(value="/enderecorest")
public class EnderecoRest implements IRest<Endereco> {
	
	// http://localhost:8080/beerstore/rest
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void adicionar(Endereco endereco) {
		try {
			new Facade().adicionarEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Endereco endereco) {
		try {
			new Facade().editarEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void excluir(Long id) {
		try {
			new Facade().excluirEndereco(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> listar() throws ServiceException {
		return new Facade().listarEndereco();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> listarPorCliente(@PathParam("id") Long id) throws ServiceException {
		return new Facade().listarEnderecoPorCliente(id);
	}

	@Override
	public Endereco buscarPorId(Long id) throws ServiceException {
		return new Facade().buscarEnderecoPorId(id);
	}
}
