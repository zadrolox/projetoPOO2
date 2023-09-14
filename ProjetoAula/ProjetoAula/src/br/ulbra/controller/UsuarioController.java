/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.model.Usuario;
import br.ulbra.model.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno.saolucas
 */
public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    } 
    
    public boolean autenticar(String email, String senha) {
        if (usuarioDAO.autenticar(email, senha)){
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Usuário ou senha incorreta");
            return false;
        }
    }
    
    public boolean adicionarUsuario(String nome, String email, String senha, String datan, int ativo){
        return usuarioDAO.adicionarUsuario(nome, email, senha, datan, ativo);
    }

    public List<Usuario> readForDesc(String desc) {
        return usuarioDAO.readForDesc(desc);
    }
}
