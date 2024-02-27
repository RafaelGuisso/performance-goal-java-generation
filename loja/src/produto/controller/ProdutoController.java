package produto.controller;

import java.util.ArrayList;

import loja.model.Produto;
import loja.Repository.LojaRepository;

public class ProdutoController implements LojaRepository {

    /**
     *  Collection listaprodutos contendo Objetos do tipo Produto
     * */
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int id = 0;
    
    /**
     *  Procurar Produto por id
     * */
    @Override
    public void procurarPorId(int id) {
        var produtos = buscarNaCollection(id);
		
		if (produtos != null)
			produtos.visualizar();
		else
			System.out.println("\nA O produto número: " + id + " não foi encontrada!");
    }



    /** 
     * Método Cadastrar no Conta
     * */
    @Override
    public void cadastrar(Produto produtos) {
		listaProdutos.add(produtos);
		System.out.println("\nA Produto número: " + produtos.getId() + " foi criada com sucesso!");
    }

    /**
     * Atualizar dados da Conta
     * */
    @Override
    public void atualizar(Produto produtos) {
        var buscaProduto = buscarNaCollection(produtos.getId());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produtos);
			System.out.println("\nA Produto numero: " + produtos.getId() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA Produto numero: " + produtos.getId() + " não foi encontrada!");
    }

    /**
     *  Apagar Conta
     * */
    @Override
    public void deletar(int numero) {
        var produtos = buscarNaCollection(numero);
		
		if (produtos != null) {
			if(listaProdutos.remove(produtos) == true)
				System.out.println("\nA Produto numero: " + id + " foi deletado com sucesso!");
		}else
			System.out.println("\nA Produto numero: " + id + " não foi encontrado!");
    }

	public int gerarNumero() {
		return ++ id;
	}


	public Produto buscarNaCollection(int id) {
		for (var produtos : listaProdutos) {
			if (produtos.getId() == id) {
				return produtos;
			}
		}
		
		return null;
	}

	@Override
	public void procurarPorID(int id) {
		// TODO Auto-generated method stub
		
	}

	public void listarTodas() {
        for (var produtos : listaProdutos) {
			produtos.visualizar();
		} 
		// TODO Auto-generated method stub
	}
	}

    
