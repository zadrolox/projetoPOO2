/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.model.Dono;
import br.ulbra.model.DonoDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class DonoController {
    private DonoDAO donoDAO;
    public DonoController() {
        donoDAO = new DonoDAO();
    } 
    
    public boolean adicionarDono(String nome, String endereco, String cpf, String email){
        return donoDAO.adicionarDono(nome, endereco, cpf, email);
    }
    
    public List<Dono> readForDesc(int tipo, String desc) {
        return donoDAO.readForDesc(tipo, desc);
    }
    
    public Dono readForPk(int pk) {
        return donoDAO.readForPk(pk);
    }
    
    public boolean alterarDono(Dono u) {
        return donoDAO.alterarDono(u);
    }
    
    public boolean excluirDono(int pkDono) {
        return donoDAO.excluirDono(pkDono);
    }
}
