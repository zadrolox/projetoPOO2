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
public class Animal {
    private int pkAnimal;
    private String nomeAni;
    private String racaAni;
    private int fkDono;
    private String especieAni;
    private int vivoAni;
    private int vacinaAni;

    public int getPkAnimal() {
        return pkAnimal;
    }

    public void setPkAnimal(int pkAnimal) {
        this.pkAnimal = pkAnimal;
    }

    public String getNomeAni() {
        return nomeAni;
    }

    public void setNomeAni(String nomeAni) {
        this.nomeAni = nomeAni;
    }

    public String getRacaAni() {
        return racaAni;
    }

    public void setRacaAni(String racaAni) {
        this.racaAni = racaAni;
    }

    public int getFkDono() {
        return fkDono;
    }

    public void setFkDono(int fkDono) {
        this.fkDono = fkDono;
    }

    public String getEspecieAni() {
        return especieAni;
    }

    public void setEspecieAni(String especieAni) {
        this.especieAni = especieAni;
    }

    public int isVivoAni() {
        return vivoAni;
    }

    public void setVivoAni(int vivoAni) {
        this.vivoAni = vivoAni;
    }

    public int isVacinaAni() {
        return vacinaAni;
    }

    public void setVacinaAni(int vacinaAni) {
        this.vacinaAni = vacinaAni;
    }
    
    public String vivoToString(){
        if (this.vivoAni == 1)
            return "Vivo";
        else
            return "Morto";
    }
    
    public String vacinaToString(){
        if (this.vacinaAni == 1)
            return "Vacinado";
        else
            return "IVacinado";
    }

    @Override
    public String toString() {
        return "Animal{" + "pkAnimal=" + pkAnimal + ", nomeAni=" + nomeAni + ", "
                + "racaAni=" + racaAni + ", fkDono=" + fkDono + ", especieAni=" + especieAni + ", "
                + "vivoAni=" + vivoAni + ", vacinaAni=" + vacinaAni + '}';
    }
    
}
