/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
/**
 *
 * @author Dell
 */
public class CategoryController {

     @FXML
    private TextField txtName;

    @FXML
    private TextField txtFactor;

    @FXML
    private TextField txtWeekendMultiplier;

    @FXML
    private CheckBox chkActive;

    @FXML
    private void saveCategory() {
        System.out.println("Category Saved");
    }
    
}
