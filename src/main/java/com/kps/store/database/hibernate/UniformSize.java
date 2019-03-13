package com.kps.store.database.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Table(name="USIZE")
@Entity
@AccessType("property")
public class UniformSize {
	private long sizeId;
	private GENDER gender;
	private Integer uniformNumber;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "size_id")
	@SequenceGenerator(name = "size_id", sequenceName = "size_id")
	@Column(name = "size_id", updatable = false, nullable = false)
	public long getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}

	@Column(name = "gender")
	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	@Column(name = "uniform_number")
	public Integer getUniformNumber() {
		return uniformNumber;
	}

	public void setUniformNumber(Integer uniformNumber) {
		this.uniformNumber = uniformNumber;
	}
}
