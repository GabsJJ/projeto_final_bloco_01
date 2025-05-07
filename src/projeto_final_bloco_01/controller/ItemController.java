package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Item;
import projeto_final_bloco_01.repository.ItemRepository;

public class ItemController implements ItemRepository {
	
	//simulação do banco de dados. A estrutura de Lista armazena dados. Mock
	ArrayList<Item> listaItens = new ArrayList<Item>();
	int id = 0;
	
	@Override
	public void cadastrarItem(Item novoItem) {
		listaItens.add(novoItem);
		System.out.println("O Item foi criado com sucesso!");
	}

	@Override
	public void procurarItemPorId(int id) {
		Optional<Item> produto = buscarNaBaseDeDados(id);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.printf("\nO Item do código %d não foi encontrado", id);
	}

	@Override
	public void listarTodoAcervo() {
		for (var item : listaItens) {
			item.visualizar();
		}
	}

	@Override
	public void atualizarItem(Item itemAtualizado) {
		Optional<Item> buscaItem = buscarNaBaseDeDados(itemAtualizado.getId());

		if (buscaItem.isPresent()) {
			listaItens.set(listaItens.indexOf(buscaItem.get()), itemAtualizado);
			System.out.printf("\nO Item Id %d foi atualizado com sucesso!", itemAtualizado.getId());
		} else
			System.out.printf("\nO Item ID %d não foi encontrado", itemAtualizado.getId());
	}

	@Override
	public void apagarItem(int id) {
		Optional<Item> produto = buscarNaBaseDeDados(id);

		if (produto.isPresent()) {
			if (listaItens.remove(produto.get()) == true)
				System.out.printf("\nO Item ID %d foi apagado com sucesso!", id);
		} else
			System.out.printf("\nO Item ID %d não foi encontrado!", id);
	}
	
	
	public int gerarId() {
		return ++id;
	}

	public Optional<Item> buscarNaBaseDeDados(int id) {
		for (var item : listaItens) {
			if (item.getId() == id)
				return Optional.of(item);
		}

		return Optional.empty();
	}
}
