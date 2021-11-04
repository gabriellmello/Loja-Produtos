package com.gabriellmelo.lojaprodutos.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.stereotype.Component;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@EntityScan
@Component

public class Produto implements Serializable {

    private static final long serialVersionUID =-6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "nome_produto",nullable = false)
    private String nomeProduto;

    @Column(name= "codigo_de_barras",nullable = false)
    private String codigoDeBarras;

    @Column(name= "preco_produto",nullable = false)
    private double precoProduto;

    @Column(name= "data_cadastro",nullable = false)
    private Date dataCadastro;

    public Produto() {
    }

    public Produto(Long id, String nomeProduto, String codigoDeBarras, double precoProduto, Date dataCadastro) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.codigoDeBarras = codigoDeBarras;
        this.precoProduto = precoProduto;
        this.dataCadastro = dataCadastro;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecoProduto(){
        return precoProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String toString(){
        return "Produto[id=\" + id + \", nomeProduto=\" + nomeProduto + \", codigoDeBarras=\" + codigoDeBarras\",precoProduto =\"+ precoProduto\"]";


    }
}
