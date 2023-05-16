/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import controller.Helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import servico.Correio;
import view.Agenda;

/**
 *
 * @author leodi
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela() {
        // Buscar uma lista com agendamentos do BDs
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        // Exibir esta lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente() {
        // Buscar clientes do BDs
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        // Exibir clientes do ComboBox Cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico() {
        // Buscar serviços do BDs
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        // Exivir esta lista na view
        helper.preencherServicos(servicos);
    }
    
    public void atualizaValor() {
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    public void agendar() {
        // Buscar objeto agendamento da Tela
        Agendamento agendamento = helper.obterModelo();
        
        // Salvar objeto no bd
        new AgendamentoDAO().insert(agendamento);
        
        // Mandar email
        Correio correio = new Correio();
        correio.notificarPorEmail(agendamento);
        
        // Inserir elemento na Tabela
        atualizaTabela();
        
        // Limpar tela
        helper.limparTela();
        
    }
    
}
