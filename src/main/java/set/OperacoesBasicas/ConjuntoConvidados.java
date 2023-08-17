package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadosSet;

    public ConjuntoConvidados() {
        this.convidadosSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvidado){
        this.convidadosSet.add(new Convidado(nome, codigoConvidado));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if(!this.convidadosSet.isEmpty()){
            for(Convidado c : this.convidadosSet){
               if(c.getCodigoConvite() == codigoConvite){
                   convidadoParaRemover = c;
                   break;
               }
            }

            this.convidadosSet.remove(convidadoParaRemover);

        } else {
            throw new RuntimeException("Não existe convidado com este código!");
        }
    }

    public int contarConvidados(){
        return this.convidadosSet.size();
    }

    public void exibirConvidados(){
        System.out.println(this.convidadosSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidados dentro do Set de Convidados");

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1236);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1237);
        conjuntoConvidados.adicionarConvidado("Convidado 5", 1237);
        System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidados dentro do Set de Convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1236);
        System.out.println("Existem "+ conjuntoConvidados.contarConvidados() + " convidados dentro do Set de Convidados");

        conjuntoConvidados.exibirConvidados();

    }
}
