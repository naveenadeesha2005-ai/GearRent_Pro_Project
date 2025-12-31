/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;


import main.java.com.home.gearrentpro.dao.BranchDAO;
import main.java.com.home.gearrentpro.model.Branch;
import java.util.List;
/**
 *
 * @author Dell
 */
public class BranchService {
    
     private final BranchDAO branchDAO = new BranchDAO();

    public void addBranch(Branch branch) throws Exception {

        if (branch.getName() == null || branch.getName().isBlank()) {
            throw new RuntimeException("Branch name required");
        }

        branchDAO.save(branch);
    }

    public List<Branch> getAllBranches() throws Exception {
        return branchDAO.findAll();
    }
}
