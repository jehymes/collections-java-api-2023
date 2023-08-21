package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.util.*;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<LocalDate, Evento>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        agendaEventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento(){
        if(!agendaEventosMap.isEmpty()){
            LocalDate dataAtual = LocalDate.now();
            LocalDate proximaData = null;
            Evento proximoEvento = null;
            Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
            for(Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                if(proximaData.isEqual(dataAtual) || proximaData.isAfter(dataAtual)){
                    System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data: "+ proximaData);
                    break;
                }
            }
        } else {
            throw new RuntimeException("A agenda de eventos se encontra vazia!");
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEvento(LocalDate.of(2023, 7, 9), "Evento 1", "Ferrugem");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 8, 21), "Evento 2", "K10");
        agendaEventos.adicionarEvento(LocalDate.of(2023, 6, 1), "Evento 4", "Revelação");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 5, 8), "Evento 6", "Menos é Mais");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
