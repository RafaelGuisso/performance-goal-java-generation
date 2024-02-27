package loja.model;

public class ProdutoJogo extends Produto{

	private int aniversario;

	public ProdutoJogo(int id, int tipo, String produto, float preco, int aniversario) {
		super(id, tipo, produto, preco);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Ano de Lançamento do jogo " + this.aniversario);
	}
    
}
