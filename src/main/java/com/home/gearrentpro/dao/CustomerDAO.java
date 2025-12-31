/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import main.java.com.home.gearrentpro.model.Customer;
import main.java.com.home.gearrentpro.util.DBConnection;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class CustomerDAO {
    
     public Customer findById(int customerId) throws Exception {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Customer c = new Customer();
            c.setCustomerId(rs.getInt("customer_id"));
            c.setName(rs.getString("name"));
            c.setMembershipLevel(rs.getString("membership_level"));
            return c;
        }
        return null;
    }

    public double getActiveDepositTotal(int customerId) throws Exception {

        String sql = """
            SELECT COALESCE(SUM(deposit), 0) total
            FROM rentals
            WHERE customer_id = ?
            AND rental_status = 'ACTIVE'
        """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, customerId);

        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getDouble("total");
    }

    public void insert(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
