package com.frontOffice.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.frontOffice.app.dto.ReservationDTO;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservationService {

    @Value("${backoffice.api.url}")
    private String backofficeApiUrl;

    public ReservationDTO[] getAllReservations() {
        RestTemplate restTemplate = new RestTemplate();
        String url = backofficeApiUrl + "/reservations";
        
        return restTemplate.getForObject(url, ReservationDTO[].class);
    }

    public ReservationDTO getReservationByDate(String dateDebut , String dateFin) {
        RestTemplate restTemplate = new RestTemplate();
        String url = backofficeApiUrl + "/reservations?dateDebut=" + dateDebut + "&dateFin=" + dateFin;
        
        return restTemplate.getForObject(url, ReservationDTO.class);
    }
}

