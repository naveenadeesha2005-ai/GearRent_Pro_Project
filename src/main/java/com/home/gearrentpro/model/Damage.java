/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.model;

/**
 *
 * @author Dell
 */
public class Damage {
    
     private int damageId;
    private int rentalId;
    private String description;
    private double charge;

    public Damage() {}

    // Getters & Setters
    public int getDamageId() { return damageId; }
    public void setDamageId(int damageId) { this.damageId = damageId; }
    public int getRentalId() { return rentalId; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getCharge() { return charge; }
    public void setCharge(double charge) { this.charge = charge; }
}
