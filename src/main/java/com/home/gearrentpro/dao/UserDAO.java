/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;

import java.sql.*;
import main.java.com.home.gearrentpro.util.DBConnection;
import main.java.com.home.gearrentpro.model.User;
/**
 *
 * @author Dell
 */
public class UserDAO {
    
    public User login(String username, String password) throws Exception {

        String sql = """
                SELECT user_id, username, role, branch_id
                FROM users
                WHERE username = ? AND password = ? AND active = 1
                """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            User u = new User();
            u.setUserId(rs.getInt("user_id"));
            u.setUsername(rs.getString("username"));
            u.setRole(rs.getString("role"));
            u.setBranchId(rs.getInt("branch_id"));
            return u;
        }
        return null;
    }
}
