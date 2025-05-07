package projeto_final_bloco_01.model;

public class Revista extends Item{

	int edicao;
	
	public Revista(int id, int tipo, String titulo, float preco, int edicao) {
		super(id, tipo, titulo, preco);
		this.edicao = edicao;
	}
	
	public int getEdicao() {
		return this.edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	//personalizar o método da superclasse para o item Livro em específico
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Edição da Item: " + this.edicao + "\n");
	}
}
