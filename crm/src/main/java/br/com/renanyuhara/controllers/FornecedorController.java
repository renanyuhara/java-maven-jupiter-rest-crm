package br.com.renanyuhara.controllers;

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

import br.com.renanyuhara.crm_application.FornecedorService;
import br.com.renanyuhara.crm_viewmodel.FornecedorViewModel;

@Path("/")
public class FornecedorController {
	
	private static FornecedorService _fornecedorService = new FornecedorService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FornecedorViewModel> readAll() {
		return _fornecedorService.listarFornecedores();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FornecedorViewModel read(@PathParam("id") int id) {
		return _fornecedorService.buscarFornecedor(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public FornecedorViewModel create(FornecedorViewModel fornecedor) {
		return _fornecedorService.inserirFornecedor(fornecedor);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public FornecedorViewModel update(@PathParam("id") int id, FornecedorViewModel fornecedor) {
		return _fornecedorService.atualizarFornecedor(id, fornecedor);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		_fornecedorService.excluirFornecedor(id);
	}
}
