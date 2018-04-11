/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import entities.Produit;
import entities.Promotion;
import entities.Wishlist;
import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import service.ServicePromotion;
import service.ServiceWishlist;


public class AfficheListProduitsController implements Initializable {

    ToggleGroup group = new ToggleGroup();
    Label l = new Label();
    @FXML
    private AnchorPane anchorPaneA;
   
    @FXML
    private ScrollPane scrollPaneProduit;

  @FXML
    private AnchorPane pass;
  
    public static int recupid;
Integer i;
   Produit produit =new Produit();
     ServicePromotion a = new ServicePromotion();
       ObservableList<Promotion> data;
    @FXML
    private Button favoris;
    @FXML
    private ImageView star1;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star5;
    @FXML
    private ImageView star3;
    @FXML
    private HBox rating;
    @FXML
    private ImageView Est1;
    @FXML
    private ImageView Est3;
    @FXML
    private ImageView Est2;
    @FXML
    private ImageView Est4;
    @FXML
    private ImageView Est5;
    private int note = 0;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

        ServicePromotion evt = new ServicePromotion();

          Image[] images;
        
            AnchorPane p = new AnchorPane();
            GridPane grid = new GridPane();
           
        
            data = FXCollections.observableArrayList();
         
            
            data.addAll(a.getAll());

            int k = 0;
            grid.setHgap(1);
            grid.setVgap((data.stream().count()) + 1);
            grid.setPadding(new Insets(50, 50, 50, 50));
            for (int i = 0; i < (data.stream().count() / 1) + 1; i++) {
                for (int j = 0; j < 1; j++) {
                    if (k < data.stream().count()) {
                        ImageView im = data.get(k).getImage2();
                          Group root = new Group();
                           // images = new Image[1];
                            
                                im.setFitWidth(250);

                        im.setFitHeight(200);
                          
                
  Label visit = new Label("");
root.getChildren().add(favoris);

                        root.getChildren().add(im);
                         root.setAccessibleText(Integer.valueOf(data.get(k).getId()).toString());
                         //root.setAccessibleText(data.get(k).getIdMagasin());
                              l.setStyle("-fx-font-size: 20px;"
                                + " -fx-font-weight: bold;"
                                + "-fx-text-fill: #818181;"
                                + "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );"
                                + "-fx-font-family: Arial Black;"
                        );
                        Label id = new Label(String.valueOf(data.get(k).getId()));
                        id.setVisible(false);
                        id.setAccessibleText("id");
                        Pane p1 = new Pane();
                        p1.setStyle("-fx-background-color: white;"
                                + "-fx-background-radius: 10px;"
                                + "-fx-border-color: black;"
                                + "-fx-border-radius:10px;"
                                + "-fx-opacity: 0.6;");
                        
                        p1.setVisible(false);
                   
                        l.setOnMouseEntered((MouseEvent event) -> {
                        p1.setVisible(true);

                        });
                        l.setOnMouseExited((MouseEvent event) -> {
                            p1.setVisible(false);
                        });
                       
                        l.setAlignment(Pos.CENTER);
                      
VBox vv = new VBox();
          vv.setSpacing(5);

          
         VBox v1 = new VBox();
          v1.setSpacing(5);
          
                  Label l = new Label("");
           Label l1 = new Label("");
           Label nomproduit = new Label("          Nom produit: ");
          nomproduit.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
              Label lnomproduit = new Label(data.get(k).getNomProduit());
                 lnomproduit.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
//             Label categorie = new Label("          Categorie: ");
//            categorie.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");            
//              Label categorieproduit = new Label(data.get(k).getProduitId().getCategorieid().getNom());
//                 categorieproduit.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");   
                   produit= data.get(k).getProduitId();
                  Text pourcentaget=new Text("Pourcentage : ");
                                Label pourcentage = new Label(String.valueOf(data.get(k).getPourcentage()));
                                Text prixavantt=new Text("Prix Avant : ");
                                Label  prixavant = new Label(String.valueOf(data.get(k).getProduitId().getPrix()));
                                Text prixaprest=new Text("Prix Apres: ");
                                Label  prixapres = new Label(String.valueOf(data.get(k).getProduitId().getPrix()*data.get(k).getPourcentage()/100));
                                
//                                Text nompatisseriet=new Text("Patisserie : ");
//                                Label  nompatisserie = new Label(data.get(k).getProduitId().getCategorieid().getPatisserieId().getNom());
//                     Label vendeur = new Label("          Nom vendeur: ");
//                     vendeur.setStyle("-fx-text-fill: #7f171f;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
//                     Label lvendeur = new Label(data.get(k).getPatisserieId().getUser().getFirstname());
//                      lvendeur.setStyle("-fx-text-fill:  #27313a;-fx-font-weight: bold; -fx-font: 20px Tahoma;");
                         
//                               JFXButton ajouterFavoris = new JFXButton();
//                       ajouterFavoris.setText("Ajouter Favoris ");
//                         //ToggleButton layoutButton = new ToggleButton();
//                      ajouterFavoris.setStyle("-fx-text-fill: hite;-fx-font: 11 'system'; -fx-background-radius: 5px; -padding-left: 50px;-fx-background-color:red;");
                        

                   grid.add(new VBox(root, id,  p1), j, i);
//                   vv.getChildren().addAll(l,lnomproduit,categorieproduit, prixapres,pourcentage,prixapres,nompatisserie,lvendeur, ajouterFavoris);
//                     v1.getChildren().addAll(l1,nomproduit,categorie,pourcentaget,prixaprest,nompatisseriet,vendeur);
    //vv.getChildren().addAll(l,lnomproduit, prixavant,pourcentage, prixapres,ajouterFavoris, users);
        vv.getChildren().addAll(l,lnomproduit, prixavant,pourcentage, prixapres);
    v1.getChildren().addAll(nomproduit,prixavantt,pourcentaget,prixaprest
    );    
    String cssLayout = "-fx-border-color: pink;\n" +
                   "-fx-border-insets: 5;\n" +
                   "-fx-border-width: 3;\n" +
                   "-fx-border-style: 0px, 50px 0px  50px dashed;\n";

v1.setStyle(cssLayout); 

vv.setStyle(cssLayout); 
grid.add((v1), 1, i);
     
         grid.add((vv), 2, i);                

                   k++;
                   
                        scrollPaneProduit.setContent(grid);
                       ServiceWishlist serviceWishlist= new ServiceWishlist();
         Wishlist wishlist = new Wishlist(produit);

                    }
                     Est1.setOnMouseExited((MouseEvent E2) -> {
            if (note != 0) {
                Est1.setVisible(true);
            } else {
                Est1.setVisible(false);
            }
        });

//        star1.setOnMouseEntered((MouseEvent E3) -> {
//
//            Est1.setVisible(true);
//        });
//
//        Est2.setOnMouseClicked((MouseEvent E1) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(false);
//            Est4.setVisible(false);
//            Est5.setVisible(false);
//            note = 2;
//            System.out.println(note);
//        });
//
//        Est2.setOnMouseExited((MouseEvent E2) -> {
//            if (note <= 1) {
//                Est2.setVisible(false);
//            } else {
//                Est2.setVisible(true);
//            }
//        });
//
//        star2.setOnMouseEntered((MouseEvent) -> {
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//        });
//
//        Est3.setOnMouseClicked((MouseEvent E1) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//            Est4.setVisible(false);
//            Est5.setVisible(false);
//
//            note = 3;
//            System.out.println(note);
//        });
//
//        Est3.setOnMouseExited((MouseEvent E2) -> {
//            if (note <= 2) {
//                Est3.setVisible(false);
//            } else {
//
//                Est3.setVisible(true);
//
//            }
//        });
//
//        star3.setOnMouseEntered((MouseEvent) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//        });
//
//        Est4.setOnMouseClicked((MouseEvent E1) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//            Est4.setVisible(true);
//            Est5.setVisible(false);
//
//            note = 4;
//            System.out.println(note);
//
//        });
//
//        Est4.setOnMouseExited((MouseEvent E2) -> {
//            if (note <= 3) {
//                Est4.setVisible(false);
//
//            } else {
//                Est4.setVisible(true);
//            }
//        });
//
//        star4.setOnMouseEntered((MouseEvent) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//            Est4.setVisible(true);
//        });
//
//        Est5.setOnMouseClicked((MouseEvent E1) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//            Est4.setVisible(true);
//            Est5.setVisible(true);
//
//            note = 5;
//            System.out.println(note);
//
//        });
//
//        Est5.setOnMouseExited((MouseEvent E2) -> {
//            if (note <= 4) {
//                Est5.setVisible(false);
//            } else {
//                Est5.setVisible(true);
//            }
//        });
//        star5.setOnMouseEntered((MouseEvent) -> {
//
//            Est1.setVisible(true);
//            Est2.setVisible(true);
//            Est3.setVisible(true);
//            Est4.setVisible(true);
//            Est5.setVisible(true);
//        });
//
//
//                }

                
// favoris.setOnMouseClicked((MouseEvent E) -> {
//                    for (Node node : grid.getChildren()) {
//
//                        for (Node node1 : ((VBox) node).getChildren()) {
//                            if (node1 instanceof Group) {
//                                node1.setOnMouseClicked((MouseEvent E1) -> {
//
//                                    recupid = Integer.valueOf(node1.getAccessibleText());
//                                    System.out.println(recupid+"-------------------");
////                                        Pane newLoadedPaneExp = FXMLLoader.load(getClass().getResource("/Fxml/detailProduit.fxml"));
////                                        pass.getChildren().clear();
////                                        pass.getChildren().add(newLoadedPaneExp);
////Produit produit=data.get(k).getProduitId();
////         ServiceWishlist serviceWishlist= new ServiceWishlist();
////         Wishlist wishlist = new Wishlist(produit);
////favoris.setOnAction(new EventHandler<ActionEvent>() {
////                    @Override
////                    public void handle(ActionEvent event) {
////                        favoris.setVisible(true);
////                      serviceWishlist.ajouterfavoris(wishlist);  
////                       
////                    }
////                });
//                                  
//                                });
//                            }
//                        }
//                    }
//                });

                
                        

            }


     

    }
 
    }
  

    @FXML
    private void addFavoris(ActionEvent event) {
    }

   


    @FXML
    private void ClickStar1(MouseEvent event) {
    }

    @FXML
    private void ClickStar4(MouseEvent event) {
    }

    @FXML
    private void ClickStar2(MouseEvent event) {
    }

    @FXML
    private void ClickStar5(MouseEvent event) {
    }

    @FXML
    private void ClickStar3(MouseEvent event) {
    }

    @FXML
    private void STAR1(MouseEvent event) {
    }

    @FXML
    private void STAR3(MouseEvent event) {
    }

    @FXML
    private void STAR2(MouseEvent event) {
    }

    @FXML
    private void STAR4(MouseEvent event) {
    }

    @FXML
    private void STAR5(MouseEvent event) {
    }


}