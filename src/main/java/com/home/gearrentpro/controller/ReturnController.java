/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 *
 * @author Dell
 */
public class ReturnController {
    
      @FXML
    private TextField txtDamageFee;

    @FXML
    private void processReturn() {
        System.out.println("Return Processed");
    }
}
