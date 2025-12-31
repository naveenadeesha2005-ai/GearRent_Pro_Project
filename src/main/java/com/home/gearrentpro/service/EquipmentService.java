/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.EquipmentDAO;
import main.java.com.home.gearrentpro.model.Equipment;
import java.util.List;
/**
 *
 * @author Dell
 */
public class EquipmentService {
    
    private final EquipmentDAO equipmentDAO = new EquipmentDAO();

    public void addEquipment(Equipment eq) throws Exception {

        if (eq.getBaseDailyPrice() <= 0) {
            throw new RuntimeException("Base price must be greater than zero");
        }

        if (eq.getDepositAmount() <= 0) {
            throw new RuntimeException("Deposit must be greater than zero");
        }

        equipmentDAO.insert(eq);
    }

    public void markUnderMaintenance(int equipmentId) throws Exception {
        equipmentDAO.updateStatus(equipmentId, "UNDER_MAINTENANCE");
    }

    public List<Equipment> getAvailableEquipment(int branchId) throws Exception {
        return equipmentDAO.findAvailableByBranch(branchId);
    }
}
