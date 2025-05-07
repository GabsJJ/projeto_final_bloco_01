package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int opcao, id, tipo;
		float preco;
		String nome;
		
		while (true) {

			System.out.println("*******************************************************");
			System.out.println("   Biblioteca de Alexandria - Compre antes que suma!   ");
			System.out.println("*******************************************************");
			System.out.println("    1 - Cadastrar Item                                 ");
			System.out.println("    2 - Listar todo o acervo                           ");
			System.out.println("    3 - Buscar item por ID (Código de identificação)   ");
			System.out.println("    4 - Atualizar Dados de um Item                     ");
			System.out.println("    5 - Apagar um Item                                 ");
			System.out.println("    0 - Sair                                           ");
			System.out.println("*******************************************************");
			System.out.print("Digite o número da opção desejada:                       ");
			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\n");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar item\n\n");
				keyPress();
				break;
			case 2:
				System.out.println("Listar todo o acervo\n\n");
				keyPress();
				break;
			case 3:
				System.out.println("Buscar Item por ID - Código de identificação\n\n");
				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Dados de um Item\n\n");
				keyPress();
				break;
			case 5:
				System.out.println("Apagar um Item\n\n");
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
	    try {
	        System.out.println("\n\nPressione Enter para Continuar...");
	        
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