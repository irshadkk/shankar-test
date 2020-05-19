package com.irshad.test.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "insurer")
public class Insurer implements Serializable {

    /**N
     *
     */
    private static final long serialVersionUID = 1L;
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int code;
    private String name;


    public Insurer() {
    }

    public Insurer(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}