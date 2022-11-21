package com.vecv.dao;

public class AlertDetailsDao {

	private Integer id;
	private String name;
	private int score;
	private int harshAcceleration;
	private int harshBreaking;
	private int overSpeeding;
	private Integer vehicleId;
	private Integer driverId;

	public AlertDetailsDao() {
		super();
	}

	public AlertDetailsDao(Integer id, String name, int score, int harshAcceleration, int harshBreaking,
			int overSpeeding, Integer vehicleId, Integer driverId) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.harshAcceleration = harshAcceleration;
		this.harshBreaking = harshBreaking;
		this.overSpeeding = overSpeeding;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	@Override
	public String toString() {
		return "AlertDetailsDao [id=" + id + ", name=" + name + ", score=" + score + ", harshAcceleration="
				+ harshAcceleration + ", harshBreaking=" + harshBreaking + ", overSpeeding=" + overSpeeding
				+ ", vehicleId=" + vehicleId + ", driverId=" + driverId + "]";
	}

}
