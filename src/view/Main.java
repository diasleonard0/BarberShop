/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;

/**
 *
 * @author leodi
 */
public class Main {
    
    public static void main(String[] args) throws ParseException {
        
        String nome = "Leonardo";
        System.out.println(nome);
        
        Servico barba = new Servico(1, "Barba", 30);
        
        System.out.println(barba.getDescricao());
        System.out.println(barba.getValor());
        
        Cliente cliente = new Cliente("Rua Augusta", "14830-000", 1, "Augusto");
        System.out.println(cliente.getNome());
        
        char[] senha = {'3', '2', '1'};
        Usuario usuario = new Usuario(senha, "Admin", 2, "Fábio");
        System.out.println(usuario.getId());
        
        Agendamento agendamento = new Agendamento(3, cliente, barba, 10, "10/05/2023 13:30");
        System.out.println(agendamento.getCliente().getNome());
    }
    
}
