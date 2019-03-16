/**
 * 
 */
package com.kps.store.application.model;

/**
 * @author KPS
 *
 */
public class UniformSizeModel {
	private Long sizeId;
	private String gender;
	private Integer uniformNumber;

	public Long getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getUniformNumber() {
		return uniformNumber;
	}

	public void setUniformNumber(Integer uniformNumber) {
		this.uniformNumber = uniformNumber;
	}
}
