package loja.Repository;

import loja.model.Produto;

public interface LojaRepository {

	public void procurarPorNumero(int id);
	public void listarTodas();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);
	
	public void vender(int id, float valor);
	public void repor(int id, float valor);
	
}
