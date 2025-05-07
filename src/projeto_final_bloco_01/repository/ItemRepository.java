package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Item;

public interface ItemRepository {
	
	public void cadastrarItem(Item novoItem);           //CREATE
	public void procurarItemPorId(int id);              //READ
	public void listarTodoAcervo();                     //READ
	public void atualizarItem(Item itemAtualizado);     //UPDATE
	public void apagarItem(int id);                     //DELETE
}
