/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.com.home.gearrentpro.model.User;
import main.java.com.home.gearrentpro.service.LoginService;
import main.java.com.home.gearrentpro.util.Session;
/**
 *
 * @author Dell
 */
public class LoginController {
    
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMessage;

    private final LoginService loginService = new LoginService();

    @FXML
    public void login() {
        try {
            User user = loginService.authenticate(
                    txtUsername.getText(),
                    txtPassword.getText()
            );

            if (user != null) {
                Session.setUser(user);
                lblMessage.setText("Login Successful (" + user.getRole() + ")");
                // next: load dashboard
            } else {
                lblMessage.setText("Invalid Username or Password");
            }

        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }
}
