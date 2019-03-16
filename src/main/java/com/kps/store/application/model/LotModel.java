/**
 * 
 */
package com.kps.store.application.model;

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
}
