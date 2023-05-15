/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.DAO.UsuarioDAO;
import controller.Helper.LoginHelper;
import model.Usuario;
import view.Login;
import view.MenuPrincipal;

/**
 *
 * @author leodi
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    public void entrarNoSistema() {
        // Pegar um Usuário da View
        Usuario usuario = helper.obterModelo();
        
        // Pesquisar usuário no BD
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        // Se o usuário da view tiver o mesmo usuário e senha, bou redirecionar para o menu principal
        //// Se não vou mostrar uma mensagem ao usuário "usuário ou senha inválidos"
        if(usuarioAutenticado != null) {
            // Navegar para menu principal
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose(); // Ele fecha a janela
        } else {
            view.exibeMensagem("Usuário ou senha inválidos");
        }
    }
    
    public void fizTarefa() {
        System.out.println("Busquei algo do BDs");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
