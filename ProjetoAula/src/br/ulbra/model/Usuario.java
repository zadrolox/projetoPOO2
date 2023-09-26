/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import javax.swing.Icon;

/**
 *
 * @author Administrador
 */
public class Usuario {
    private int pkUsuario;
    private Icon imagem;
    private String nomeUsu;
    private String emailUsu;
    private String dataNascUsu;
    private int ativoUsu;
    private String senhaUsu;
    
    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getEmailUsu() {
        return emailUsu;
    }

    public void setEmailUsu(String emailUsu) {
        this.emailUsu = emailUsu;
    }

   

    public String getSenhaUsu() {
        return senhaUsu;
    }

    public void setSenhaUsu(String senhaUsu) {
        this.senhaUsu = senhaUsu;
    }

    public String getDataNascUsu() {
        return dataNascUsu;
    }

    public void setDataNascUsu(String dataNasUsu) {
        this.dataNascUsu = dataNasUsu;
    }

    public int isAtivoUsu() {
        return ativoUsu;
    }

    public void setAtivoUsu(int ativoUsu) {
        this.ativoUsu = ativoUsu;
    }
    
    public String ativoToString(){
        if (this.ativoUsu == 1)
            return "Ativo";
        else
            return "Inativo";
    }

    public Icon getImagem() {
        return imagem;
    }

    public void setImagem(Icon imagem) {
        this.imagem = imagem;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "pkUsuario=" + pkUsuario + ", nomeUsu=" + nomeUsu 
                + ", emailUsu=" + emailUsu + ", dataNascUsu=" + dataNascUsu 
                + ", ativoUsu=" + ativoUsu + ", senhaUsu=" + senhaUsu + '}';
    }
}
