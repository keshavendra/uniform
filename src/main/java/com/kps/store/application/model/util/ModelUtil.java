package com.kps.store.application.model.util;

import java.util.ArrayList;
import java.util.List;

import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.VendorModel;
import com.kps.store.database.hibernate.School;
import com.kps.store.database.hibernate.Vendor;

public class ModelUtil {
	public static List<VendorModel> convertVendorListToVendorModelList(List<Vendor> vendorList) {
		List<VendorModel> vendorModelList = new ArrayList<>();
		for (Vendor vendor : vendorList) {
			vendorModelList.add(convertVendorToVendorModel(vendor));
		}
		return vendorModelList;
	}

	public static List<SchoolModel> convertSchoolListToSchoolModelList(List<School> schoolList) {
		List<SchoolModel> schoolModelList = new ArrayList<>();
		for (School school : schoolList) {
			schoolModelList.add(convertSchoolToSchoolModel(school));
		}
		return schoolModelList;
	}

	private static SchoolModel convertSchoolToSchoolModel(School school) {
		SchoolModel schoolModel = new SchoolModel();
		schoolModel.setSchoolId(school.getSchoolId());
		schoolModel.setSchoolName(school.getSchoolName());
		return schoolModel;
	}

	public static VendorModel convertVendorToVendorModel(Vendor vendor) {
		VendorModel model = new VendorModel();
		model.setVendorAddress(vendor.getVendorAddress());
		model.setVendorId(vendor.getVendorId());
		model.setVendorName(vendor.getVendorName());
		model.setVendorPhoneNumber(vendor.getVendorPhoneNumber());
		return model;
	}

	public static Vendor convertToVendorPojo(VendorModel vendorModel) {
		Vendor vendor = new Vendor();
		vendor.setVendorAddress(vendorModel.getVendorAddress());
		vendor.setVendorName(vendorModel.getVendorName());
		vendor.setVendorPhoneNumber(vendorModel.getVendorPhoneNumber());
		return vendor;
	}

	public static School convertToSchoolPojo(SchoolModel schoolModel) {
		School school = new School();
		school.setSchoolName(schoolModel.getSchoolName());
		return school;
	}
}
