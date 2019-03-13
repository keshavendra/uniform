package com.kps.store.application.model.util;

import java.util.ArrayList;
import java.util.List;

import com.kps.store.application.model.VendorModel;
import com.kps.store.database.hibernate.Vendor;

public class ModelUtil {
	public static List<VendorModel> convertToModel(List<Vendor> vendorList) {
		List<VendorModel> vendorModelList = new ArrayList<>();
		for (Vendor vendor : vendorList) {
			vendorModelList.add(convertVendorToVendorModel(vendor));
		}
		return vendorModelList;
	}

	public static VendorModel convertVendorToVendorModel(Vendor vendor) {
		VendorModel model = new VendorModel();
		model.setVendorAddress(vendor.getVendorAddress());
		model.setVendorId(vendor.getVendorId());
		model.setVendorName(vendor.getVendorName());
		model.setVendorPhoneNumber(vendor.getVendorPhoneNumber());
		return model;
	}

	public static Vendor convertToPojo(VendorModel vendorModel) {
		Vendor vendor = new Vendor();
		vendor.setVendorAddress(vendorModel.getVendorAddress());
		vendor.setVendorName(vendorModel.getVendorName());
		vendor.setVendorPhoneNumber(vendorModel.getVendorPhoneNumber());
		return vendor;
	}
}
