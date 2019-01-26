package br.com.renanyuhara.crm_data;

import java.util.ArrayList;
import java.util.List;

import br.com.renanyuhara.crm_viewmodel.FornecedorViewModel;

public class FornecedorRepository {
	private List<FornecedorViewModel> _fornecedores = new ArrayList<FornecedorViewModel>();
	
	public FornecedorRepository(List<FornecedorViewModel> fornecedores) {
		_fornecedores = fornecedores;
	}
	
	public FornecedorViewModel get(int id) {
		FornecedorViewModel fornecedorEncontrado = null;

		if (_fornecedores.size() > 0) {
			int indiceEncontrado = buscarIndiceDoFornecedorEmLista(id);
			if (indiceEncontrado >= 0) {
				fornecedorEncontrado = _fornecedores.get(indiceEncontrado);
			}
			
		}
		return fornecedorEncontrado;
	}
	
	public List<FornecedorViewModel> getAll() {
		return _fornecedores;
	}
	
	public FornecedorViewModel insert(FornecedorViewModel fornecedor) {
		fornecedor.setId(getNextId());
		_fornecedores.add(fornecedor);
		return fornecedor;
	}
	
	public FornecedorViewModel update(int id, FornecedorViewModel fornecedor) {
		FornecedorViewModel fornecedorEncontrado = get(id);
		
		if (fornecedorEncontrado != null) {
			fornecedor.setId(id);
			int posicaoNaLista = _fornecedores.indexOf(fornecedorEncontrado);
			_fornecedores.set(posicaoNaLista, fornecedor);
		}			

		return fornecedor;
	}
	
	public void delete(int id) {
		if (_fornecedores.size() > 0) {
			int indiceParaExcluir = buscarIndiceDoFornecedorEmLista(id);
			if (indiceParaExcluir >= 0) {
				_fornecedores.remove(indiceParaExcluir);
			}
		}
	}
	
	private int getLastId() {
 		int lastId = 0;
 		for(FornecedorViewModel fornecedor: _fornecedores) {
 			if (fornecedor.getId() > lastId) {
 				lastId = fornecedor.getId();
 			}
 		}
 		return lastId;
	}
	
	private int getNextId() {
		return getLastId() + 1;
	}
	
	private int buscarIndiceDoFornecedorEmLista(int id) {
		int indice = -1;

		if (_fornecedores.size() > 0) {
			for(int x = 0; x<_fornecedores.size();x++) {
				if (_fornecedores.get(x).getId() == id) {
					indice = x;
					break;
				}
			}
		}
		return indice;
	}
}
