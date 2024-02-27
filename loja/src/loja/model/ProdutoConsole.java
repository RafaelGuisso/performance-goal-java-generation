package loja.model;

public class ProdutoConsole extends Produto{

	private String marca;

	public ProdutoConsole(int id, int tipo, String produto, float preco, String marca) {
		super(id, tipo, produto, preco);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Marca do Console: " + this.marca);
	}
    
}