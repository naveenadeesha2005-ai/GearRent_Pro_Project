/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import main.java.com.home.gearrentpro.model.EquipmentUtilizationReport;
import main.java.com.home.gearrentpro.service.EquipmentUtilizationReportService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
/**
 *
 * @author Dell
 */
public class EquipmentUtilizationReportController {
    
    @FXML private ComboBox<Integer> cmbBranch;
    @FXML private DatePicker dpFrom;
    @FXML private DatePicker dpTo;
    @FXML private TableView<EquipmentUtilizationReport> tblReport;

    @FXML private TableColumn<EquipmentUtilizationReport, Integer> colEquipmentId;
    @FXML private TableColumn<EquipmentUtilizationReport, String> colBrand;
    @FXML private TableColumn<EquipmentUtilizationReport, String> colModel;
    @FXML private TableColumn<EquipmentUtilizationReport, Integer> colRented;
    @FXML private TableColumn<EquipmentUtilizationReport, Integer> colAvailable;
    @FXML private TableColumn<EquipmentUtilizationReport, Double> colUtilization;

    private final EquipmentUtilizationReportService reportService = new EquipmentUtilizationReportService();

    @FXML
    public void initialize() {
        colEquipmentId.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getEquipmentId()).asObject());
        colBrand.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getBrand()));
        colModel.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getModel()));
        colRented.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getRentedDays()).asObject());
        colAvailable.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getAvailableDays()).asObject());
        colUtilization.setCellValueFactory(c -> new javafx.beans.property.SimpleDoubleProperty(c.getValue().getUtilizationPercentage()).asObject());

        cmbBranch.getItems().addAll(1, 2, 3); // sample branch IDs
    }

    @FXML
    public void loadReport() {
        try {
            int branchId = cmbBranch.getValue();
            LocalDate fromDate = dpFrom.getValue();
            LocalDate toDate = dpTo.getValue();

            ObservableList<EquipmentUtilizationReport> data =
                    FXCollections.observableArrayList(
                            reportService.getEquipmentUtilizationReport(branchId, fromDate, toDate)
                    );

            tblReport.setItems(data);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
