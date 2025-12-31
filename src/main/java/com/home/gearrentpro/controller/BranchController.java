/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
/**
 *
 * @author Dell
 */
public class BranchController {
    
    @FXML
    private TextField txtBranchCode;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TableView<?> tblBranches;

    @FXML
    private void saveBranch() {
        System.out.println("Branch Saved");
    }

    @FXML
    private void updateBranch() {
        System.out.println("Branch Updated");
    }

    @FXML
    private void deleteBranch() {
        System.out.println("Branch Deleted");
    }
}
