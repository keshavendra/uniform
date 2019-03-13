package com.kps.store.database.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

@Entity
@Table
@AccessType("property")
public class School {
	private Long schoolId;
	private String schoolName;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_id")
	@SequenceGenerator(name = "school_id", sequenceName = "school_id")
	@Column(name = "school_id", updatable = false, nullable = false)
	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	@Column(name = "school_name", nullable = false)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
