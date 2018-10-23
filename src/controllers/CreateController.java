/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author AppleSauce
 */
import DB_util.MyConnection;
import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.*;


/**
 *
 * @author AppleSauce
 */
public class CreateController implements Initializable {

    @FXML
    private JFXTextField txtfirstName;

    @FXML
    private JFXTextField txtlastName;

    @FXML
    private JFXTextField txtemail;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtRepass;
    
    @FXML
    private JFXButton btnCreate;
    
    @FXML
    private JFXButton btnCancel;
    
   





    /// -- 
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    




    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnCreate) {
            if (createAccount().equals("Success")) {
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Login.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        if(event.getSource() == btnCancel) {
                        try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    //stage.setMaximized(true);
                    stage.close();
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Login.fxml")));
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public CreateController() {
        con = MyConnection.getConnection();
    }

    private String createAccount() {
        String firstName = txtfirstName.getText();
        String lastName = txtlastName.getText();
        String email  = txtemail.getText();
        String userName = txtUsername.getText();
        String pass = txtPassword.getText();
        String re_pass = txtRepass.getText();

                if (userName.equals("")) {
                System.err.println("Please enter a username --///");
                return "Error";
                } else if (pass.equals("")) {
                  System.err.println("Please enter a password --///");
                return "Error";
                } else if (!pass.equals(re_pass)) {
                System.err.println("Please re-enter password");
                return "Error";
                } else if (checkUsername(userName)) {
                 System.err.println("Username is in use!");
                 txtUsername.setUnFocusColor(Color.TOMATO);
                return "Error";
               }
                else {
                    txtUsername.setUnFocusColor(Color.BLACK);
                    PreparedStatement ps;
                    String query = "INSERT INTO loginnew (firstName, lastName, email, username, password) VALUES (?,?,?,?,?)";
                    try {
                        ps = MyConnection.getConnection().prepareStatement(query);
                        //ps.setInt(1, );
                        ps.setString(1, firstName);
                        ps.setString(2, lastName);
                        ps.setString(3, email);
                        ps.setString(4, userName);
                        ps.setString(5, pass);
                   
                        if (ps.executeUpdate() > 0) {
                            
                                //success and go back
                                return ("Success");
                        }

                    } catch(SQLException | HeadlessException ex) {
                       
                    }
                }
                return("Error");
    }
    
    public boolean checkUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT username FROM loginnew WHERE username =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
        }
        return checkUser;
    }
}