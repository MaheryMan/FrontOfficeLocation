package com.frontOffice.app.dto;

public class HotelDTO {
    private Long id;
    private String nom;
    private Double distance_aeroport;
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
