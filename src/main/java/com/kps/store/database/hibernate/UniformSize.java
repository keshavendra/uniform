package com.kps.store.database.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="USIZE")
@Entity
public class UniformSize {
	private Long sizeId;
	private GENDER gender;
	private Integer uniformNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "size_id")
	@SequenceGenerator(name = "size_id", sequenceName = "size_id")
	@Column(name = "size_id", updatable = false, nullable = false)
	public Long getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(Long sizeId) {
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
