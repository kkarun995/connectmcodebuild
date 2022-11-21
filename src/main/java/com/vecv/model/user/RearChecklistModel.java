package com.vecv.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RearChecklistModel {

	@JsonProperty(value = "tail_lamp_functioning")
	private ChecklistModel tailLampFunctioning;
	@JsonProperty(value = "number_plate")
	private ChecklistModel numberPlate;
	@JsonProperty(value = "route_board_display")
	private ChecklistModel routeBoardDisplay;
	@JsonProperty(value = "tyre_pressure_ok")
	private ChecklistModel tyrePressureOk;

	public RearChecklistModel() {
		super();
	}

	public RearChecklistModel(ChecklistModel tailLampFunctioning, ChecklistModel numberPlate,
			ChecklistModel routeBoardDisplay, ChecklistModel tyrePressureOk) {
		super();
		this.tailLampFunctioning = tailLampFunctioning;
		this.numberPlate = numberPlate;
		this.routeBoardDisplay = routeBoardDisplay;
		this.tyrePressureOk = tyrePressureOk;
	}

	public ChecklistModel getTailLampFunctioning() {
		return tailLampFunctioning;
	}

	public void setTailLampFunctioning(ChecklistModel tailLampFunctioning) {
		this.tailLampFunctioning = tailLampFunctioning;
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
		return "RearChecklistModel [tailLampFunctioning=" + tailLampFunctioning + ", numberPlate=" + numberPlate
				+ ", routeBoardDisplay=" + routeBoardDisplay + ", tyrePressureOk=" + tyrePressureOk + "]";
	}

}
