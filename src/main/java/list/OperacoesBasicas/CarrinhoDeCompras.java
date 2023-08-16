package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //Atributo
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itemParaRemover = new ArrayList<>();

        for (Item item : itemList) {
            if(item.getNome().equalsIgnoreCase(nome)){
                itemParaRemover.add(item);
            }
        }

        itemList.removeAll(itemParaRemover);
    }

    public void calcularValorTotal(){
        double total = 0;
        for (Item item : itemList){
            double calcItem = item.getPreco() * item.getQuantidade();
            total += calcItem;
        }
        System.out.println("O valor total da compra é de R$"+total);
    }

    public void exibirItens(){
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras compras = new CarrinhoDeCompras();

        compras.adicionarItem("Lápis", 1.0, 3);
        compras.adicionarItem("Borracha", 0.5, 4);
        compras.adicionarItem("Apontador", 1.5, 2);
        compras.adicionarItem("Lapiseira", 4.5, 1);

        compras.exibirItens();
        compras.calcularValorTotal();
        compras.removerItem("Lapiseira");
        compras.exibirItens();
        compras.calcularValorTotal();
    }
}
