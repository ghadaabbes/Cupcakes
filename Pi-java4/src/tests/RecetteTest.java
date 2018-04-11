/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import Interface.IUser;
import entities.Recette;
import entities.User;
import entities.Vote;
import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import service.RecetteService;
import service.UserService;
import service.VoteService;

/**
 *
 * @author Siala
 */
public class RecetteTest {
      /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)  {
        // TODO code application logic here
      String[] Astuce = {"Oeufs cuits durs dans le four? Placez-les dans une plaque à muffins puis mettre au four 25 à 30 minutes à 325˚F",
                           "Petit truc tout simple : équeuter vos fraises en les perçant de part en part à l'aide d'une paille.",
                           "BonBons de fraises : faire sécher des morceaux de fraises au four, sur une plaque, pendant 3 heures à 200°F",
                           "Un citron chauffé au four à micro-ondes pendant 15 secondes donnera ensuite deux fois plus de jus.",
                           "vous n'avez que du beurre congelé? La solution: râper le beurre, le mesurer au besoin, puis l'ajouter tel quel dans la recette.",
            "versez la crème pour le chantilly dans un cul de poule et placez-la avec le fouet du batteur au congélateur pendant 20 minutes."};
        String random = (Astuce[new Random().nextInt(Astuce.length)]);
        System.out.println(random);
   
  
        
        

       
    }
}
