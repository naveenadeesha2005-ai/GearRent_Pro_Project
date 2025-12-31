/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 *
 * @author Dell
 */
public class RentalController {
    
    
    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private Label lblTotal;

    @FXML
    private void calculateRental() {
        lblTotal.setText("Total: LKR 25,000");
    }

    @FXML
    private void confirmRental() {
        System.out.println("Rental Confirmed");
    }
}
