package com.fuctura.modulo3.dao;

import java.util.Collection;

import com.fuctura.modulo3.model.Produto;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public Produto buscar(Long id);

	public Collection<Produto> buscarTodos();

	public void atualizar(Produto produto);

	public void remover(Long id);
	
	public Collection<Produto> buscarProdutosPorNome(String nome);
}
