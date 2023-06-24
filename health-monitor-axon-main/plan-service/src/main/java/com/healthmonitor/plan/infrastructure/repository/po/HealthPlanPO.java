package com.healthmonitor.plan.infrastructure.repository.po;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "health_plan")
public class HealthPlanPO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "plan_id")
	private String planId;
	
	private String account;
	private String doctor;
	private String description;
	
	@OneToMany(targetEntity = HealthTaskPO.class, mappedBy = "plan", cascade=CascadeType.PERSIST)
	private List<HealthTaskPO> tasks;
	
	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<HealthTaskPO> getTasks() {
		return tasks;
	}

	public void setTasks(List<HealthTaskPO> tasks) {
		this.tasks = tasks;
	}
}
