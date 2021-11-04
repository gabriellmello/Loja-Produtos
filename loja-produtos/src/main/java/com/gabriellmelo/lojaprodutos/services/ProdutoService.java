package com.gabriellmelo.lojaprodutos.services;

import com.gabriellmelo.lojaprodutos.dtos.ProdutoDto;
import com.gabriellmelo.lojaprodutos.entities.Produto;
import com.gabriellmelo.lojaprodutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto cadastrar (ProdutoDto produtoDto){
        Produto produto = new Produto();
        produto.setCodigoDeBarras(produtoDto.getCodigoDeBarras());
        produto.setDataCadastro(produtoDto.getDataCadastro());
        produto.setId(produtoDto.getId());
        produto.setNomeProduto(produtoDto.getNomeProduto());
        produto.setPrecoProduto(produtoDto.getPrecoProduto());
        return produtoRepository.save(produto);
    }

    public Produto buscar(Long id){
        Produto produto = produtoRepository.findOne(id);
        if(produto == null){
            throw new ProdutoServiceException("Nao existe produto cadastrado");
        }
        return produto;
    }



}
