package br.com.renanyuhara.crm_domain_tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.renanyuhara.crm_data.FornecedorRepository;
import br.com.renanyuhara.crm_domain.FornecedorManager;
import br.com.renanyuhara.crm_viewmodel.FornecedorViewModel;

@DisplayName("Unit tests for Domain: Fornecedor")
public class FornecedorManagerTests {
	@Test
	@DisplayName("Listar todos os fornecedores deve trazer 1 registro")
	void testar() throws Exception {
		FornecedorManager manager = createFakeManager();
		manager.inserirFornecedor(createFakeFornecedor());
		List<FornecedorViewModel> lista = manager.listarTodosFornecedores();
		assertTrue(lista.size() == 1);
	}
	
	@Test
	@DisplayName("Listar todos os fornecedores não deve trazer registros.")
	void listarTodosFornecedoresNenhumTest() {
		FornecedorManager manager = createFakeManager();
		List<FornecedorViewModel> lista = manager.listarTodosFornecedores();
		assertTrue(lista.size() == 0);
	}
	
	@Test
	@DisplayName("Incluir deve trazer o registro com id 1.")
	void incluirDeveTrazerRegitro1Test() throws Exception {
		FornecedorManager manager = createFakeManager();
		manager.inserirFornecedor(createFakeFornecedor());
		List<FornecedorViewModel> lista = manager.listarTodosFornecedores();
		assertTrue(lista.get(0).getId() == 1);
	}
	
	@Test
	@DisplayName("Alterar deve trazer o nome diferente para o mesmo id.")
	void alterarDeveTrazerNomeDiferenteMesmoId() throws Exception {
		FornecedorManager manager = createFakeManager();
		FornecedorViewModel fornecedorInsert = createFakeFornecedor();
		String originalName = fornecedorInsert.getName();
		int originalId = manager.inserirFornecedor(fornecedorInsert).getId();
		FornecedorViewModel fornecedorUpdate = createFakeFornecedor();
		fornecedorUpdate.setName(originalName + " a test ");
		fornecedorUpdate = manager.atualizarFornecedor(originalId, fornecedorUpdate);
		String afterUpdateName = fornecedorUpdate.getName();
		int afterUpdateId = fornecedorUpdate.getId();
		assertTrue((originalName != afterUpdateName) && (originalId == afterUpdateId));
	}
	
	@Test
	@DisplayName("Excluir deve remover apenas 1 item.")
	void excluirDeveRemoverApenas1Item() throws Exception {
		FornecedorManager manager = createFakeManager();
		manager.inserirFornecedor(createFakeFornecedor());
		int chosenId = manager.inserirFornecedor(createFakeFornecedor()).getId();
		manager.inserirFornecedor(createFakeFornecedor());
		int qtdeRegistrosPreExclusao = manager.listarTodosFornecedores().size();
		manager.excluirFornecedor(chosenId);
		int qtdeRegistrosPosExclusao = manager.listarTodosFornecedores().size();
		
		assertTrue((qtdeRegistrosPreExclusao - 1) == qtdeRegistrosPosExclusao );
	}
	
	@Test
	@DisplayName("Buscar deve trazer o registro com id 2, nome YYYY e outros dados originais.")
	void buscarDeveTrazerORegistroId2NomeYYYY() throws Exception {
		FornecedorManager manager = createFakeManager();
		manager.inserirFornecedor(createFakeFornecedor());
		
		FornecedorViewModel chosenFornecedor = createFakeFornecedor();
		chosenFornecedor.setName("YYYY");
		int chosenId = manager.inserirFornecedor(chosenFornecedor).getId();
		
		manager.inserirFornecedor(createFakeFornecedor());
		
		FornecedorViewModel foundFornecedor = manager.buscarFornecedor(chosenId);
		
		boolean resultTest =foundFornecedor.getName() == "YYYY" &&
				foundFornecedor.getCnpj() == "111111" &&
				foundFornecedor.getEmail() == "email@email.com" &&
				foundFornecedor.getComment() == "no comment"; 
		
		assertTrue(resultTest);
	}
	
	private FornecedorViewModel createFakeFornecedor() {
		FornecedorViewModel fornecedor = new FornecedorViewModel();
		fornecedor.setName("Teste");
		fornecedor.setId(1000);
		fornecedor.setCnpj("111111");
		fornecedor.setComment("no comment");
		fornecedor.setEmail("email@email.com");
		return fornecedor;
	}
	
	private FornecedorManager createFakeManager() {
		List<FornecedorViewModel> fornecedores = new ArrayList<FornecedorViewModel>();
		FornecedorRepository fornecedorRepository = new FornecedorRepository(fornecedores);
		FornecedorManager fornecedorManager = new FornecedorManager(fornecedorRepository);
		return fornecedorManager;
	}
}
