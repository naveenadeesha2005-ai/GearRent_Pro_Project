/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.ReservationDAO;
import main.java.com.home.gearrentpro.model.Reservation;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author Dell
 */
public class ReservationService {
    
     private final ReservationDAO reservationDAO = new ReservationDAO();

    public void createReservation(Reservation r) throws Exception {

        long days =
            ChronoUnit.DAYS.between(r.getStartDate(), r.getEndDate());

        if (days > 30) {
            throw new RuntimeException("Max reservation period is 30 days");
        }

        boolean overlap =
            reservationDAO.hasOverlappingReservation(
                r.getEquipmentId(),
                r.getStartDate(),
                r.getEndDate()
            );

        if (overlap) {
            throw new RuntimeException("Equipment already reserved");
        }

        reservationDAO.insert(r);
    }
}
