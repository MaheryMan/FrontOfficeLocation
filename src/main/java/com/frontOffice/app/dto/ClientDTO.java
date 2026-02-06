package com.frontOffice.app.dto;

public class ClientDTO {
    private Long id;
    private String nom;
    private String numeroPassport;
    private String email;
    private String contact;
    public ClientDTO() {}
    public ClientDTO(Long id, String nom, String numeroPassport, String email, String contact) {
        this.id = id;
        this.nom = nom;
        this.numeroPassport = numeroPassport;
        this.email = email;
        this.contact = contact;
    }
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
    public String getNumeroPassport() {
        return numeroPassport;
    }
    public void setNumeroPassport(String numeroPassport) {
        this.numeroPassport = numeroPassport;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
}
