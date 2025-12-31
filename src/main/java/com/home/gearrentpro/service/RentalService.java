/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.RentalDAO;
import main.java.com.home.gearrentpro.util.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class RentalService {
    
     private final RentalDAO rentalDAO = new RentalDAO();

    public void createRental() throws Exception {

        Connection con = DBConnection.getConnection();
        try {
            con.setAutoCommit(false);

            rentalDAO.insertRental();
            rentalDAO.updateEquipmentStatus();

            con.commit();

        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
}
