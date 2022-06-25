package com.example.hospitalback.domain.patient;

import com.example.hospitalback.domain.Adresse;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Patient", schema = "Hospital", catalog = "")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "datenaissance")
    private LocalDate datenaissance;

    @Basic
    @Column(name = "telephone")
    private String telephone;

    @Embedded
    private Adresse adresse;

    @Basic
    @Column(name = "sexe")
    private String sexe;

    public Patient() {

    }

    public Patient(String firstname, String lastname, LocalDate datenaissance, String telephone, Adresse adresse, String sexe) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.datenaissance = datenaissance;
        this.telephone = telephone;
        this.adresse = adresse;
        this.sexe = sexe;
    }

    public Patient(int id, String firstname, String lastname, LocalDate datenaissance, String telephone, Adresse adresse, String sexe) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.datenaissance = datenaissance;
        this.telephone = telephone;
        this.adresse = adresse;
        this.sexe = sexe;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() && getFirstname().equals(patient.getFirstname()) && getLastname().equals(patient.getLastname()) && getDatenaissance().equals(patient.getDatenaissance()) && getTelephone().equals(patient.getTelephone()) && getAdresse().equals(patient.getAdresse()) && getSexe().equals(patient.getSexe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getDatenaissance(), getTelephone(), getAdresse(), getSexe());
    }

    @Override
    public String toString() {
        return "patient{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", datenaissance=" + datenaissance.toString() +
                ", telephone='" + telephone + '\'' +
                ", adresse=" + adresse +
                ", Sexe='" + sexe + '\'' +
                '}';
    }
}
