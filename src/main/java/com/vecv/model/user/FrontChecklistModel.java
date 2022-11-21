package com.vecv.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrontChecklistModel {

	@JsonProperty(value = "wiper_blades_functioning")
	private ChecklistModel wiperBladesFunctioning;
	@JsonProperty(value = "indicators_functioning")
	private ChecklistModel indicatorsFunctioning;
	@JsonProperty(value = "headlamp_functioning")
	private ChecklistModel headlampFunctioning;
	@JsonProperty(value = "fog_lamp")
	private ChecklistModel fogLamp;
	@JsonProperty(value = "number_plate")
	private ChecklistModel numberPlate;
	@JsonProperty(value = "route_board_display")
	private ChecklistModel routeBoardDisplay;
	@JsonProperty(value = "tyre_pressure_ok")
	private ChecklistModel tyrePressureOk;

	public FrontChecklistModel() {
		super();
	}

	public FrontChecklistModel(ChecklistModel wiperBladesFunctioning, ChecklistModel indicatorsFunctioning,
			ChecklistModel headlampFunctioning, ChecklistModel fogLamp, ChecklistModel numberPlate,
			ChecklistModel routeBoardDisplay, ChecklistModel tyrePressureOk) {
		super();
		this.wiperBladesFunctioning = wiperBladesFunctioning;
		this.indicatorsFunctioning = indicatorsFunctioning;
		this.headlampFunctioning = headlampFunctioning;
		this.fogLamp = fogLamp;
		this.numberPlate = numberPlate;
		this.routeBoardDisplay = routeBoardDisplay;
		this.tyrePressureOk = tyrePressureOk;
	}

	public ChecklistModel getWiperBladesFunctioning() {
		return wiperBladesFunctioning;
	}

	public void setWiperBladesFunctioning(ChecklistModel wiperBladesFunctioning) {
		this.wiperBladesFunctioning = wiperBladesFunctioning;
	}

	public ChecklistModel getIndicatorsFunctioning() {
		return indicatorsFunctioning;
	}

	public void setIndicatorsFunctioning(ChecklistModel indicatorsFunctioning) {
		this.indicatorsFunctioning = indicatorsFunctioning;
	}

	public ChecklistModel getHeadlampFunctioning() {
		return headlampFunctioning;
	}

	public void setHeadlampFunctioning(ChecklistModel headlampFunctioning) {
		this.headlampFunctioning = headlampFunctioning;
	}

	public ChecklistModel getFogLamp() {
		return fogLamp;
	}

	public void setFogLamp(ChecklistModel fogLamp) {
		this.fogLamp = fogLamp;
	}

	public ChecklistModel getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(ChecklistModel numberPlate) {
		this.numberPlate = numberPlate;
	}

	public ChecklistModel getRouteBoardDisplay() {
		return routeBoardDisplay;
	}

	public void setRouteBoardDisplay(ChecklistModel routeBoardDisplay) {
		this.routeBoardDisplay = routeBoardDisplay;
	}

	public ChecklistModel getTyrePressureOk() {
		return tyrePressureOk;
	}

	public void setTyrePressureOk(ChecklistModel tyrePressureOk) {
		this.tyrePressureOk = tyrePressureOk;
	}

	@Override
	public String toString() {
		return "FrontChecklistModel [wiperBladesFunctioning=" + wiperBladesFunctioning + ", indicatorsFunctioning="
				+ indicatorsFunctioning + ", headlampFunctioning=" + headlampFunctioning + ", fogLamp=" + fogLamp
				+ ", numberPlate=" + numberPlate + ", routeBoardDisplay=" + routeBoardDisplay + ", tyrePressureOk="
				+ tyrePressureOk + "]";
	}

}
