package loja.Repository;

import loja.model.Produto;

public interface LojaRepository {

	public void procurarPorID(int id);
	public void listarTodas();
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public void deletar(int id);
	
	/**
	 *  Procurar Conta por numero
	 * */
	void procurarPorId(int id);
	
}
