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
public class AnimalDAO {
    private GerenciadorConexao gerenciador;
    public AnimalDAO(){
        this.gerenciador = GerenciadorConexao.getInstancia();
    }
    
    public boolean adicionarAnimal(String nome, String raca, int dono, String especie, int vivo, int vacina){
        String sql = "INSERT into TBANIMAL (nomeAni, racaAni, fkDono,especieAni, vivoAni, vacinaAni ) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome); //caso for outro tipo de dado, correlacionar o set... ex. setDouble, setInt
            stmt.setString(2, raca);
            stmt.setInt(3, dono);
            stmt.setString(4, especie);
            stmt.setInt(5, vivo);
            stmt.setInt(6, vacina);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Animal: " + nome + " inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
}
