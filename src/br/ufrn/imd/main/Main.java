package br.ufrn.imd.main;

import br.ufrn.imd.dominio.Deposito;
import br.ufrn.imd.dominio.Produto;
import br.ufrn.imd.dominio.ProdutoDuravel;
import br.ufrn.imd.dominio.ProdutoNaoDuravel;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void listarProdutosDeposito(Deposito deposito) {
        if (!deposito.isEmpty()) {
            int index = 1;
            for (Produto produto : deposito.getProdutos()) {
                System.out.print(index++ + " - ");
                System.out.println(produto);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calendar dataFabricacao = Calendar.getInstance();
        dataFabricacao.set(Calendar.DATE, 27);
        dataFabricacao.set(Calendar.MONTH, 07);
        dataFabricacao.set(Calendar.YEAR, 2001);

        ProdutoDuravel produtoDuravel1 = new ProdutoDuravel("Computador", 1500, "DELL", "Um computador muito bom!", dataFabricacao.getTime(), 10);
        ProdutoDuravel produtoDuravel2 = new ProdutoDuravel("Mouse", 50, "DELL", "Um mouse bem mouseado!", dataFabricacao.getTime(), 3);
        ProdutoDuravel produtoDuravel3 = new ProdutoDuravel("Teclado", 70, "DELL", "Você pode digitar a vontade.", dataFabricacao.getTime(), 2);

        ProdutoNaoDuravel produtoNaoDuravel1 = new ProdutoNaoDuravel("Picolé", 7, "Kibom", "Delicous!", dataFabricacao.getTime(), dataFabricacao.getTime(), "Comida");
        ProdutoNaoDuravel produtoNaoDuravel2 = new ProdutoNaoDuravel("Pão", 7, "Padaria", "Bom com manteiga.", dataFabricacao.getTime(), dataFabricacao.getTime(), "Comida");
        ProdutoNaoDuravel produtoNaoDuravel3 = new ProdutoNaoDuravel("Pastel", 7, "Pastelaria Tangará", "Bom com pimenta.", dataFabricacao.getTime(), dataFabricacao.getTime(), "Comida");

        Deposito deposito = new Deposito();

        deposito.addProduto(produtoDuravel1);
        deposito.addProduto(produtoDuravel2);
        deposito.addProduto(produtoDuravel3);
        deposito.addProduto(produtoNaoDuravel1);
        deposito.addProduto(produtoNaoDuravel2);
        deposito.addProduto(produtoNaoDuravel3);

        int opcao = -1;
        do {
            System.out.println("\n(Menu de opções)");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Produto com maior preco");
            System.out.println("4 - Quantidade de produtos");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            if (deposito.isEmpty()) {
                System.out.println("O depósito está vazio.");
                continue;
            }

            switch (opcao) {
                case 1:
                    listarProdutosDeposito(deposito);
                    break;
                case 2:
                    listarProdutosDeposito(deposito);
                    System.out.print("Número do produto: ");
                    int indexProduto = sc.nextInt();

                    if (indexProduto < 0 || indexProduto > deposito.getQntProdutos()) {
                        System.out.println("Informe o número corretamente.");
                    } else {
                        deposito.removerProduto(indexProduto);
                        System.out.println("Produto removido com sucesso.");
                    }
                    break;
                case 3:
                    Produto produto = deposito.getProdutoMaiorPreco();
                    System.out.println(produto);
                    break;
                case 4:
                    System.out.println(deposito.getQntProdutos() + " produto(s) no estoque.");
                    break;
            }
        } while(opcao != 0);
    }
}
