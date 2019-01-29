package br.com.renanyuhara.crm_application;

import java.util.ArrayList;
import java.util.List;

import br.com.renanyuhara.crm_data.FornecedorRepository;
import br.com.renanyuhara.crm_domain.FornecedorManager;
import br.com.renanyuhara.crm_viewmodel.FornecedorViewModel;

public class FornecedorService {
	
	
	private FornecedorManager _fornecedorManager;
	
	public FornecedorService() {
		FornecedorRepository _fornecedorRepository = new FornecedorRepository(new ArrayList<FornecedorViewModel>());
		_fornecedorManager = new FornecedorManager(_fornecedorRepository);
	}
	
	public List<FornecedorViewModel> listarFornecedores() {
		return _fornecedorManager.listarTodosFornecedores();
	}
	
	public FornecedorViewModel buscarFornecedor(int id) {
		return _fornecedorManager.buscarFornecedor(id);
	}
	
	public FornecedorViewModel inserirFornecedor(FornecedorViewModel fornecedor) throws Exception {
		return _fornecedorManager.inserirFornecedor(fornecedor);
	}
	
	public FornecedorViewModel atualizarFornecedor(int id, FornecedorViewModel fornecedor) throws Exception {
		return _fornecedorManager.atualizarFornecedor(id, fornecedor);
	}
	
	public void excluirFornecedor(int id) {
		_fornecedorManager.excluirFornecedor(id);
	}

}
