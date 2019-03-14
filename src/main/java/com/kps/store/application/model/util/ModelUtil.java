package com.kps.store.application.model.util;

import java.util.ArrayList;
import java.util.List;

import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.UniformModel;
import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.model.VendorModel;
import com.kps.store.database.hibernate.GENDER;
import com.kps.store.database.hibernate.School;
import com.kps.store.database.hibernate.Uniform;
import com.kps.store.database.hibernate.UniformSize;
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

	public static Uniform convertToUniformPojo(UniformModel uniformModel) {
		Uniform uniform = new Uniform();
		uniform.setSchool(uniformModel.getSchool());
		uniform.setSize(uniformModel.getSize());
		uniform.setUniformDetail(uniformModel.getUniformDetail());
		return uniform;
	}

	public static List<UniformModel> convertUniformListToUniformModelList(List<Uniform> uniformList) {
		List<UniformModel> uniformModelList = new ArrayList<>();
		for (Uniform uniform : uniformList) {
			uniformModelList.add(convertUniformToUniformModel(uniform));
		}
		return uniformModelList;
	}

	public static UniformModel convertUniformToUniformModel(Uniform uniform) {
		UniformModel model = new UniformModel();
		model.setUniformId(uniform.getUniformId());
		model.setSchool(uniform.getSchool());
		model.setSize(uniform.getSize());
		model.setUniformId(uniform.getUniformId());
		return model;
	}

	public static UniformSize convertToUniformSizePojo(UniformSizeModel uniformSizeModel) {
		UniformSize uniformSize = new UniformSize();
		uniformSize.setGender(GENDER.valueOf(uniformSizeModel.getGender()));
		uniformSize.setUniformNumber(uniformSizeModel.getUniformNumber());
		return uniformSize;
	}

	public static List<UniformSizeModel> convertUniformSizeListToUniformSizeModelList(
			List<UniformSize> uniformSizeList) {
		List<UniformSizeModel> uniformModelList = new ArrayList<>();
		for (UniformSize uniformSize : uniformSizeList) {
			uniformModelList.add(convertUniformSizeToUniformSizeModel(uniformSize));
		}
		return uniformModelList;
	}

	private static UniformSizeModel convertUniformSizeToUniformSizeModel(UniformSize uniformSize) {
		// TODO Auto-generated method stub
		UniformSizeModel uniformSizeModel = new UniformSizeModel();
		uniformSizeModel.setGender(uniformSize.getGender().name().toUpperCase());
		uniformSizeModel.setSizeId(uniformSize.getSizeId());
		uniformSizeModel.setUniformNumber(uniformSize.getUniformNumber());
		return uniformSizeModel;
	}
}
