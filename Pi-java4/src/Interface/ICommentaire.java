/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entities.Commentaire;
import javafx.collections.ObservableList;

/**
 *
 * @author Siala
 */
public interface ICommentaire extends IService <Commentaire, Integer>{
    ObservableList<Commentaire> getByRecette(int IdRecette);
    public int NbTotalC();
    public ObservableList<Commentaire> getByUser(int Iduser) ;
}
