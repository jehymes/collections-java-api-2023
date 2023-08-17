package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAluno {
    private Set<Aluno> alunoSet;

    public GerenciadorAluno() {
        this.alunoSet = new HashSet<Aluno>();
    }

    /**
     * adicionarAluno(String nome, Long matricula, double media): Adiciona um aluno ao conjunto.
     * removerAluno(long matricula): Remove um aluno ao conjunto a partir da matricula, se estiver presente.
     * exibirAlunosPorNome(): Exibe todos os alunos do conjunto em ordem alfabética pelo nome.
     * exibirAlunosPorNota(): Exibe todos os alunos do conjunto em ordem crescente de nota.
     * exibirAlunos(): Exibe todos os alunos do conjunto.
     */

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()){
            for(Aluno a : alunoSet){
                if(a.getMatricula() == matricula){
                    alunoParaRemover = a;
                    break;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O set de alunos está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        return new TreeSet<Aluno>(alunoSet);
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<Aluno>(new ComparatorPorNota());
        if(!alunoSet.isEmpty()){
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        } else {
            throw new RuntimeException("O set de alunos está vazio!");
        }
    }

    public void exibirAlunos() {
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAluno gerenciadorAluno = new GerenciadorAluno();

        gerenciadorAluno.exibirAlunos();
        gerenciadorAluno.adicionarAluno("Maria", 3L, 8d);
        gerenciadorAluno.adicionarAluno("João", 5L, 5d);
        gerenciadorAluno.adicionarAluno("Alberto", 6L, 6d);
        gerenciadorAluno.adicionarAluno("Bruna", 1L, 7.8d);
        gerenciadorAluno.adicionarAluno("Carlos", 4L, 9.1d);
        gerenciadorAluno.adicionarAluno("Debora", 2L, 4.5d);

        gerenciadorAluno.exibirAlunos();

        System.out.println(gerenciadorAluno.exibirAlunosPorNome());
        System.out.println(gerenciadorAluno.exibirAlunosPorNota());
        gerenciadorAluno.removerAluno(2L);
        gerenciadorAluno.exibirAlunos();
    }

}
