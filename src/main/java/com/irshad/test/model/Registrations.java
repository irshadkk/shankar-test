package com.irshad.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registrations")
public class Registrations implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paletNumber;
//
    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Insurer insurers;

    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Vehicle vehicle;

    @OneToOne(orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Registration registration;

    public Registrations() {
    }

    public Registrations(String paletNumber, Insurer insurers, Vehicle vehicle, Registration registration) {
        this.paletNumber = paletNumber;
        this.insurers = insurers;
        this.vehicle = vehicle;
        this.registration = registration;
    }

    public String getPaletNumber() {
        return paletNumber;
    }

    public void setPaletNumber(String paletNumber) {
        this.paletNumber = paletNumber;
    }

    public Insurer getInsurers() {
        return insurers;
    }

    public void setInsurers(Insurer insurers) {
        this.insurers = insurers;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}