/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.model;

/**
 *
 * @author Dell
 */
public class BranchRevenueReport {
    
     private String branchName;
    private int totalRentals;
    private double rentalIncome;
    private double lateFees;
    private double damageCharges;

    public BranchRevenueReport() {}

    public BranchRevenueReport(String branchName, int totalRentals,
                               double rentalIncome, double lateFees, double damageCharges) {
        this.branchName = branchName;
        this.totalRentals = totalRentals;
        this.rentalIncome = rentalIncome;
        this.lateFees = lateFees;
        this.damageCharges = damageCharges;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getTotalRentals() {
        return totalRentals;
    }

    public double getRentalIncome() {
        return rentalIncome;
    }

    public double getLateFees() {
        return lateFees;
    }

    public double getDamageCharges() {
        return damageCharges;
    }
}
