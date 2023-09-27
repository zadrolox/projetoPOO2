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
    
    public List<Dono> read() {
        String sql = "SELECT * FROM tbdono";
        List<Dono> donos = new ArrayList<>();

        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dono dono = new Dono();

                dono.setPkDono(rs.getInt("pkdono"));
                dono.setNomeDon(rs.getString("nomedon"));
                dono.setEnderecoDon(rs.getString("enderecodon"));
                dono.setCpfDon(rs.getString("cpfdon"));
                dono.setEmailDon(rs.getString("emaildon"));
                
                donos.add(dono);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return donos;

    }
    
    public List<Dono> readForDesc(int tipo, String desc) {
        String sql;
        if (tipo == 0 || tipo == 1)
            sql = "SELECT * FROM tbdono WHERE nomedon LIKE ?";
        else
            sql = "SELECT * FROM tbdono WHERE emaildon LIKE ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Dono> donos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            if (tipo == 0 || tipo == 2)
            stmt.setString(1, desc+"%");
            else 
                stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dono dono = new Dono();

                dono.setPkDono(rs.getInt("pkdono"));
                dono.setNomeDon(rs.getString("nomedon"));
                dono.setEnderecoDon(rs.getString("enderecodon"));
                dono.setCpfDon(rs.getString("cpfdon"));
                dono.setEmailDon(rs.getString("emaildon"));
                
                donos.add(dono);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return donos;
    }
    
    public Dono readForPk(int pk) {
        String sql = "SELECT * FROM tbdono WHERE pkdono = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Dono dono = new Dono();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                dono.setPkDono(rs.getInt("pkdono"));
                dono.setNomeDon(rs.getString("nomedon"));
                dono.setEnderecoDon(rs.getString("enderecodon"));
                dono.setCpfDon(rs.getString("cpfdon"));
                dono.setEmailDon(rs.getString("emaildon"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DonoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return dono;
    }
    
    public boolean alterarDono(Dono u) {
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbdono SET nomedon = ?, "
                    +" enderecodon = ?, cpfdon = ?, emaildon = ? WHERE pkdono = ?");
            stmt.setString(1, u.getNomeDon());
            stmt.setString(2, u.getEnderecoDon());
            stmt.setString(3, u.getCpfDon());
            stmt.setString(4, u.getEmailDon());
            stmt.setInt(5, u.getPkDono());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt);
        }
        return false;
    }
    
    public boolean excluirDono(int pkDono) {
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbdono "
                    + "WHERE pkdono = ?");
            stmt.setInt(1, pkDono);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt);
        }
        return false;
    }
    
}
