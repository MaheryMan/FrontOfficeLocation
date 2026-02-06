package com.frontOffice.app.dto;

import java.time.LocalDateTime;

public class ReservationDTO {
    private Long id;
    private Long idClient;
    private ClientDTO client;
    private Long idHotel;
    private HotelDTO hotel;
    private LocalDateTime dateHeureArrivee;
    private Integer nombrePassager;

    public ReservationDTO() {}

    public ReservationDTO(Long id, Long idClient, ClientDTO client, 
                         Long idHotel, HotelDTO hotel, LocalDateTime dateHeureArrivee, 
                         Integer nombrePassager) {
        this.id = id;
        this.idClient = idClient;
        this.client = client;
        this.idHotel = idHotel;
        this.hotel = hotel;
        this.dateHeureArrivee = dateHeureArrivee;
        this.nombrePassager = nombrePassager;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public LocalDateTime getDateHeureArrivee() {
        return dateHeureArrivee;
    }

    public void setDateHeureArrivee(LocalDateTime dateHeureArrivee) {
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public Integer getNombrePassager() {
        return nombrePassager;
    }

    public void setNombrePassager(Integer nombrePassager) {
        this.nombrePassager = nombrePassager;
    }
}