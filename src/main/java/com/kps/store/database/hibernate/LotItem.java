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

@Entity
@Table
public class LotItem {
	private Long lotItemId;
	private Uniform uniformName;
	private double costPrice;
	private double gst;
	private int quantity;

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

	@OneToOne(fetch = FetchType.EAGER)
	public Uniform getUniformName() {
		return uniformName;
	}

	public void setUniformName(Uniform uniformName) {
		this.uniformName = uniformName;
	}

	@Column(name = "cost_price")
	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	@Column(name = "gst_at_source")
	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	@Column(name = "item_quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
