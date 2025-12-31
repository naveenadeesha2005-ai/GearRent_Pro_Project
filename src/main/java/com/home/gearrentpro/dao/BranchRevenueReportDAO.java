/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import main.java.com.home.gearrentpro.util.DBConnection;
import main.java.com.home.gearrentpro.model.BranchRevenueReport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class BranchRevenueReportDAO {
    
     public List<BranchRevenueReport> getBranchRevenueReport(Date fromDate, Date toDate)
            throws Exception {

        String sql = """
            SELECT b.name AS branch_name,
                   COUNT(r.rental_id) AS total_rentals,
                   COALESCE(SUM(r.final_amount), 0) AS rental_income,
                   COALESCE(SUM(r.late_fee), 0) AS late_fees,
                   COALESCE(SUM(d.charge), 0) AS damage_charges
            FROM branch b
            LEFT JOIN rental r ON r.branch_id = b.branch_id
                AND r.start_date BETWEEN ? AND ?
            LEFT JOIN damage d ON d.rental_id = r.rental_id
            GROUP BY b.name
            ORDER BY b.name
            """;

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, fromDate);
        ps.setDate(2, toDate);

        ResultSet rs = ps.executeQuery();
        List<BranchRevenueReport> list = new ArrayList<>();

        while (rs.next()) {
            BranchRevenueReport report = new BranchRevenueReport(
                    rs.getString("branch_name"),
                    rs.getInt("total_rentals"),
                    rs.getDouble("rental_income"),
                    rs.getDouble("late_fees"),
                    rs.getDouble("damage_charges")
            );
            list.add(report);
        }
        return list;
    }
}