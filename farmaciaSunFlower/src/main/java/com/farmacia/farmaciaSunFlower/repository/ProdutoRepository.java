package com.farmacia.farmaciaSunFlower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farmaciaSunFlower.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByDescricaoProdutoContainingIgnoreCase(String descricaoProduto);
}
