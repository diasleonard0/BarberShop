/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import model.Usuario;
import view.Login;

/**
 *
 * @author leodi
 */
public class LoginHelper implements IHelper{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    @Override
    public Usuario obterModelo() {
        String nome = view.getCampoUsuario().getText();
        String senha = view.getCampoSenha().getText();
        
        Usuario modelo = new Usuario(senha, "Admin", 0, nome);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo) {
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getCampoUsuario().setText(nome);
        view.getCampoSenha().setText(senha);
    }
    
    @Override
    public void limparTela() {
        view.getCampoUsuario().setText("");
        view.getCampoSenha().setText("");
    }
    
}
