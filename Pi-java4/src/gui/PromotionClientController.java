/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import entities.Categorie;
import entities.Patisserie;
import entities.Promotion;
import entities.Wishlist;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumnBuilder;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;

import service.ServicePromotion;
import service.ServiceWishlist;
import utils.DataSource;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import service.ServicePatisseries;


/**
 * FXML Controller class
 *
 * @author Ghada
 */
public class PromotionClientController implements Initializable {

    @FXML
    private AnchorPane tbclient;
    @FXML
    private TableView<Promotion> tblpromo;
     @FXML
    private TableColumn<Promotion, String> tblClmNom;
    @FXML
    private TableColumn<Promotion, Double> tblClmPrixAvant;
    @FXML
    private TableColumn<Promotion, Integer> tblClmpourcentage;
    @FXML
    private TableColumn<Promotion, Double> tblClmprixvente;
    @FXML
   private TableColumn<Promotion,Date> tblClmfin;
    private File file;
    private BufferedImage bufferedImage;
    private ObservableList<Promotion> transactions;
//    private javafx.scene.image.Image image;
    private String imagePath;
    @FXML
    private Button addfavoris;
    @FXML
    private StackPane pagePanel;
    private IntegerProperty limit;
    ServicePromotion s = new ServicePromotion();
    private ObservableList<Promotion> promotions = s.getAll();
    DataSource cnx;
    Connection conn = DataSource.getInsatance().getConnection();
    Statement stmt;
    ResultSet rs;
    @FXML
    private Pagination pagination;

    ServiceWishlist v = new ServiceWishlist();
    @FXML
    private Button listfavoris;

    @FXML
    private TextField source;
    @FXML
    private TableColumn<Promotion, Button> photo;
    @FXML
    private TableColumn<?, ?> tblClmdebut;
    @FXML
    private ComboBox<Patisserie> combo;
    @FXML
 private ComboBox<Categorie> combo2;
    @FXML
    private Menu pat;
    @FXML
    private Menu cat;
    @FXML
    private TextField tfSearch;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         sortListener();
         combo2.setVisible(false);
        limit = new SimpleIntegerProperty(10);
        viewAll();
        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                changeTableView(newValue.intValue(), limit.get());
            }

        });

        limit.addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                changeTableView(pagination.getCurrentPageIndex(), newValue.intValue());
            }

        });
//        pagePanel.getChildren().add(pagination);
        StackPane.setAlignment(pagination, Pos.CENTER);

        //pagination.getStyleClass().add(pagination.STYLE_CLASS_BULLET);
        setValueFactory();
        init();

    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
    }

    void viewAll() {
        ServicePromotion s = new ServicePromotion();
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Promotion,String>("id"));
        tblClmfin.setCellValueFactory(new PropertyValueFactory<>("date_fin_promotion"));
tblClmdebut.setCellValueFactory(new PropertyValueFactory<>("date_debut_promotion"));
        tblClmpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        tblClmfin.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateFinPromotion()));
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
photo.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
            Button b;

            @Override
            public ObservableValue<Button> call(CellDataFeatures<Promotion, Button> param) {
                return new SimpleObjectProperty(param.getValue().getImage2());
            }
        });
        tblClmNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Promotion, String> param) {
                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
            }
        });
        
        tblpromo.setItems(s.getAll());
        tblClmPrixAvant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {
Double d=param.getValue().getProduitId().getPrix();
        d = Math.floor(d * 100) / 100;
                return new SimpleDoubleProperty(d);
               

            }
        });
        tblClmprixvente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {
Double d=param.getValue().getProduitId().getPrix() - ((param.getValue().getProduitId().getPrix() / 100) * param.getValue().getPourcentage());
        d = Math.floor(d * 100) / 100;
                return new SimpleDoubleProperty(d);
               

            }
        });

        tblpromo.setItems(s.getAll());
        Pagination pagination = new Pagination(3, 1);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox(2);
                int pageIndex = 2;
                for (int i = 0; i < pageIndex + 2; i++) {
                    String[] myurls = null;
                    Hyperlink link = new Hyperlink(myurls[i]);
                    box.getChildren().add(link);
                }
                return box;
            }
        });
    }

    @FXML
    private void addfavoris(ActionEvent event) {
//        if (!tblpromo.getSelectionModel().isEmpty()) {
//            tblpromo.getSelectionModel().getSelectedItem().getProduitId();
//            Wishlist favoris = new Wishlist(tblpromo.getSelectionModel().getSelectedItem().getProduitId());
//            v.ajouterfavoris(favoris);
//        }
 if (!tblpromo.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Etes-vous sûr de vouloir supprimer?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                tblpromo.getSelectionModel().getSelectedItem().getProduitId();
           Wishlist favoris = new Wishlist(tblpromo.getSelectionModel().getSelectedItem().getProduitId());
            v.ajouterfavoris(favoris);
                viewAll();
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Veuillez Selectionner une promotion!");
            alert.showAndWait();
        }
    }

    @FXML
    private void listfavoris(ActionEvent event) throws IOException {
        InterfaceFxController acc = new InterfaceFxController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/gui/Wishlist.fxml"));
        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
           WishlistController addAjoutController = fXMLLoader.getController();
//            addAjoutController.btnModifier.setVisible(false);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListpromotionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void init() {
        resetPage();
        pagination.setCurrentPageIndex(0);
        changeTableView(0, limit.get());
    }

    /**
     * This function resets the pagination pagecount
     */
    public void resetPage() {
        pagination.setPageCount((int) (Math.ceil(promotions.size() * 1.0 / limit.get())));
    }

    /**
     * This function is responsible for changing the TableView according to the
     * index and limit provided
     *
     * @param index
     * @param limit
     */
    public void changeTableView(int index, int limit) {
        int newIndex = index * limit;

        List<Promotion> trans = promotions.subList(Math.min(newIndex, promotions.size()), Math.min(promotions.size(), newIndex + limit));
        tblpromo.getItems().clear();
        tblpromo.setItems(null);
        ObservableList<Promotion> l = FXCollections.observableArrayList();
        tblpromo.setItems(l);
        for (Promotion t : trans) {
            l.add(t);
        }
        System.out.println("Size:" + l.size());

    }
/**
     * Sorts whole list using preferred column sorting and sort type
     *
     * @param col the column which is to be sorted by
     * @param type ascending or descending sort type
     */
    private void sort(final SortColumn col, final TableColumn.SortType type) {

        transactions.sort(new Comparator<Promotion>() {

            @Override
            public int compare(Promotion o1, Promotion o2) {
                switch (col) {
                    case tblClmpourcentage:
                        return (TableColumn.SortType.ASCENDING == type) ? (o1.getPourcentage() > o2.getPourcentage() ? 1 : -1) : (o1.getPourcentage() < o2.getPourcentage() ? 1 : -1);
        
                }
                return o1.getPourcentage() > o2.getPourcentage() ? -1 : 1;
            }
        });
        changeTableView(pagination.getCurrentPageIndex(), limit.get());
    }

    private void setValueFactory() {
        viewAll();

    }

//    private void sortListener() {
//        qtyCol.sortTypeProperty().addListener(new ChangeListener<TableColumn.SortType>() {
//
//            @Override
//            public void changed(ObservableValue<? extends TableColumn.SortType> observable, TableColumn.SortType oldValue, TableColumn.SortType newValue) {
//                sort(SortColumn.QTY, newValue);
//            }
//        });
//        dateCol.sortTypeProperty().addListener(new ChangeListener<TableColumn.SortType>() {
//
//            @Override
//            public void changed(ObservableValue<? extends TableColumn.SortType> observable, TableColumn.SortType oldValue, TableColumn.SortType newValue) {
//                sort(SortColumn.DATE, newValue);
//            }
//        });
//        productCol.sortTypeProperty().addListener(new ChangeListener<TableColumn.SortType>() {
//
//            @Override
//            public void changed(ObservableValue<? extends TableColumn.SortType> observable, TableColumn.SortType oldValue, TableColumn.SortType newValue) {
//                sort(SortColumn.CODE, newValue);
//            }
//        });
//        snCol.sortTypeProperty().addListener(new ChangeListener<TableColumn.SortType>() {
//
//            @Override
//            public void changed(ObservableValue<? extends TableColumn.SortType> observable, TableColumn.SortType oldValue, TableColumn.SortType newValue) {
//                sort(SortColumn.SN, newValue);
//            }
//        });
//    }
//     enum SortColumn {
//
//        SN, CODE, QTY, DATE
//
//    }
    @FXML

    public void changeLimit(ActionEvent evt) {

        String txt = source.getText();
        if (txt != null) {
            try {
                int i = Integer.parseInt(txt);

                limit.set(i);

                resetPage();
                System.out.println(tblpromo.getItems().size());
                //pagination.setCurrentPageIndex(Math.min(pagination.getCurrentPageIndex(),table.getItems().size()/limit.get()));
            } catch (NumberFormatException nfe) {
                System.err.println("NFE error");
            }
        }
       
    }
     private void sortListener() {
        tblClmpourcentage.sortTypeProperty().addListener(new ChangeListener<TableColumn.SortType>() {

            @Override
            public void changed(ObservableValue<? extends TableColumn.SortType> observable, TableColumn.SortType oldValue, TableColumn.SortType newValue) {
                sort(SortColumn.tblClmpourcentage, newValue);
            }
        });}

    @FXML
    private void pat(ActionEvent event) {
        tblpromo.refresh();
        ServicePatisseries servicePatisseries = new ServicePatisseries();
         combo.getItems().addAll(servicePatisseries.getAll());
        
        if (combo.getSelectionModel().getSelectedItem()!=null){
         tblpromo.refresh();
         viewAll2();
         combo.getItems().clear();
        
        }
        
    }
    @FXML
    private void cat(ActionEvent event) {
        tblpromo.refresh();
        combo.getItems().clear();
          combo2.getItems().clear();
        combo.setVisible(false);
        combo2.setVisible(true);
        ServicePromotion servicePromotion = new ServicePromotion();
combo2.getItems().setAll(servicePromotion.getAllCategorie()) ;
        
        if (combo2.getSelectionModel().getSelectedItem()!=null){
         tblpromo.refresh();
         viewAll3();
         combo2.getItems().clear();
         combo.getItems().clear();
        combo.setVisible(true);
        combo2.setVisible(false);
        }
        
    }

    @FXML
    private void tfSearchOnKeyReleased(KeyEvent event) {
        ServicePromotion ss = new ServicePromotion();
        tblpromo.setItems(ss.getAllBynom(tfSearch.getText()));
        tblpromo.refresh();
    }
    enum SortColumn {

        tblClmpourcentage, 

    }
    void viewAll2() {
        ServicePromotion s = new ServicePromotion();
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Promotion,String>("id"));
        tblClmfin.setCellValueFactory(new PropertyValueFactory<>("date_fin_promotion"));
tblClmdebut.setCellValueFactory(new PropertyValueFactory<>("date_debut_promotion"));
        tblClmpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        tblClmfin.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateFinPromotion()));
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
photo.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
            Button b;

            @Override
            public ObservableValue<Button> call(CellDataFeatures<Promotion, Button> param) {
                return new SimpleObjectProperty(param.getValue().getImage2());
            }
        });
        tblClmNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Promotion, String> param) {
                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
            }
        });
        
        tblpromo.setItems(s.getAll2(combo.getSelectionModel().getSelectedItem()));
        tblClmPrixAvant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {

                return new SimpleDoubleProperty(param.getValue().getProduitId().getPrix());

            }
        });
        tblClmprixvente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {

                return new SimpleDoubleProperty(param.getValue().getProduitId().getPrix() - ((param.getValue().getProduitId().getPrix() / 100) * param.getValue().getPourcentage()));

            }
        });

        tblpromo.setItems(s.getAll2(combo.getSelectionModel().getSelectedItem()));
        Pagination pagination = new Pagination(3, 1);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox(2);
                int pageIndex = 2;
                for (int i = 0; i < pageIndex + 2; i++) {
                    String[] myurls = null;
                    Hyperlink link = new Hyperlink(myurls[i]);
                    box.getChildren().add(link);
                }
                return box;
            }
        });
    }
    void viewAll3() {
        ServicePromotion s = new ServicePromotion();
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Promotion,String>("id"));
        tblClmfin.setCellValueFactory(new PropertyValueFactory<>("date_fin_promotion"));
tblClmdebut.setCellValueFactory(new PropertyValueFactory<>("date_debut_promotion"));
        tblClmpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        tblClmfin.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateFinPromotion()));
//        tblClmNom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
photo.setCellValueFactory(new Callback<CellDataFeatures<Promotion, Button>, ObservableValue<Button>>() {
            Button b;

            @Override
            public ObservableValue<Button> call(CellDataFeatures<Promotion, Button> param) {
                return new SimpleObjectProperty(param.getValue().getImage2());
            }
        });
        tblClmNom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Promotion, String> param) {
                return new SimpleStringProperty(param.getValue().getProduitId().getNom());
            }
        });
        
        tblpromo.setItems(s.getAll3(combo2.getSelectionModel().getSelectedItem()));
        tblClmPrixAvant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {

                return new SimpleDoubleProperty(param.getValue().getProduitId().getPrix());

            }
        });
        tblClmprixvente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures<Promotion, Double> param) {

                return new SimpleDoubleProperty(param.getValue().getProduitId().getPrix() - ((param.getValue().getProduitId().getPrix() / 100) * param.getValue().getPourcentage()));

            }
        });

        tblpromo.setItems(s.getAll3(combo2.getSelectionModel().getSelectedItem()));
        Pagination pagination = new Pagination(3, 1);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox(2);
                int pageIndex = 2;
                for (int i = 0; i < pageIndex + 2; i++) {
                    String[] myurls = null;
                    Hyperlink link = new Hyperlink(myurls[i]);
                    box.getChildren().add(link);
                }
                return box;
            }
        });
    }

}
