package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<Integer>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for(int n : numeros){
            soma += n;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = Integer.MIN_VALUE;
        if(!numeros.isEmpty()){
            for(Integer n : numeros){
                if(n >= maiorNumero){
                    maiorNumero = n;
                }
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if(!numeros.isEmpty()){
            for(Integer n : numeros){
                if(n <= menorNumero){
                    menorNumero = n;
                }
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros(){
        if(!numeros.isEmpty()){
            System.out.println(this.numeros);
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(13);
        somaNumeros.adicionarNumero(-8);
        somaNumeros.adicionarNumero(10);
        somaNumeros.exibirNumeros();

        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
