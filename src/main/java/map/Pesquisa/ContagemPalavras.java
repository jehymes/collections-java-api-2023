package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<String, Integer>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if(!contagemMap.isEmpty()){
            for(Map.Entry<String, Integer> entry : contagemMap.entrySet()){
                if(entry.getKey().equalsIgnoreCase(palavra)){
                    contagemMap.remove(entry.getKey());
                    break;
                }
            }
        } else {
            throw new RuntimeException("A contagem de palavras se encontra vazia!");
        }
    }

    public int exibirContagemPalavras() {
        int contagemTotal = 0;
        for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
            contagemTotal += entry.getValue();
        }
        return contagemTotal;
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
            if(entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Palavra 1", 2);
        contagemPalavras.adicionarPalavra("Palavra 2", 8);
        contagemPalavras.adicionarPalavra("Palavra 3", 1);
        contagemPalavras.adicionarPalavra("Palavra 4", 6);
        System.out.println("Existem " + contagemPalavras.exibirContagemPalavras() + " palavras.");
        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
        contagemPalavras.removerPalavra("Palavra 2");
        System.out.println("Existem " + contagemPalavras.exibirContagemPalavras() + " palavras.");
        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
