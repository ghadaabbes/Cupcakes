/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Ligne_Commande;
import java.util.List;

/**
 *
 * @author beryl kristina
 */
public interface ILignes {
    public List<Ligne_Commande> getBycom(Integer commande);
    public void add(Ligne_Commande t);
}
