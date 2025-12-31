/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import main.java.com.home.gearrentpro.model.EquipmentUtilizationReport;
import main.java.com.home.gearrentpro.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class EquipmentUtilizationReportDAO {
    
public List<EquipmentUtilizationReport> getEquipmentUtilizationReport(
            int branchId, LocalDate fromDate, LocalDate toDate) throws Exception {

        String sql = """
            SELECT e.equipment_id, e.brand, e.model,
                   r.start_date, r.end_date
            FROM equipment e
            LEFT JOIN rentals r
              ON e.equipment_id = r.equipment_id
             AND r.branch_id = ?
             AND r.start_date <= ?
             AND r.end_date >= ?
            WHERE e.branch_id = ?
            """;

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, branchId);
        ps.setDate(2, java.sql.Date.valueOf(toDate));
        ps.setDate(3, java.sql.Date.valueOf(fromDate));
        ps.setInt(4, branchId);

        ResultSet rs = ps.executeQuery();

        List<EquipmentUtilizationReport> list = new ArrayList<>();

        long totalDays = ChronoUnit.DAYS.between(fromDate, toDate) + 1;

        while (rs.next()) {

            LocalDate rentalStart = rs.getDate("start_date") != null
                    ? rs.getDate("start_date").toLocalDate() : null;

            LocalDate rentalEnd = rs.getDate("end_date") != null
                    ? rs.getDate("end_date").toLocalDate() : null;

            long rentedDays = 0;

            if (rentalStart != null && rentalEnd != null) {
                LocalDate overlapStart = rentalStart.isAfter(fromDate) ? rentalStart : fromDate;
                LocalDate overlapEnd = rentalEnd.isBefore(toDate) ? rentalEnd : toDate;

                if (!overlapStart.isAfter(overlapEnd)) {
                    rentedDays = ChronoUnit.DAYS.between(overlapStart, overlapEnd) + 1;
                }
            }

            EquipmentUtilizationReport report = new EquipmentUtilizationReport();
            report.setEquipmentId(rs.getInt("equipment_id"));
            report.setBrand(rs.getString("brand"));
            report.setModel(rs.getString("model"));
            report.setRentedDays((int) rentedDays);
            report.setAvailableDays((int) (totalDays - rentedDays));
            report.setUtilizationPercentage(
                    totalDays == 0 ? 0 : (rentedDays * 100.0) / totalDays
            );

            list.add(report);
        }

        return list;
   }
}
   
   