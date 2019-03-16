/**
 * 
 */
package com.kps.store.application.model;

/**
 * @author KPS
 *
 */
public class LotItemModel {
	private Long lotItemId;
	private UniformModel uniformName;
	private Double costPrice;
	private Double gst;
	private Integer quantity;

	public Long getLotItemId() {
		return this.lotItemId;
	}

	public void setLotItemId(Long lotItemId) {
		this.lotItemId = lotItemId;
	}

	public UniformModel getUniformName() {
		return uniformName;
	}

	public void setUniformName(UniformModel uniformName) {
		this.uniformName = uniformName;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
