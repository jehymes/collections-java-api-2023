package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<Contato>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<Contato>();
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().startsWith(nome)){
                    contatosPorNome.add(c);
                }
            }
        return contatosPorNome;
        } else {
            throw new RuntimeException("Não existe registros no set de contatos!");
        }
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().equalsIgnoreCase(nome)){
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("Não existe registros no set de contatos!");
        }
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Contato 1", 12345678);
        agendaContatos.adicionarContato("Contato 2", 12345);
        agendaContatos.adicionarContato("Jhonny", 0);
        agendaContatos.adicionarContato("Contato 4", 1111111);
        agendaContatos.adicionarContato("Contato 5", 654878);
        agendaContatos.adicionarContato("Bob", 01020304);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Contato"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Jhonny", 252829));
        agendaContatos.exibirContatos();
    }
}
