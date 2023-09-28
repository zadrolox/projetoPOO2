/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import br.ulbra.utils.Utils;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    
    public boolean adicionarAnimal(String nome, String raca, int dono, String especie, int vivo, int vacina, Icon imagem){
        String sql = "INSERT into TBANIMAL (nomeAni, racaAni, fkDono,especieAni, vivoAni, vacinaAni, imagemAni ) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            byte[] iconBytes = Utils.iconToBytes(imagem);
            
            PreparedStatement stmt = gerenciador.getConexao().prepareStatement(sql);
            stmt.setString(1, nome); //caso for outro tipo de dado, correlacionar o set... ex. setDouble, setInt
            stmt.setString(2, raca);
            stmt.setInt(3, dono);
            stmt.setString(4, especie);
            stmt.setInt(5, vivo);
            stmt.setInt(6, vacina);
            stmt.setBytes(7, iconBytes);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Animal: " + nome + " inserido com sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
        return false;
    }
    
    public Animal readForPk(int pk) {
        String sql = "SELECT * FROM tbanimal WHERE pkanimal = ?";
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Animal animal = new Animal();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                animal.setPkAnimal(rs.getInt("pkanimal"));
                animal.setNomeAni(rs.getString("nomeani"));
                animal.setRacaAni(rs.getString("racaani"));
                animal.setFkDono(rs.getInt("fkdono"));
                animal.setEspecieAni(rs.getString("especieani"));
                animal.setVivoAni(rs.getInt("vivoani"));
                animal.setVacinaAni(rs.getInt("vacinaani"));
                
                byte[] bytes = rs.getBytes("imagemani");
                if (!(bytes == null)) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                    BufferedImage imagem = ImageIO.read(bis);
                    animal.setImagem(new ImageIcon(imagem));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return animal;
    }
    
    
    public List<Animal> readForDon(int pk) {
        String sql = "SELECT * FROM tbanimal WHERE fkdono = ?";
        List<Animal> animais = new ArrayList<>();

        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pk);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal();

                animal.setPkAnimal(rs.getInt("pkanimal"));
                animal.setNomeAni(rs.getString("nomeani"));
                animal.setRacaAni(rs.getString("racaani"));
                animal.setEspecieAni(rs.getString("especieani"));
                animal.setVivoAni(rs.getInt("vivoani"));
                animal.setVacinaAni(rs.getInt("vacinaani"));
                
                animais.add(animal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerenciadorConexao.closeConnection(con, stmt, rs);
        }

        return animais;
    }
    
    public boolean alterarAnimal(Animal u) {
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            byte[] iconBytes = Utils.iconToBytes(u.getImagem());
            
            stmt = con.prepareStatement("UPDATE tbanimal SET nomeani = ?, "
                    +" racaani = ?, fkdono = ?, especieani = ?, vivoani = ?, vacinaani = ?, imagemani = ? WHERE pkanimal = ?");
            stmt.setString(1, u.getNomeAni());
            stmt.setString(2, u.getRacaAni());
            stmt.setInt(3, u.getFkDono());
            stmt.setString(4, u.getEspecieAni());
            stmt.setInt(5, u.isVivoAni());
            stmt.setInt(6, u.isVacinaAni());
            stmt.setBytes(7, iconBytes);
            stmt.setInt(8, u.getPkAnimal());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        } finally {
            GerenciadorConexao.closeConnection(con, stmt);
        }
        return false;
    }
    
    public boolean excluirAnimal(int pkAnimal) {
        GerenciadorConexao gerenciador = GerenciadorConexao.getInstancia();
        Connection con = gerenciador.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbanimal "
                    + "WHERE pkanimal = ?");
            stmt.setInt(1, pkAnimal);

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
