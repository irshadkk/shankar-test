package com.irshad.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registrations")
public class Registration {

	private long id;
	private String plateNumber;

	public Registration() {

	}

	public Registration(String plateNumber, String lastName, String emailId) {
		this.plateNumber = plateNumber;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "plate_number", nullable = false)
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", plateNumber=" + plateNumber + " ]";
	}

}
