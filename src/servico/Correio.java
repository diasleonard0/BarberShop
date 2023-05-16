/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servico;

import model.Agendamento;

/**
 *
 * @author leodi
 */
public class Correio {
    
    public void notificarPorEmail(Agendamento agendamento) {
        String emailFormatado = formartarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        // Uso da Classe de Email
        Email email = new Email("Agendamento do BarberShop", emailFormatado, destinatario);
        email.enviar();
    }

    private String formartarEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento = agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        return "Olá " + nomeCliente + " vai dar um tapa no visu... Seu agendamento para " + 
                servico + ", está marcado para o dia" + dataAgendamento + " às " + horaAgendamento + 
                ". O preço para você saí baratinho R$" + valor + "\n Forte Abraço!!!";
    }
    
}
