package com.gabriellmelo.lojaprodutos.repositories;

import com.gabriellmelo.lojaprodutos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Produto findByNomeProduto(String nomeProduto);

}
