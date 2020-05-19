
package com.irshad.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registration")
public class Registration implements Serializable {

    /**
     * N
     */
    private static final long serialVersionUID = 1L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean expired;
    private String expiryDate;

    public Registration() {
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Registration(boolean expired, String expiryDate) {
        this.expired = expired;
        this.expiryDate = expiryDate;
    }
}