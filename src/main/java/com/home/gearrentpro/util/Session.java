/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.util;

import main.java.com.home.gearrentpro.model.User;

/**
 *
 * @author Dell
 */
public class Session {
    
    private static User loggedUser;

    public static void setUser(User user) {
        loggedUser = user;
    }

    public static User getUser() {
        return loggedUser;
    }

    public static boolean isAdmin() {
        return loggedUser != null && "ADMIN".equals(loggedUser.getRole());
    }

    public static boolean isManager() {
        return loggedUser != null && "MANAGER".equals(loggedUser.getRole());
    }

    public static boolean isStaff() {
        return loggedUser != null && "STAFF".equals(loggedUser.getRole());
    }
}
