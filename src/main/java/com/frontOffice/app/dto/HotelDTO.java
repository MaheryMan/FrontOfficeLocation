package com.frontOffice.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelDTO {
    private Long id;
    private String nom;
    
    @JsonProperty("distanceAeroport")
    private Double distance_aeroport;
    
    public HotelDTO() {}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Double getDistance_aeroport() {
        return distance_aeroport;
    }
    public void setDistance_aeroport(Double distance_aeroport) {
        this.distance_aeroport = distance_aeroport;
    }
    
}
