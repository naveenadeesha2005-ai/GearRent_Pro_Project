/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.EquipmentUtilizationReportDAO;
import main.java.com.home.gearrentpro.model.EquipmentUtilizationReport;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Dell
 */
public class EquipmentUtilizationReportService {
    
     private final EquipmentUtilizationReportDAO reportDAO = new EquipmentUtilizationReportDAO();

    public List<EquipmentUtilizationReport> getEquipmentUtilizationReport(
            int branchId, LocalDate fromDate, LocalDate toDate) throws Exception {

        if (fromDate.isAfter(toDate)) {
            throw new RuntimeException("Invalid date range");
        }

        return reportDAO.getEquipmentUtilizationReport(branchId, fromDate, toDate);
    }
}
