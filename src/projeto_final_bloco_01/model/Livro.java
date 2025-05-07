package projeto_final_bloco_01.model;

public class Livro extends Item{

	String genero;
	
	public Livro(int id, int tipo, String titulo, float preco, String genero) {
		super(id, tipo, titulo, preco);
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	//personalizar o método da superclasse para o item Livro em específico
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Gênero do Item: " + this.genero);
	}
}
