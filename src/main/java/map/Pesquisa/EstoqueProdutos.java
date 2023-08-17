package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProdutos() {
        this.estoqueProdutoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutoMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutoMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0;
        if(!estoqueProdutoMap.isEmpty()){
            for(Produto p : estoqueProdutoMap.values()){
                valorTotalEstoque += (p.getQuantidade() * p.getPreco());
            }
            return valorTotalEstoque;
        } else {
            throw new RuntimeException("O estoque de produtos se encontra vazio!");
        }
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_NORMAL;
        if(!estoqueProdutoMap.isEmpty()){
            for(Produto p : estoqueProdutoMap.values()){
                if(p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
            return produtoMaisCaro;
        } else {
            throw new RuntimeException("O estoque de produtos se encontra vazio!");
        }
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!estoqueProdutoMap.isEmpty()){
            for(Produto p : estoqueProdutoMap.values()){
                if(p.getPreco() < menorPreco){
                    produtoMaisBarato = p;
                }
            }
            return produtoMaisBarato;
        } else {
            throw new RuntimeException("O estoque de produtos se encontra vazio!");
        }
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto produtoMaiorQuantidadeValorTotalNoEstoque = null;
        double maiorQuantidadeValorTotalEstoque = 0d;
        if(!estoqueProdutoMap.isEmpty()){
            for(Map.Entry<Long, Produto> entry: estoqueProdutoMap.entrySet()){
                double valorProdutoEmEstoque = entry.getValue().getQuantidade() * entry.getValue().getPreco();
                if(valorProdutoEmEstoque > maiorQuantidadeValorTotalEstoque){
                    maiorQuantidadeValorTotalEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorTotalNoEstoque = entry.getValue();
                }
            }
            return produtoMaiorQuantidadeValorTotalNoEstoque;
        } else {
            throw new RuntimeException("O estoque de produtos se encontra vazio!");
        }
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Produto A", 1, 50.0);
        estoque.adicionarProduto(2L, "Produto B", 5, 11.0);
        estoque.adicionarProduto(3L, "Produto C", 3, 10.0);
        estoque.adicionarProduto(3L, "Produto D", 2, 4.0);

        estoque.exibirProdutos();

        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
        System.out.println("Produto com maior quantidade em valor no estoque: " + estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
