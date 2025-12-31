/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import main.java.com.home.gearrentpro.model.Category;
import main.java.com.home.gearrentpro.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.home.gearrentpro.model.Category;
import main.java.com.home.gearrentpro.util.DBConnection;
/**
 *
 * @author Dell
 */
public class CategoryDAO {
    
    public void save(Category category) throws Exception {
        String sql = """
            INSERT INTO categories
            (name, description, price_factor, weekend_multiplier, late_fee, active)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setString(1, category.getName());
        ps.setString(2, category.getDescription());
        ps.setDouble(3, category.getPriceFactor());
        ps.setDouble(4, category.getWeekendMultiplier());
        ps.setDouble(5, category.getLateFee());
        ps.setBoolean(6, category.isActive());

        ps.executeUpdate();
    }

    public List<Category> findActive() throws Exception {
        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM categories WHERE active = 1";
        ResultSet rs = DBConnection.getConnection()
                .createStatement()
                .executeQuery(sql);

        while (rs.next()) {
            Category c = new Category();
            c.setCategoryId(rs.getInt("category_id"));
            c.setName(rs.getString("name"));
            c.setPriceFactor(rs.getDouble("price_factor"));
            c.setWeekendMultiplier(rs.getDouble("weekend_multiplier"));
            c.setLateFee(rs.getDouble("late_fee"));
            list.add(c);
        }
        return list;
    }

    public void insert(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
