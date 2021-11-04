package com.gabriellmelo.lojaprodutos.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProdutoDto implements Serializable {

    private static final long serialVersionUID =-8105241933692707649L;

    private Long id;

    private String nomeProduto;

    private String codigoDeBarras;

    private double precoProduto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dataCadastro;

    public ProdutoDto(){

    }

    public Long getId() {
        return id;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
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
