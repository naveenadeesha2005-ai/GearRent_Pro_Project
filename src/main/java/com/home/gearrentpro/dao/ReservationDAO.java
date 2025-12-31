/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import main.java.com.home.gearrentpro.util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import main.java.com.home.gearrentpro.model.Reservation;
/**
 *
 * @author Dell
 */
public class ReservationDAO {
    
    
    public boolean hasOverlap(int equipmentId, String start, String end)
            throws Exception {

        String sql = """
            SELECT COUNT(*) cnt FROM reservations
            WHERE equipment_id = ?
            AND (start_date <= ? AND end_date >= ?)
        """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setInt(1, equipmentId);
        ps.setString(2, end);
        ps.setString(3, start);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt("cnt") > 0;
    }

    public void insert(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean hasOverlappingReservation(int equipmentId, LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
