package com.kps.store.database.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Vendor {
	private Long vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_id")
	@SequenceGenerator(name = "vendor_id", sequenceName = "vendor_id")
	@Column(name = "vendor_id", updatable = false, nullable = false)
	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	@Column(name = "vendor_name", nullable = false)
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name = "vendor_address")
	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	@Column(name = "vendor_phone_number")
	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

}
