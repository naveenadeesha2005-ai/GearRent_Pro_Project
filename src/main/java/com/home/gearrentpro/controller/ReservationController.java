/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
/**
 *
 * @author Dell
 */
public class ReservationController {
    
      @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private void reserve() {
        System.out.println("Reservation Created");
    }
}
