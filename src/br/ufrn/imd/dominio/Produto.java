package br.ufrn.imd.dominio;

import java.util.Date;
import java.util.Objects;

public class Produto {
    private String nome;
    private double preco;
    private String marca;
    private String descricao;
    private Date dataFabricacao;

    public Produto(String nome, double preco, String marca, String descricao, Date dataFabricacao) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.descricao = descricao;
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ". Marca: " + marca + ". Preço R$:" + preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && Objects.equals(marca, produto.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, marca);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
