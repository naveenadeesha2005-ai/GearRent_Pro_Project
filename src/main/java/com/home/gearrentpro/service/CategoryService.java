/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.CategoryDAO;
import main.java.com.home.gearrentpro.model.Category;
import java.util.List;

/**
 *
 * @author Dell
 */
public class CategoryService {
    
     private final CategoryDAO categoryDAO = new CategoryDAO();

    public void addCategory(Category category) throws Exception {

        if (category.getPriceFactor() <= 0) {
            throw new RuntimeException("Invalid base price factor");
        }

        if (category.getWeekendMultiplier() < 1) {
            throw new RuntimeException("Invalid weekend multiplier");
        }

        categoryDAO.insert(category);
    }

    public List<Category> getActiveCategories() throws Exception {
        return categoryDAO.findActive();
    }
}
