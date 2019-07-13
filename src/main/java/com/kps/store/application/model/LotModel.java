/**
 * 
 */
package com.kps.store.application.model;

import java.util.Date;
import java.util.List;

/**
 * @author KPS
 *
 */
public class LotModel {
	private Long lotId;
	private String invoiceNumber;
	private VendorModel lotVendor;
	private List<LotItemModel> lotItems;
	private Double extras;
	private Date lotCreatedDate;
	private Date lotModifiedDate;

	public Long getLotId() {
		return lotId;
	}

	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public VendorModel getLotVendor() {
		return lotVendor;
	}

	public void setLotVendor(VendorModel lotVendor) {
		this.lotVendor = lotVendor;
	}

	public List<LotItemModel> getLotItems() {
		return lotItems;
	}

	public void setLotItems(List<LotItemModel> lotItems) {
		this.lotItems = lotItems;
	}

	public Double getExtras() {
		return extras;
	}

	public void setExtras(Double extras) {
		this.extras = extras;
	}

	public Date getLotCreatedDate() {
		if (this.lotCreatedDate != null)
			return (Date) lotCreatedDate.clone();
		return null;
	}

	public void setLotCreatedDate(Date lotCreatedDate) {
		if (lotCreatedDate != null)
			this.lotCreatedDate = (Date) lotCreatedDate.clone();
	}

	public Date getLotModifiedDate() {
		return lotModifiedDate;
	}

	public void setLotModifiedDate(Date lotModifiedDate) {
		if (lotModifiedDate != null)
			this.lotModifiedDate = lotModifiedDate;
	}
}
