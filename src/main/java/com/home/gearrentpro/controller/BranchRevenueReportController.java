/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;


import main.java.com.home.gearrentpro.model.BranchRevenueReport;
import main.java.com.home.gearrentpro.service.BranchRevenueReportService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author Dell
 */
public class BranchRevenueReportController {
    
     @FXML private DatePicker dpFrom;
    @FXML private DatePicker dpTo;

    @FXML private TableView<BranchRevenueReport> tblReport;
    @FXML private TableColumn<BranchRevenueReport, String> colBranch;
    @FXML private TableColumn<BranchRevenueReport, Integer> colRentals;
    @FXML private TableColumn<BranchRevenueReport, Double> colIncome;
    @FXML private TableColumn<BranchRevenueReport, Double> colLateFees;
    @FXML private TableColumn<BranchRevenueReport, Double> colDamage;

    private final BranchRevenueReportService reportService = new BranchRevenueReportService();

    @FXML
    public void initialize() {
        colBranch.setCellValueFactory(data -> 
                new javafx.beans.property.SimpleStringProperty(data.getValue().getBranchName()));

        colRentals.setCellValueFactory(data -> 
                new javafx.beans.property.SimpleIntegerProperty(data.getValue().getTotalRentals()).asObject());

        colIncome.setCellValueFactory(data -> 
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getRentalIncome()).asObject());

        colLateFees.setCellValueFactory(data -> 
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getLateFees()).asObject());

        colDamage.setCellValueFactory(data -> 
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getDamageCharges()).asObject());
    }

    @FXML
    public void loadReport() {
        try {
            LocalDate from = dpFrom.getValue();
            LocalDate to = dpTo.getValue();

            tblReport.setItems(FXCollections.observableArrayList(
                    reportService.generateBranchRevenueReport(
                            Date.valueOf(from), Date.valueOf(to))
            ));

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
