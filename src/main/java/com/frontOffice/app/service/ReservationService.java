package com.frontOffice.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.frontOffice.app.dto.ReservationDTO;
import com.frontOffice.app.dto.ApiResponse;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

@Service
public class ReservationService {

    @Value("${backoffice.api.url}")
    private String backofficeApiUrl;
    
    private final ObjectMapper objectMapper;
    
    public ReservationService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        restTemplate.getMessageConverters().add(0, converter);
        return restTemplate;
    }

    public List<ReservationDTO> getAllReservations() {
        RestTemplate restTemplate = createRestTemplate();
        String url = backofficeApiUrl + "/reservations";
        
        ResponseEntity<ApiResponse<ReservationDTO>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<ApiResponse<ReservationDTO>>() {}
        );
        
        return response.getBody() != null ? response.getBody().getData() : List.of();
    }

    public ReservationDTO getReservationByDate(String dateDebut , String dateFin) {
        RestTemplate restTemplate = createRestTemplate();
        String url = backofficeApiUrl + "/reservations?dateDebut=" + dateDebut + "&dateFin=" + dateFin;
        
        return restTemplate.getForObject(url, ReservationDTO.class);
    }
}

