package com.gabriellmelo.lojaprodutos.controllers;


import com.gabriellmelo.lojaprodutos.dtos.ProdutoDto;
import com.gabriellmelo.lojaprodutos.entities.Produto;
import com.gabriellmelo.lojaprodutos.responses.Response;
import com.gabriellmelo.lojaprodutos.services.ProdutoService;

import net.bytebuddy.agent.VirtualMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class LojaProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(path = "/new")
    public ResponseEntity<Response<Produto>> cadastrar( @RequestBody ProdutoDto produtoDto, BindingResult result) {
        Response<Produto> response = new Response<Produto>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Produto produtoCadastrado = this.produtoService.cadastrar(produtoDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDto.getId())
                .toUri();
        response.setData(produtoCadastrado);
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = produtoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Produto>> buscar(@PathVariable("id") Long id) {

        Produto produto = produtoService.buscar(id);
        Response<Produto> response = new Response<Produto>();
        response.setData(produto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
