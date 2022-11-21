package com.vecv.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsideChecklistModel {

	@JsonProperty(value = "ac_functioning")
	private ChecklistModel acFunctioning;
	private ChecklistModel soc;
	@JsonProperty(value = "battery_temperature_ok")
	private ChecklistModel batteryTemperatureOk;
	@JsonProperty(value = "fire_extinguisher")
	private ChecklistModel fireExtinguisher;
	private ChecklistModel hammer;
	@JsonProperty(value = "bus_cleanliness_inside")
	private ChecklistModel busCleanlinessInside;
	@JsonProperty(value = "bus_cleanliness_outside")
	private ChecklistModel busCleanlinessOutside;
	@JsonProperty(value = "rear_view_mirror")
	private ChecklistModel rearViewMirror;
	@JsonProperty(value = "fdss_lock")
	private ChecklistModel fdssLock;

	public InsideChecklistModel() {
		super();
	}

	public InsideChecklistModel(ChecklistModel acFunctioning, ChecklistModel soc, ChecklistModel batteryTemperatureOk,
			ChecklistModel fireExtinguisher, ChecklistModel hammer, ChecklistModel busCleanlinessInside,
			ChecklistModel busCleanlinessOutside, ChecklistModel rearViewMirror, ChecklistModel fdssLock) {
		super();
		this.acFunctioning = acFunctioning;
		this.soc = soc;
		this.batteryTemperatureOk = batteryTemperatureOk;
		this.fireExtinguisher = fireExtinguisher;
		this.hammer = hammer;
		this.busCleanlinessInside = busCleanlinessInside;
		this.busCleanlinessOutside = busCleanlinessOutside;
		this.rearViewMirror = rearViewMirror;
		this.fdssLock = fdssLock;
	}

	public ChecklistModel getAcFunctioning() {
		return acFunctioning;
	}

	public void setAcFunctioning(ChecklistModel acFunctioning) {
		this.acFunctioning = acFunctioning;
	}

	public ChecklistModel getSoc() {
		return soc;
	}

	public void setSoc(ChecklistModel soc) {
		this.soc = soc;
	}

	public ChecklistModel getBatteryTemperatureOk() {
		return batteryTemperatureOk;
	}

	public void setBatteryTemperatureOk(ChecklistModel batteryTemperatureOk) {
		this.batteryTemperatureOk = batteryTemperatureOk;
	}

	public ChecklistModel getFireExtinguisher() {
		return fireExtinguisher;
	}

	public void setFireExtinguisher(ChecklistModel fireExtinguisher) {
		this.fireExtinguisher = fireExtinguisher;
	}

	public ChecklistModel getHammer() {
		return hammer;
	}

	public void setHammer(ChecklistModel hammer) {
		this.hammer = hammer;
	}

	public ChecklistModel getBusCleanlinessInside() {
		return busCleanlinessInside;
	}

	public void setBusCleanlinessInside(ChecklistModel busCleanlinessInside) {
		this.busCleanlinessInside = busCleanlinessInside;
	}

	public ChecklistModel getBusCleanlinessOutside() {
		return busCleanlinessOutside;
	}

	public void setBusCleanlinessOutside(ChecklistModel busCleanlinessOutside) {
		this.busCleanlinessOutside = busCleanlinessOutside;
	}

	public ChecklistModel getRearViewMirror() {
		return rearViewMirror;
	}

	public void setRearViewMirror(ChecklistModel rearViewMirror) {
		this.rearViewMirror = rearViewMirror;
	}

	public ChecklistModel getFdssLock() {
		return fdssLock;
	}

	public void setFdssLock(ChecklistModel fdssLock) {
		this.fdssLock = fdssLock;
	}

	@Override
	public String toString() {
		return "InsideChecklistModel [acFunctioning=" + acFunctioning + ", soc=" + soc + ", batteryTemperatureOk="
				+ batteryTemperatureOk + ", fireExtinguisher=" + fireExtinguisher + ", hammer=" + hammer
				+ ", busCleanlinessInside=" + busCleanlinessInside + ", busCleanlinessOutside=" + busCleanlinessOutside
				+ ", rearViewMirror=" + rearViewMirror + ", fdssLock=" + fdssLock + "]";
	}

}
