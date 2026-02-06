package com.frontOffice.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.frontOffice.app.service.ReservationService;
import com.frontOffice.app.dto.ReservationDTO;

@RestController
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index() {
        return "Front Office Location API";
    }

    @GetMapping("/reservations")
    public List<ReservationDTO> reservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservations/{dateDebut}/{dateFin}")
    public ReservationDTO reservationsByDate(@PathVariable String dateDebut , @PathVariable String dateFin){
        return reservationService.getReservationByDate(dateDebut, dateFin);
    }

}
