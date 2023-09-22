/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author s.lucas
 */
public class Dono {
    private int pkDono;
    private String nomeDon;
    private String enderecoDon;
    private String cpfDon;
    private String emailDon;

    public int getPkDono() {
        return pkDono;
    }

    public void setPkDono(int pkDono) {
        this.pkDono = pkDono;
    }

    public String getNomeDon() {
        return nomeDon;
    }

    public void setNomeDon(String nomeDon) {
        this.nomeDon = nomeDon;
    }

    public String getEnderecoDon() {
        return enderecoDon;
    }

    public void setEnderecoDon(String enderecoDon) {
        this.enderecoDon = enderecoDon;
    }

    public String getCpfDon() {
        return cpfDon;
    }

    public void setCpfDon(String cpfDon) {
        this.cpfDon = cpfDon;
    }

    public String getEmailDon() {
        return emailDon;
    }

    public void setEmailDon(String emailDon) {
        this.emailDon = emailDon;
    }

    @Override
    public String toString() {
        return "Dono{" + "pkDono=" + pkDono + ", nomeDon=" + nomeDon + ", "
                + "enderecoDon=" + enderecoDon + ", cpfDon=" + cpfDon + ", "
                + "emailDon=" + emailDon + '}';
    }
}
