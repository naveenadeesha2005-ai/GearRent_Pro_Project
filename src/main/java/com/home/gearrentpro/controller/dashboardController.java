/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author Dell
 */
public class dashboardController {
    
     @FXML
    private Label lblWelcome;

    public void initialize() {
        lblWelcome.setText("Welcome to GearRent Pro");
    }

    @FXML
    private void openBranches() {
        System.out.println("Open Branch Management");
    }

    @FXML
    private void openEquipment() {
        System.out.println("Open Equipment Management");
    }

    @FXML
    private void openRentals() {
        System.out.println("Open Rentals");
    }

    @FXML
    private void logout() {
        System.out.println("Logout user");
    }
}
