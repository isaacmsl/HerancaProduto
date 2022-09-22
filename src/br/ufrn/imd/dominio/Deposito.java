package br.ufrn.imd.dominio;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int umIndexadoProduto) {
        if (!this.isEmpty() && umIndexadoProduto > 0 && umIndexadoProduto < this.getQntProdutos()) {
            produtos.remove(umIndexadoProduto-1);
        }
    }

    public int getQntProdutos() {
        return produtos.size();
    }

    public boolean isEmpty() {
        return  produtos.isEmpty();
    }

    public Produto getProdutoMaiorPreco() {
        if (this.isEmpty()) {
            return null;
        }

        double maiorPreco = 0;
        Produto produtoMaiorPreco = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() > maiorPreco) {
                maiorPreco = produto.getPreco();
                produtoMaiorPreco = produto;
            }
        }

        return produtoMaiorPreco;
    }


}
