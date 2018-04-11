/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import service.EvaluationService;

/**
 * FXML Controller class
 *
 * @author Anouar
 */
public class SatistiqueController implements Initializable {

    @FXML
    private Pane stat= new AnchorPane();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        start();
    }    

    private void start() {
        stat.getChildren().clear();
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
                pieChartData.add(new PieChart.Data("Nabeul", 3000));
                pieChartData.add(new PieChart.Data("aaaa", 600000));
                pieChartData.add(new PieChart.Data("masmoud", 900000));
                
        
         PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Pourcentage des patisseries % au Note");
        final Label caption = new Label("");
caption.setTextFill(Color.DARKORANGE);
caption.setStyle("-fx-font: 24 arial;");

chart.getData().stream().forEach((PieChart.Data data) -> {
    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
        caption.setTranslateX(e.getSceneX());
        caption.setTranslateY(e.getSceneY());
        caption.setText(String.valueOf(data.getPieValue()) + "%");
    });
        });
//chart.setLabelLineLength(10);
//chart.setLegendSide(Side.LEFT);
       stat.getChildren().add(chart);

        
    }

    private void createPie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
