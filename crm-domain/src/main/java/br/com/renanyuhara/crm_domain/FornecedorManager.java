package br.com.renanyuhara.crm_domain;

import java.util.List;

import br.com.renanyuhara.crm_data.FornecedorRepository;
import br.com.renanyuhara.crm_viewmodel.FornecedorViewModel;

public class FornecedorManager {
	private FornecedorRepository _fornecedorRepository;
	
	public FornecedorManager(FornecedorRepository fornecedorRepository) {
		_fornecedorRepository = fornecedorRepository;
	}
	
	public List<FornecedorViewModel> listarTodosFornecedores() {
		return _fornecedorRepository.getAll();
	}
	
	public FornecedorViewModel buscarFornecedor(int id) {
		return _fornecedorRepository.get(id);
	}
	
	public FornecedorViewModel inserirFornecedor(FornecedorViewModel fornecedor) throws Exception {
		if (fornecedor.getName().trim().equals("")) {
			throw new Exception("Nome nao informado");
		}
		return _fornecedorRepository.insert(fornecedor);
	}
	
	public FornecedorViewModel atualizarFornecedor(int id, FornecedorViewModel fornecedor) throws Exception {
		if (fornecedor.getName().trim().equals("")) {
			throw new Exception("Nome nao informado");
		}
		return _fornecedorRepository.update(id, fornecedor);
	}
	
	public void excluirFornecedor(int id) {
		_fornecedorRepository.delete(id);
	}

}
