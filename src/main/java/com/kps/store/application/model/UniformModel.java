/**
 * 
 */
package com.kps.store.application.model;

/**
 * @author KPS
 *
 */
public class UniformModel {
	private Long uniformId;
	private SchoolModel school;
	private String uniformDetail;
	private UniformSizeModel uniformSize;

	public Long getUniformId() {
		return this.uniformId;
	}

	public void setUniformId(Long uniformId) {
		this.uniformId = uniformId;
	}

	public SchoolModel getSchool() {
		return school;
	}

	public void setSchool(SchoolModel school) {
		this.school = school;
	}

	public String getUniformDetail() {
		return uniformDetail;
	}

	public void setUniformDetail(String uniformDetail) {
		this.uniformDetail = uniformDetail;
	}

	public UniformSizeModel getSize() {
		return uniformSize;
	}

	public void setSize(UniformSizeModel uniformSize) {
		this.uniformSize = uniformSize;
	}
}
