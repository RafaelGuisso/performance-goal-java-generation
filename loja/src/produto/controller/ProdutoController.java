package produto.controller;

import java.util.ArrayList;

import loja.model.Produto;
import loja.Repository.LojaRepository;

public class ProdutoController implements LojaRepository {

    /**
     *  Collection listaContas contendo Objetos do tipo Conta
     * */
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int id = 0;
    
    /**
     *  Procurar Conta por numero
     * */
    @Override
    public void procurarPorID(int id) {
        var produtos = buscarNaCollection(id);
		
		if (produtos != null)
			produtos.visualizar();
		else
			System.out.println("\nA O produto número: " + id + " não foi encontrada!");
    }

    /**
     *  Método Listar todas as Contas
     * */
    @Override
    public void listarTodas() {
        for (var produtos : listaProdutos) {
			produtos.visualizar();
		}        
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
        var buscaConta = buscarNaCollection(produtos.getId());
		
		if (buscaConta != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaConta), produtos);
			System.out.println("\nA Produto numero: " + produtos.getId() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA Produto numero: " + produtos.getId() + " não foi encontrada!");
    }

    /**
     *  Apagar Conta
     * */
    @Override
    public void deletar(int numero) {
        var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if(listaProdutos.remove(conta) == true)
				System.out.println("\nA Produto numero: " + numero + " foi deletado com sucesso!");
		}else
			System.out.println("\nA Produto numero: " + numero + " não foi encontrado!");
    }

    @Override
    public void vender(int id, int valor) {
        
        
    }

    @Override
    public void repor(int id, int valor) {
        
        
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
	public void cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vender(int id, int valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repor(int id, int valor) {
		// TODO Auto-generated method stub
		
	}
    
}