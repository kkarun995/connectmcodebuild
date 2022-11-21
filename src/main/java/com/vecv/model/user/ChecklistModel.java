package com.vecv.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class ChecklistModel {

	@JsonProperty(value = "checklist_id", access = Access.READ_ONLY)
	private Integer checklistId;
	private String name;
	private String type;
	@JsonProperty(value = "status")
	private boolean status;
	@JsonProperty(value = "description", defaultValue = "")
	private String description;

	public ChecklistModel() {
		super();
	}

	public ChecklistModel(Integer checklistId, boolean status, String description) {
		super();
		this.checklistId = checklistId;
		this.status = status;
		this.description = description;
	}

	public ChecklistModel(Integer checklistId, String name, String type, boolean status, String description) {
		super();
		this.checklistId = checklistId;
		this.name = name;
		this.type = type;
		this.status = status;
		this.description = description;
	}

	public Integer getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(Integer checklistId) {
		this.checklistId = checklistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ChecklistModel [checklistId=" + checklistId + ", status=" + status + ", description=" + description
				+ "]";
	}

}
