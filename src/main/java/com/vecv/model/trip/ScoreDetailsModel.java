package com.vecv.model.trip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreDetailsModel {

	@JsonProperty(value = "driver_id")
	private Integer driverId;
	private int score;
	@JsonProperty(value = "harsh_acceleration")
	private int harshAcceleration;
	@JsonProperty(value = "harsh_breaking")
	private int harshBreaking;
	@JsonProperty(value = "over_speeding")
	private int overSpeeding;

	public ScoreDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreDetailsModel(Integer driverId, int score, int harshAcceleration, int harshBreaking, int overSpeeding) {
		super();
		this.driverId = driverId;
		this.score = score;
		this.harshAcceleration = harshAcceleration;
		this.harshBreaking = harshBreaking;
		this.overSpeeding = overSpeeding;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHarshAcceleration() {
		return harshAcceleration;
	}

	public void setHarshAcceleration(int harshAcceleration) {
		this.harshAcceleration = harshAcceleration;
	}

	public int getHarshBreaking() {
		return harshBreaking;
	}

	public void setHarshBreaking(int harshBreaking) {
		this.harshBreaking = harshBreaking;
	}

	public int getOverSpeeding() {
		return overSpeeding;
	}

	public void setOverSpeeding(int overSpeeding) {
		this.overSpeeding = overSpeeding;
	}

	@Override
	public String toString() {
		return "ScoreDetailsModel [driverId=" + driverId + ", score=" + score + ", harshAcceleration="
				+ harshAcceleration + ", harshBreaking=" + harshBreaking + ", overSpeeding=" + overSpeeding + "]";
	}

}
