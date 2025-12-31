/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.UserDAO;
import main.java.com.home.gearrentpro.model.User;

/**
 *
 * @author Dell
 */
public class LoginService {
    
       private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) throws Exception {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username is required");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }

        User user = userDAO.login(username, password);

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        return user;
    }

    public User authenticate(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
