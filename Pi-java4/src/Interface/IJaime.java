/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Jaime;
import java.util.List;

/**
 *
 * @author USER
 */
public interface IJaime {
    
    
      public void ajouterJaime(Jaime j);
    
    public void supprimerJaime(Jaime j );
      
        public List<Jaime> afficherJaime(int id);
    public int calculerJaime(int id );
    
}
