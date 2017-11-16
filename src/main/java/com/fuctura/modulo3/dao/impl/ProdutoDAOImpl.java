package com.fuctura.modulo3.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fuctura.modulo3.dao.ProdutoDAO;
import com.fuctura.modulo3.model.Produto;
import com.fuctura.modulo3.util.JPAUtil;

public class ProdutoDAOImpl implements ProdutoDAO {

	@Override
	public void salvar(Produto produto) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(produto);

		et.commit();
		em.close();
	}

	@Override
	public Produto buscar(Long id) {

		Produto produto = null;

		EntityManager em = JPAUtil.getEntityManager();

		produto = em.find(Produto.class, id);

		em.close();

		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {

		Collection<Produto> produtos = new ArrayList<>();

		EntityManager em = JPAUtil.getEntityManager();

		Query query = em.createQuery("select p from Produto p");
		produtos = query.getResultList();

		em.close();

		return produtos;
	}

	@Override
	public void atualizar(Produto produto) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.merge(produto);

		et.commit();
		em.close();
	}

	@Override
	public void remover(Long id) {

		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Query query = em.createQuery("delete from Produto p where p.id = :id");
		query.setParameter("id", id);

		query.executeUpdate();

		et.commit();
		em.close();
	}

	@Override
	public Collection<Produto> buscarProdutosPorNome(String nome) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "from Produto where nome like :nome";
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		query.setParameter("nome", nome + "%");
		return query.getResultList();		
	}

}
