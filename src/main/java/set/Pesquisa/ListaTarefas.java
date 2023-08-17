package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<Tarefa>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefaSet.add(tarefa);
    }

    public void removerTarefa(String descricao) {
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaSet.remove(t);
                    break;
                }
            }
        } else {
            throw new RuntimeException("Não existe registro no set de tarefas!");
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<Tarefa>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.isConcluida()){
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("Não existe registro no set de tarefas!");
        }
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<Tarefa>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(!t.isConcluida()){
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("Não existe registro no set de tarefas!");
        }
    }

    public void marcarTarefaConcluida(String descricao) {
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(true);
                }
            }
        } else {
            throw new RuntimeException("Não existe registro no set de tarefas!");
        }
    }

    public void marcarTarefaPendente(String descricao){
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(false);
                }
            }
        } else {
            throw new RuntimeException("Não existe registro no set de tarefas!");
        }
    }

    public void limparListaTarefas() {
        if(tarefaSet.isEmpty()){
            System.out.println("A lista de tarefas já se encontra vazia!");
        } else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        /**
         * adicionarTarefa(Tarefa tarefa): Adiciona uma nova tarefa ao Set.
         * removerTarefa(String descricao): Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
         * exibirTarefas(): Exibe todas as tarefas da lista de tarefas.
         * contarTarefas(): Conta o número total de tarefas na lista de tarefas.
         * obterTarefasConcluidas(): Retorna um Set com as tarefas concluídas.
         * obterTarefasPendentes(): Retorna um Set com as tarefas pendentes.
         * marcarTarefaConcluida(String descricao): Marca uma tarefa como concluída de acordo com a descrição.
         * marcarTarefaPendente(String descricao): Marca uma tarefa como pendente de acordo com a descrição.
         * limparListaTarefas(): Remove todas as tarefas da lista de tarefas.
         */

        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();
        System.out.println("|-----------------------------------------------------------------------------------|");
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 1", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 2", true));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 3", true));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 4", false));
        listaTarefas.exibirTarefas();
        System.out.println("|-----------------------------------------------------------------------------------|");
        listaTarefas.removerTarefa("Tarefa 3");
        listaTarefas.exibirTarefas();
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println("A lista de tarefas possui "+ listaTarefas.contarTarefas() + " tarefas registradas!");
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println(listaTarefas.obterTarefasPendentes());
        System.out.println("|-----------------------------------------------------------------------------------|");
        System.out.println("|-----------------------------------------------------------------------------------|");
        listaTarefas.marcarTarefaConcluida("Tarefa 4");
        listaTarefas.exibirTarefas();
        System.out.println("|-----------------------------------------------------------------------------------|");
        listaTarefas.marcarTarefaPendente("Tarefa 2");
        listaTarefas.exibirTarefas();
        System.out.println("|-----------------------------------------------------------------------------------|");
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
