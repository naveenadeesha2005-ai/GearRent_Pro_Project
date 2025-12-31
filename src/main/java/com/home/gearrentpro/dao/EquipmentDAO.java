/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;


import main.java.com.home.gearrentpro.model.Equipment;
import main.java.com.home.gearrentpro.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class EquipmentDAO {
    
     public List<Equipment> findAvailableByBranch(int branchId) throws Exception {

        List<Equipment> list = new ArrayList<>();

        String sql = """
            SELECT * FROM equipment
            WHERE branch_id = ?
            AND status = 'AVAILABLE'
        """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, branchId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Equipment e = new Equipment();
            e.setEquipmentId(rs.getInt("equipment_id"));
            e.setBrand(rs.getString("brand"));
            e.setModel(rs.getString("model"));
            e.setDailyPrice(rs.getDouble("daily_price"));
            e.setDeposit(rs.getDouble("deposit"));
            e.setStatus(rs.getString("status"));
            list.add(e);
        }
        return list;
    }

    public void updateStatus(int equipmentId, String status) throws Exception {
        String sql = "UPDATE equipment SET status=? WHERE equipment_id=?";

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setString(1, status);
        ps.setInt(2, equipmentId);
        ps.executeUpdate();
    }

    public void insert(Equipment eq) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
