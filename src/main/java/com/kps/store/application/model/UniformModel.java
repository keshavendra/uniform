/**
 * 
 */
package com.kps.store.application.model;

import com.kps.store.database.hibernate.School;
import com.kps.store.database.hibernate.UniformSize;

/**
 * @author KPS
 *
 */
public class UniformModel {
	private Long uniformId;
	private School school;
	private String uniformDetail;
	private UniformSize uniformSize;

	public Long getUniformId() {
		return this.uniformId;
	}

	public void setUniformId(Long uniformId) {
		this.uniformId = uniformId;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getUniformDetail() {
		return uniformDetail;
	}

	public void setUniformDetail(String uniformDetail) {
		this.uniformDetail = uniformDetail;
	}

	public UniformSize getSize() {
		return uniformSize;
	}

	public void setSize(UniformSize uniformSize) {
		this.uniformSize = uniformSize;
	}
}
