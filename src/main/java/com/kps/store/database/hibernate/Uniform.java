package com.kps.store.database.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "uniform")
public class Uniform {
	private Long uniformId;
	private School school;
	private String uniformDetail;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uniform_id")
	@SequenceGenerator(name = "uniform_id", sequenceName = "uniform_id")
	@Column(name = "uniform_id", updatable = false, nullable = false)
	public Long getUniformId() {
		return this.uniformId;
	}

	public void setUniformId(Long uniformId) {
		this.uniformId = uniformId;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Column(name = "uniform_detail", nullable = false)
	public String getUniformDetail() {
		return uniformDetail;
	}

	public void setUniformDetail(String uniformDetail) {
		this.uniformDetail = uniformDetail;
	}
}
