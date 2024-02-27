package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// import conta.controller.ContaController;
// import conta.model.ContaCorrente;
// import conta.model.ContaPoupanca;
// import conta.util.Cores;

public class Menu {
	public static void main(String[] args) throws Exception {

		Scanner leia = new Scanner(System.in);
		
		// Minha ideia vai ser de criar uma loja de Video Games
		// Esse seria um produto para ser utilizado pelos funcionários

		// Entrada de dados
		
		int opcao, id, tipo, aniversario, estoque, valor;
		String produto, marca;
		float preco;

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
			System.out.println("            6 - Efetuar Venda                        ");
			System.out.println("            7 - Repor Estoque                        ");
			System.out.println("            8 - Sair                                 ");
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

			if (opcao == 8) {
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
					System.out.println("Digite o Estoque do Produto");
					estoque = leia.nextInt();

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
			//				contas.cadastrar(
			//						new ContaCorrente(contas.gerarNumero(), tipo, produto, preco, estoque, marca));
						}
						case 2 -> {
							System.out.println("Digite o ano de lançamento do jogo");
							aniversario = leia.nextInt();
			//				contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), tipo, produto, preco, estoque,
			//						aniversario));
						}
					}

					keyPress();
					break;
				case 2:
					System.out.println("Listar Produtos\n\n");

			//		produto.listarTodas();

					keyPress();
					break;
				case 3:
					System.out.println("Buscar Conta por número\n\n");

					System.out.println("Digite o número da conta: ");
					id = leia.nextInt();

			//		contas.procurarPorNumero(id);

					keyPress();
					break;
				case 4:
					System.out.println("Atualizar Dados do Produto\n\n");

					System.out.println("Digite o ID do Produto: ");
					id = leia.nextInt();

			//		var buscaConta = contas.buscarNaCollection(id);
					Integer valorid = id;

					if ( valorid != null) {

						System.out.println("Digite o Nome do Produto: ");
						leia.skip("\\R?");
						produto = leia.nextLine();

						System.out.println("Digite o Preço (R$): ");
						preco = leia.nextFloat();
						
						System.out.println("Digite o Estoque do Produto");
						estoque = leia.nextInt();
					}

			//			tipo = buscaConta.getTipo();

			//			switch (tipo) {
			//				case 1 -> {
			//					System.out.println("Digite a marca do console: ");
			//					String marca1 = leia.next();
				//				contas.cadastrar(
				//						new ContaCorrente(contas.gerarNumero(), tipo, produto, preco, estoque, marca));
			//				}
			//				case 2 -> {
			//					System.out.println("Digite o ano de lançamento do jogo: ");
			//					aniversario = leia.nextInt();
					//			contas.atualizar(new ContaPoupanca(id, tipo, produto, preco, estoque, aniversario));
			//				}
				//			default -> {
			//					System.out.println("Tipo de conta inválido!");
				//			}
				//		}

				//	} else
				//		System.out.println("\nProduto não encontrado!");

			//		keyPress();
			//		break;
				case 5:
					System.out.println("Apagar o Produto\n\n");

					System.out.println("Digite o id do produto: ");
					id = leia.nextInt();

				//	contas.deletar(id);

					keyPress();
					break;
				case 6:
					System.out.println( "Efetuar Venda\n\n");

					System.out.println();
					id = leia.nextInt();

					do {
						System.out.println("Digite a quantidade desse produto vendido: ");
						valor = leia.nextInt();
					} while (valor <= 0);

				//	contas.sacar(id, valor);

					keyPress();
					break;
				case 7:
					System.out.println("Renovação de estoque\n\n");

					System.out.println("Digite o Numero do id: ");
					id = leia.nextInt();

					do {
						System.out.println("Número de estoqeu adicionado ");
						valor = leia.nextInt();
					} while (valor <= 0);

				//	contas.depositar(id, valor);

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