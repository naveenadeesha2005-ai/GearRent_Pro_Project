/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Dell
 */
public class CustomerController {
    
      @FXML
    private TextField txtName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtContact;

    @FXML
    private ComboBox<String> cmbMembership;

    @FXML
    private void saveCustomer() {
        System.out.println("Customer Saved");
    }
}
