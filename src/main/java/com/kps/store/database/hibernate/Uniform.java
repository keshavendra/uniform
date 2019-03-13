package com.kps.store.database.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table(name = "uniform"/*, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "school", "uniform_detail", "size" }, name = "pk_uniforms") }*/)
@AccessType("property")
public class Uniform {
	private Long uniformId;
	private School school;
	private String uniformDetail;
	private UniformSize uniformSize;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uniform_id")
	@SequenceGenerator(name = "uniform_id", sequenceName = "uniform_id")
	@Column(name = "uniform_id", updatable = false, nullable = false)
	public Long getId() {
		return this.uniformId;
	}

	public void setId(long uniform_id) {
		this.uniformId = uniform_id;
	}

	@OneToOne(fetch=FetchType.EAGER)
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

	@OneToOne
	public UniformSize getSize() {
		return uniformSize;
	}

	public void setSize(UniformSize uniformSize) {
		this.uniformSize = uniformSize;
	}

}
