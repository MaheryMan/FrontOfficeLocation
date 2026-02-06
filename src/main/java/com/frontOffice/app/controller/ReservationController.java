package com.frontOffice.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.frontOffice.app.service.ReservationService;
import com.frontOffice.app.dto.ReservationDTO;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/reservations")
    public String reservations(Model model){
        ReservationDTO[] reservationDTOs = reservationService.getAllReservations();
        model.addAttribute("reservations", reservationDTOs);
        return "reservations";
    }

    @GetMapping("/reservations/{dateDebut}/{dateFin}")
    public String reservationsByDate(Model model, @PathVariable String dateDebut , @PathVariable String dateFin){
        ReservationDTO reservationDTO = reservationService.getReservationByDate(dateDebut, dateFin);
        model.addAttribute("reservation", reservationDTO);
        return "reservationsByDate";
    }

}
