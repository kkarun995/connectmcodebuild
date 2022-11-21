package com.vecv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_details_master")
@NamedQuery(name = "VehicleDetails.findAll", query = "SELECT c FROM VehicleDetails c")
public class VehicleDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String vehicleId;
	private String vin;
	private String regNo;
	private String make;
	private String model;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "INT(11) UNSIGNED")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "vehicle_id")
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "vin")
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Column(name = "reg_no")
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Column(name = "make")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "VehicleDetails [id=" + id + ", vehicleId=" + vehicleId + ", vin=" + vin + ", regNo=" + regNo + ", make="
				+ make + ", model=" + model + "]";
	}

}
