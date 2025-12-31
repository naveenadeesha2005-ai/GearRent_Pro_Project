/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;


import main.java.com.home.gearrentpro.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Dell
 */
public class RentalDAO {
    
     public void createRental(
            int equipmentId,
            int customerId,
            double amount,
            double deposit) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            String sql = """
                INSERT INTO rentals
                (equipment_id, customer_id, amount, deposit, rental_status)
                VALUES (?, ?, ?, ?, 'ACTIVE')
            """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, equipmentId);
            ps.setInt(2, customerId);
            ps.setDouble(3, amount);
            ps.setDouble(4, deposit);
            ps.executeUpdate();

            new EquipmentDAO().updateStatus(equipmentId, "RENTED");

            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public void insertRental() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateEquipmentStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
