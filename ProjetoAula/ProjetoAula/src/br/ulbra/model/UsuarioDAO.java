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
 * @author Administrador
 */
public class UsuarioDAO {
    private GerenciadorConexao gerenciador;
    public UsuarioDAO(){
        this.gerenciador = GerenciadorConexao.getInstancia();
    }
    
    public boolean autenticar(String email, String senha){
        String sql = "SELECT * from TBUSUARIO WHERE emailUsu = ? and senhaUsu = ? and ativoUsu = 1";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean adicionarUsuario(String nome, String email, String senha, String datan, int ativo){
        String sql = "INSERT into TBUSUARIO (nomeUsu, emailUsu, senhaUsu, dataNascUsu, ativoUsu) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome); //caso for outro tipo de dado, correlacionar o set... ex. setDouble, setInt
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setString(4, datan);
            stmt.setInt(5, ativo);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuário: " + nome + " inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
    public boolean alterarUsuario(Usuario u){
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusuario SET nomeusu = ?, emailusu = ?, senhausu = ?, "
                    + "datanascusu = ?, ativousu = ? "
                + "WHERE pkusuario = ?");
            stmt.setString(1, u.getNomeUsu()); 
            stmt.setString(2, u.getEmailUsu());
            stmt.setString(3, u.getSenhaUsu());
            stmt.setString(4, u.getDataNascUsu());
            stmt.setInt(5, u.isAtivoUsu());
            stmt.setInt(6, u.getPkUsuario());
            
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
    
    public List<Usuario> read() {
        String sql = "SELECT * FROM tbusuario";
        List<Usuario> usuarios = new ArrayList<>();

        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setPkUsuario(rs.getInt("pkusuario"));
                usuario.setNomeUsu(rs.getString("nomeusu"));
                usuario.setEmailUsu(rs.getString("emailusu"));
                usuario.setSenhaUsu(rs.getString("senhausu"));
                usuario.setDataNascUsu(rs.getString("datanascusu"));
                usuario.setAtivoUsu(rs.getInt("ativousu"));
                
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }
    
    public List<Usuario> readForDesc(String desc) {
        String sql = "SELECT * FROM tbusuario WHERE nomeusu LIKE ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setPkUsuario(rs.getInt("pkusuario"));
                usuario.setNomeUsu(rs.getString("nomeusu"));
                usuario.setEmailUsu(rs.getString("emailusu"));
                usuario.setSenhaUsu(rs.getString("senhausu"));
                usuario.setDataNascUsu(rs.getString("datanascusu"));
                usuario.setAtivoUsu(rs.getInt("ativousu"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        
        

        return usuarios;
    }
    
    public Usuario readForPk(int pk) {
        String sql = "SELECT * FROM tbusuario WHERE pkusuario = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario.setPkUsuario(rs.getInt("pkusuario"));
                usuario.setNomeUsu(rs.getString("nomeusu"));
                usuario.setEmailUsu(rs.getString("emailusu"));
                usuario.setSenhaUsu(rs.getString("senhausu"));
                usuario.setDataNascUsu(rs.getString("datanascusu"));
                usuario.setAtivoUsu(rs.getInt("ativousu"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }
        return usuario;
    }
    
    
}
