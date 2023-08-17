package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<String, String>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){
            dicionarioMap.remove(palavra);
        } else {
            throw new RuntimeException("O dicionário está vazio!");
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        if(!dicionarioMap.isEmpty()){
            return dicionarioMap.get(palavra);
        } else {
            throw new RuntimeException("O dicionário está vazio!");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.exibirPalavras();

        dicionario.adicionarPalavra("Procurar", "Definição de procurar");
        dicionario.adicionarPalavra("Teste", "Definição de teste");
        dicionario.adicionarPalavra("Gatilho", "Definição de gatilho.");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Gatilho");
        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Teste"));
    }
}
