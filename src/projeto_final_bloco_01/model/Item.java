package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Item {
	
	int id, tipo;
	String titulo;
	float preco;

	public Item(int id, int tipo, String titulo, float preco) {
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";
		switch (this.tipo) {
			case 1 -> tipo = "Livro";
			case 2 -> tipo = "Revista";
			default -> tipo = "Inválido";
		}

		System.out.println("*****************************************************");
		System.out.println("                   Dados do item                     ");
		System.out.println("*****************************************************");
		System.out.println("Id do Item: " + this.id);
		System.out.println("Título do Item: " + this.titulo);
		System.out.println("Tipo do Item: " + tipo);
		System.out.println("Preço do Item: " + nfMoeda.format(this.preco));
	}
}
