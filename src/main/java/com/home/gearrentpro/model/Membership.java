/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.model;

/**
 *
 * @author Dell
 */
public class Membership {
    
      private int membershipId;
    private String level; // Regular, Silver, Gold
    private double discountPercentage; // e.g., 0.05 = 5%

    public Membership() {}

    // Getters & Setters
    public int getMembershipId() { return membershipId; }
    public void setMembershipId(int membershipId) { this.membershipId = membershipId; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
}
