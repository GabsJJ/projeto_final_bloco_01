package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ItemController;
import projeto_final_bloco_01.model.Item;
import projeto_final_bloco_01.model.Livro;
import projeto_final_bloco_01.model.Revista;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		ItemController itensController = new ItemController();

		//variáveis auxiliares
		int opcao, id, tipo, edicao;
		float preco;
		String titulo, genero;
		
		//Dados para mock
		Livro li = new Livro(itensController.gerarId(), 1, "2001: Uma Odisséia no Espaço", 50f, "Ficção Científica");	
		Revista rev = new Revista(itensController.gerarId(), 2, "Revista piauí", 35f, 320);
		itensController.cadastrarItem(li);
		itensController.cadastrarItem(rev);
		
		while (true) {

			System.out.println("*******************************************************");
			System.out.println("     Biblioteca de Alexandria - Queima de estoque!     ");
			System.out.println("*******************************************************");
			System.out.println("    1 - Cadastrar Item                                 ");
			System.out.println("    2 - Listar todo o acervo                           ");
			System.out.println("    3 - Buscar item por ID (Código de identificação)   ");
			System.out.println("    4 - Atualizar Dados de um Item                     ");
			System.out.println("    5 - Apagar um Item                                 ");
			System.out.println("    0 - Sair                                           ");
			System.out.println("*******************************************************");
			System.out.print("Digite o número da opção desejada: ");
			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nAplicação encerrada.");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar item\n");
					
				System.out.print("Digite o título do Item: ");
				leia.skip("\\R");
				titulo = leia.nextLine();
				
				System.out.print("Digite o tipo do Item (1 - Livro | 2 - Revista): ");
				tipo = leia.nextInt();
				
				if(tipo > 0 && tipo <= 2) {
					System.out.print("Digite o preço do Item: ");
					preco = leia.nextFloat();

					switch (tipo) {
						case 1 -> {
							System.out.print("Digite o Gênero: ");
							leia.skip("\\R");
							genero = leia.nextLine();
							var asd = new Livro(itensController.gerarId(), tipo, titulo, preco, genero);
							itensController.cadastrarItem(asd);
							asd.visualizar();
						}
						case 2 -> {
							System.out.print("Digite o número da Edição: ");
							leia.skip("\\R");
							edicao = leia.nextInt();
							itensController.cadastrarItem(new Revista(itensController.gerarId(), tipo, titulo, preco, edicao));
						}
					}
				} else 
					System.out.println("Tipo inválido!");
				
				keyPress();
				break;
			case 2:
				System.out.println("Listar todo o acervo\n");
				itensController.listarTodoAcervo();
				keyPress();
				break;
			case 3:
				System.out.println("Buscar Item por ID - Código de identificação\n");
				
				System.out.print("Digite o ID do Item: ");
				id = leia.nextInt();

				itensController.procurarItemPorId(id);
				
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Dados de um Item\n");
				System.out.print("Digite o id do produto: ");
				id = leia.nextInt();

				Optional<Item> item = itensController.buscarNaBaseDeDados(id);
	
				if(item.isPresent()) {
					tipo = item.get().getTipo();
					
					System.out.print("Digite o novo título do Item: ");
					leia.skip("\\R");
					titulo = leia.nextLine();
	
					System.out.print("Digite o novo preço do Item: ");
					preco = leia.nextFloat();
	
					switch (tipo) {
						case 1 -> {
							System.out.print("Digite o novo Gênero: ");
							leia.skip("\\R");
							genero = leia.nextLine();
							itensController.atualizarItem(new Livro(id, tipo, titulo, preco, genero));
						}
						case 2 -> {
							System.out.print("Digite o novo número da Edição: ");
							leia.skip("\\R");
							edicao = leia.nextInt();
							itensController.atualizarItem(new Revista(id, tipo, titulo, preco, edicao));
						}
					}
				} else
					System.out.printf("\n O Item ID %d não existe!", id);
				
				keyPress();
				break;
			case 5:
				System.out.println("Apagar um Item\n");
				
				System.out.print("Digite o ID do Item: ");
				id = leia.nextInt();
				itensController.apagarItem(id);
				
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		
		System.out.println(" _________________________________________");
		System.out.println("|Projeto Desenvolvido por:                |");
		System.out.println("|Gabriel Julio - gabrielj@genstudents.org |");
		System.out.println("|github.com/GabsJJ                        |");
		System.out.println(" -----------------------------------------");
	}
	
	public static void keyPress() {
	    try {
	        System.out.println("\nPressione Enter para Continuar...");
	        
	        int input;
	        while ((input = System.in.read()) != '\n') {
	            if (input == -1) {
	                throw new IOException("Entrada encerrada com erro");
	            }
	        }
	        
	    } catch (IOException e) {
	        System.err.println("Erro de entrada/saída: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
	    }
	}

}