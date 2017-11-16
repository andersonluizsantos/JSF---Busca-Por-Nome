package com.fuctura.modulo3.managedbean;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fuctura.modulo3.dao.ProdutoDAO;
import com.fuctura.modulo3.dao.impl.ProdutoDAOImpl;
import com.fuctura.modulo3.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private String nome;
	private Double preco;

	private Produto produto;
	
	private Collection<Produto> produtosSelecionados;

	private ProdutoDAO produtoDAO = new ProdutoDAOImpl();
	
	private Collection<Produto> listaProdutos;

		
	public Collection<Produto> getListaProdutos() {
		return listaProdutos;
	}



	public void pesquisar() {
        
		listaProdutos = produtoDAO.buscarProdutosPorNome(nome);
        
        if (listaProdutos.isEmpty()) {
            System.out.println("Lista Vazia");
        }
    }
	
	
	public String salvar() {

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);

		produtoDAO.salvar(produto);

		return "/produto/listar.xhtml";
	}

	public Collection<Produto> buscarPorNome() {		
		return produtoDAO.buscarProdutosPorNome(nome);
	}
	
	
	
	public ProdutoBean() {
		this.produto = new Produto();
		this.nome = "";
		//this.produtosSelecionados = new Collection<Produto>();
	}



	public String excluir() {

		produtoDAO.remover(produto.getId());

		return "/produto/listar.xhtml";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getProdutos() {
		return produtoDAO.buscarTodos();
	}

	public Collection<Produto> getProdutosSelecionados() {
		return produtoDAO.buscarProdutosPorNome(nome);
	}

	

}
