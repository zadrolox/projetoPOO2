/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class DonoDAO {
    private GerenciadorConexao gerenciador;
    public DonoDAO(){
        this.gerenciador = GerenciadorConexao.getInstancia();
    }
    
    public boolean adicionarDono(String nome, String endereco, String cpf, String email){
        String sql = "INSERT into TBDONO (nomeDon, enderecoDon, cpfDon, emailDon) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome); //caso for outro tipo de dado, correlacionar o set... ex. setDouble, setInt
            stmt.setString(2, endereco);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dono: " + nome + " inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
}
