package com.kps.store.application.service;

import java.util.List;

import com.kps.store.application.model.VendorModel;

public interface VendorService {

	public List<VendorModel> getAllVendor();

	public String save(VendorModel vendorModel);

}
