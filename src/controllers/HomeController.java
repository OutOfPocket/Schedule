/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.sql.*;
import DB_util.MyConnection;
import models.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

public class HomeController implements Initializable {

    @FXML
    private Pane pnlSettings;
    
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlCalendar;
    
    
    @FXML
    private Label userLabel;
    

    
    PreparedStatement preparedStatement;
    Connection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #ffffff");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnCalendar) {
            pnlCalendar.setStyle("-fx-background-color : #ffffff");
            pnlCalendar.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #ffffff");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnSettings)
        {
            pnlSettings.setStyle("-fx-background-color : #ffffff");
            pnlSettings.toFront();
        }
        
    }
    
    public HomeController(){
      connection = (Connection) MyConnection.getConnection();
    }
}