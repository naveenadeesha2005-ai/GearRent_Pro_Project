/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.dao;


import main.java.com.home.gearrentpro.model.Branch;
import main.java.com.home.gearrentpro.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.java.com.home.gearrentpro.util.DBConnection;

/**
 *
 * @author Dell
 */
public class BranchDAO {
    
      public void save(Branch branch) throws Exception {
        String sql = """
            INSERT INTO branches (code, name, address, contact_no, status)
            VALUES (?, ?, ?, ?, ?)
        """;

        PreparedStatement ps =
                DBConnection.getConnection().prepareStatement(sql);

        ps.setString(1, branch.getCode());
        ps.setString(2, branch.getName());
        ps.setString(3, branch.getAddress());
        ps.setString(4, branch.getContactNo());
        ps.setString(5, branch.getStatus());

        ps.executeUpdate();
    }

    public List<Branch> findAll() throws Exception {
        List<Branch> list = new ArrayList<>();

        String sql = "SELECT * FROM branches";
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Branch b = new Branch();
            b.setBranchId(rs.getInt("branch_id"));
            b.setCode(rs.getString("code"));
            b.setName(rs.getString("name"));
            b.setAddress(rs.getString("address"));
            b.setContactNo(rs.getString("contact_no"));
            b.setStatus(rs.getString("status"));
            list.add(b);
        }
        return list;
    }
}
