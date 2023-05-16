/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Cliente;
import model.Servico;
import view.Agenda;

/**
 *
 * @author leodi
 */
public class AgendaHelper implements IHelper{
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTable1().getModel();
        tableModel.setNumRows(0);
        
        // Percorrer a lista preenchendo o tableModel
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[]{
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()
            });
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxCliente().getModel();
        
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente); // Adiciona o cliente que é um objeto
        }
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getjComboBoxServico().getModel();
        
        for (Servico servico : servicos) {
            comboBoxModel.addElement(servico); 
        }
    }
    
    public Cliente obterCliente() {
       return (Cliente) view.getjComboBoxCliente().getSelectedItem();
    }

    public Servico obterServico() {
       return (Servico) view.getjComboBoxServico().getSelectedItem();
    }

    public void setarValor(float valor) {
        view.getjTextValor().setText(valor+""); // Veja q eu mudei o float para string por conta da concatenação
    }

    @Override
    public Agendamento obterModelo() {
        String idString = view.getjTextId().getText();
        int id = Integer.parseInt(idString);
        
        Cliente cliente = obterCliente();
        
        Servico servico = obterServico();
        
        String valorString = view.getjTextValor().getText();
        float valor = Float.parseFloat(valorString);
        
        String data = view.getjTextData().getText();
        String hora = view.getjTextHora().getText();
        String dataHora = data + " " + hora;
        
        String observacao = view.getjTextObservacao().getText();
        
        Agendamento agendamento = null;
        try {
            agendamento = new Agendamento(id, cliente, servico, valor, dataHora, observacao);
        } catch (ParseException ex) {
            Logger.getLogger(AgendaHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agendamento;
    }

    @Override
    public void limparTela() {
        view.getjTextId().setText("0");
        view.getjTextData().setText("");
        view.getjTextHora().setText("");
        view.getjTextObservacao().setText("");
    }
    
}
