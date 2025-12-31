/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.model;

import java.time.LocalDate;
/**
 *
 * @author Dell
 */
public class Rental {
    
      private int rentalId;
    private int equipmentId;
    private int customerId;
    private int branchId;
    private LocalDate startDate;
    private LocalDate endDate;

    private double rentalAmount;          // Base rental amount
    private double securityDeposit;       // Security deposit
    private double longRentalDiscount;    // Discount for rentals >= 7 days
    private double membershipDiscount;    // Discount based on membership
    private double finalAmount;           // Final payable amount

    private String paymentStatus;         // Paid, Partially Paid, Unpaid
    private String rentalStatus;          // Active, Returned, Overdue, Cancelled

    private Membership membership;        // Optional, linked to customer

    public Rental() {}

    // Getters & Setters
    public int getRentalId() { return rentalId; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }
    public int getEquipmentId() { return equipmentId; }
    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public int getBranchId() { return branchId; }
    public void setBranchId(int branchId) { this.branchId = branchId; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public double getRentalAmount() { return rentalAmount; }
    public void setRentalAmount(double rentalAmount) { this.rentalAmount = rentalAmount; }
    public double getSecurityDeposit() { return securityDeposit; }
    public void setSecurityDeposit(double securityDeposit) { this.securityDeposit = securityDeposit; }
    public double getLongRentalDiscount() { return longRentalDiscount; }
    public void setLongRentalDiscount(double longRentalDiscount) { this.longRentalDiscount = longRentalDiscount; }
    public double getMembershipDiscount() { return membershipDiscount; }
    public void setMembershipDiscount(double membershipDiscount) { this.membershipDiscount = membershipDiscount; }
    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getRentalStatus() { return rentalStatus; }
    public void setRentalStatus(String rentalStatus) { this.rentalStatus = rentalStatus; }
    public Membership getMembership() { return membership; }
    public void setMembership(Membership membership) { this.membership = membership; }
}
