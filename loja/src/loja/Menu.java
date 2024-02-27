package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import produto.controller.ProdutoController;
import loja.model.ProdutoConsole;
import loja.model.ProdutoJogo;

public class Menu {
	public static void main(String[] args) throws Exception {

		Scanner leia = new Scanner(System.in);
		
		// Minha ideia vai ser de criar uma loja de Video Games
		// Esse seria um produto para ser utilizado pelos funcionários

		// Entrada de dados
		
		ProdutoController produtos = new ProdutoController();
		
		int opcao, id, tipo, aniversario, valor;
		String produto, marca;
		float preco;
		
		
		produtos.cadastrar(Console1);
		produtos.cadastrar(Console2);
		produtos.cadastrar(Jogo1);
		produtos.cadastrar(Jogo2);
		

		while (true) {

			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("                LOJA GENERATION GAMES                ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar Produto                    ");
			System.out.println("            2 - Listar Produtos                      ");
			System.out.println("            3 - Buscar Produto por Número            ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nBem Vindo a LOJA GENERATION GAMES!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Adicionar Produto\n\n");

					System.out.println("Digite o Número do ID do Produto");
					id = leia.nextInt();
					System.out.println("Digite o Nome do Produto: ");
					leia.skip("\\R?");
					produto = leia.nextLine();

					do {
						System.out.println("Digite é um console(1) ou um jogo(2)? ");
						tipo = leia.nextInt();
					} while (tipo < 1 && tipo > 2);

					System.out.println("Qual o preco do produto? (R$): ");
					preco = leia.nextFloat();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite a marca do console");
							marca = leia.next();
							produtos.cadastrar(
								new ProdutoConsole(produtos.gerarNumero(), tipo, produto, preco, marca));
						}
						case 2 -> {
							System.out.println("Digite o ano de lançamento do jogo");
							aniversario = leia.nextInt();
							produtos.cadastrar(new ProdutoJogo(produtos.gerarNumero(), tipo, produto, preco, aniversario));
						}
					}

					keyPress();
					break;
				case 2:
					System.out.println("Listar Produtos\n\n");

					produtos.listarTodas();

					keyPress();
					break;
				case 3:
					System.out.println("Buscar Produto por id\n\n");

					System.out.println("Digite o número do id: ");
					id = leia.nextInt();

					produtos.procurarPorId(id);

					keyPress();
					break;
				case 4:
					System.out.println("Atualizar Dados do Produto\n\n");

					System.out.println("Digite o ID do Produto: ");
					id = leia.nextInt();

					var buscaProduto = produtos.buscarNaCollection(id);

					if (buscaProduto != null) {

						System.out.println("Digite o Nome do Produto: ");
						leia.skip("\\R?");
						produto = leia.nextLine();

						System.out.println("Digite o Preço (R$): ");
						preco = leia.nextFloat();
				
					
						tipo = buscaProduto.getTipo();

						switch (tipo) {
							case 1 -> {
								System.out.println("Digite a marca do console: ");
								marca = leia.next();
								produtos.atualizar(
										new ProdutoConsole(id, tipo, produto, preco, marca));;
							}
							case 2 -> {
								System.out.println("Digite o ano de lançamento do jogo: ");
								aniversario = leia.nextInt();
								produtos.atualizar(
										new ProdutoJogo(id, tipo, produto, preco, aniversario));;
							}
							default ->
								System.out.println("Tipo de conta inválido!");

					} } 
					else
						System.out.println("\nProduto não encontrado!");
					
					keyPress();
					break;
				case 5:

					System.out.println("Apagar Produto\n\n");

					System.out.println("Digite o id do produto: ");
					id = leia.nextInt();

					produtos.deletar(id);

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
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Encerrando");
		System.out.println("-----------------------------------------------------");
	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}