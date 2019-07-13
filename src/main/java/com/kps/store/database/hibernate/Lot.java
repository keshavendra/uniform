package com.kps.store.database.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author KPS
 *
 */
@Entity
@Table
public class Lot {
	private Long lotId;
	private String invoiceNumber;
	private Vendor lotVendor;
	private List<LotItem> lotItems;
	private double extras;
	private Date lotCreatedDate;
	private Date lotModifiedDate;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lot_id")
	@SequenceGenerator(name = "lot_id", sequenceName = "lot_id")
	@Column(name = "lot_id", updatable = false, nullable = false)
	public Long getLotId() {
		return lotId;
	}

	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}

	@Column(name = "invoice_number")
	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Vendor getLotVendor() {
		return lotVendor;
	}

	public void setLotVendor(Vendor lotVendor) {
		this.lotVendor = lotVendor;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<LotItem> getLotItems() {
		return lotItems;
	}

	public void setLotItems(List<LotItem> lotItems) {
		this.lotItems = lotItems;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLotCreatedDate() {
		if (this.lotCreatedDate != null)
			return (Date) lotCreatedDate.clone();
		return null;
	}

	public void setLotCreatedDate(Date lotCreatedDate) {
		if (lotCreatedDate != null)
			this.lotCreatedDate = (Date) lotCreatedDate.clone();
	}

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLotModifiedDate() {
		return lotModifiedDate;
	}

	public void setLotModifiedDate(Date lotModifiedDate) {
		if (lotModifiedDate != null)
			this.lotModifiedDate = (Date) lotModifiedDate.clone();
	}

	@Column(name = "lot_extra")
	public double getExtras() {
		return extras;
	}

	public void setExtras(double extras) {
		this.extras = extras;
	}

}
