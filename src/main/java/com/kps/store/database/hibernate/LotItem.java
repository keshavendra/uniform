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
@Table
public class LotItem {
	private Long lotItemId;
	private Uniform uniformName;
	private Double costPrice;
	private Double gst;
	private Integer quantity;
	private GENDER gender;
	private Integer uniformNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lot_item_id")
	@SequenceGenerator(name = "lot_item_id", sequenceName = "lot_item_id")
	@Column(name = "lot_item_id", updatable = false, nullable = false)
	public Long getLotItemId() {
		return this.lotItemId;
	}

	public void setLotItemId(Long lotItemId) {
		this.lotItemId = lotItemId;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Uniform getUniformName() {
		return uniformName;
	}

	public void setUniformName(Uniform uniformName) {
		this.uniformName = uniformName;
	}

	@Column(name = "cost_price")
	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "gst_at_source")
	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	@Column(name = "item_quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
