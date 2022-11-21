package com.vecv.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "checklist_details")
@NamedQuery(name = "ChecklistDetails.findAll", query = "SELECT c FROM ChecklistDetails c")
public class ChecklistDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String type;
	private String description;
	private Date createdTimestamp;
	private Date updatedTimestamp;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "INT(11) UNSIGNED")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "createdtimestamp")
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Column(name = "updatedtimestamp")
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	@Override
	public String toString() {
		return "ChecklistDetails [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}

}
