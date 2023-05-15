/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.DAO.AgendamentoDAO;
import controller.Helper.AgendaHelper;
import java.util.ArrayList;
import model.Agendamento;
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
    
}
