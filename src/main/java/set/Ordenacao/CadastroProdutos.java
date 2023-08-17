package main.java.set.Ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<Produto>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<Produto>(produtosSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<Produto>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtosSet);
        return  produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Produto 2", 15d, 5);
        cadastroProdutos.adicionarProduto(3L, "Produto 1", 20d, 10);
        cadastroProdutos.adicionarProduto(4L, "Produto 5", 10d, 2);
        cadastroProdutos.adicionarProduto(5L, "Produto 6", 3d, 4);
        cadastroProdutos.adicionarProduto(9L, "Produto 9", 2d, 8);
        cadastroProdutos.adicionarProduto(2L, "Produto 7", 7d, 6);

        System.out.println(cadastroProdutos.produtosSet);

        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
