package com.example.hospitalback.domain;


import javax.persistence.*;

@Embeddable
public class Adresse {
    @Basic
    @Column(name = "adresse")
    private String adresse;

    @Basic
    @Column(name = "ville")
    private String ville;

    @Basic
    @Column(name = "codepostal")
    private String codepostal;

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getCodepostal() {
        return codepostal;
    }
}
