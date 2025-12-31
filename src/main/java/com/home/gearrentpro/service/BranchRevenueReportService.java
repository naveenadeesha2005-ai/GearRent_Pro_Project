/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.BranchRevenueReportDAO;
import main.java.com.home.gearrentpro.model.BranchRevenueReport;

import java.sql.Date;
import java.util.List;
/**
 *
 * @author Dell
 */
public class BranchRevenueReportService {
    
    private final BranchRevenueReportDAO reportDAO = new BranchRevenueReportDAO();

    public List<BranchRevenueReport> generateBranchRevenueReport(
            Date fromDate, Date toDate) throws Exception {

        if (fromDate == null || toDate == null) {
            throw new RuntimeException("Date range is required");
        }

        if (fromDate.after(toDate)) {
            throw new RuntimeException("From date cannot be after To date");
        }

        return reportDAO.getBranchRevenueReport(fromDate, toDate);
    }
     
}
