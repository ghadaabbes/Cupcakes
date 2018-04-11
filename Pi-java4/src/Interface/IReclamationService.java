/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Reclamation;
import java.util.List;

/**
 *
 * @author Anouar
 */
public interface IReclamationService {
     public void createReclamation(Reclamation r);

    public List<Reclamation> getAll();

   

    public void delete(int id);
}
