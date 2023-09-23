/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.controller;

import br.ulbra.model.Animal;
import br.ulbra.model.AnimalDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class AnimalController {
    private AnimalDAO animalDAO;
    public AnimalController() {
        animalDAO = new AnimalDAO();
    } 
    
    public boolean adicionarAnimal(String nome, String raca, int dono, String especie, int vivo, int vacina){
        return animalDAO.adicionarAnimal(nome, raca, dono, especie, vivo, vacina);
    }
    
    public Animal readForPk(int pk) {
        return animalDAO.readForPk(pk);
    }
    
    public List<Animal> readForDon(int pk) {
        return animalDAO.readForDon(pk);
    }
    
}
