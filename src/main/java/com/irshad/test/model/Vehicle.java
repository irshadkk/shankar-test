package com.irshad.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String make;
    private String model;
    private String color;
    private String vin;
    private String tareWeight;
    private String grossMass;

    public Vehicle() {
    }

    public Vehicle(String type, String make, String model, String color, String vin, String tareWeight, String grossMass) {
        this.type = type;
        this.make = make;
        this.model = model;
        this.color = color;
        this.vin = vin;
        this.tareWeight = tareWeight;
        this.grossMass = grossMass;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(String tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getGrossMass() {
        return grossMass;
    }

    public void setGrossMass(String grossMass) {
        this.grossMass = grossMass;
    }
}