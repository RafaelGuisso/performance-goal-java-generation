package loja.model;

public class Produto {
  
  private int id;
	private int tipo;
	private String produto;
	private float preco;

	public Produto(int id, int tipo, String produto, float preco) {
		this.id = id;
		this.tipo = tipo;
		this.produto = produto;
		this.preco = preco;
	}
	
	public Produto() {}

	public int getId() {
		return id;
	}

	public void setId(int numero) {
		this.id = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String titular) {
		this.produto = titular;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {

		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = "Consoles";
		break;
		case 2:
			tipo = "Jogos";
		break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("ID: " + this.id);
		System.out.println("Tipo de Produto: " + tipo);
		System.out.println("Nome do Produto: " + this.produto);
		System.out.println("Preço: " + this.preco);

	}
  
}