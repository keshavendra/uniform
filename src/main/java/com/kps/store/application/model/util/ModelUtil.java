package com.kps.store.application.model.util;

import java.util.List;
import java.util.stream.Collectors;

import com.kps.store.application.model.LotItemModel;
import com.kps.store.application.model.LotModel;
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.UniformModel;
import com.kps.store.application.model.VendorModel;
import com.kps.store.database.hibernate.GENDER;
import com.kps.store.database.hibernate.Lot;
import com.kps.store.database.hibernate.LotItem;
import com.kps.store.database.hibernate.School;
import com.kps.store.database.hibernate.Uniform;
import com.kps.store.database.hibernate.Vendor;

public class ModelUtil {
	public static List<VendorModel> convertVendorListToVendorModelList(List<Vendor> vendorList) {
		return vendorList.stream().map(x -> convertVendorToVendorModel(x)).collect(Collectors.toList());
	}

	public static List<SchoolModel> convertSchoolListToSchoolModelList(List<School> schoolList) {
		return schoolList.stream().map(x -> convertSchoolToSchoolModel(x)).collect(Collectors.toList());
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
		vendor.setVendorId(vendorModel.getVendorId());
		vendor.setVendorAddress(vendorModel.getVendorAddress());
		vendor.setVendorName(vendorModel.getVendorName());
		vendor.setVendorPhoneNumber(vendorModel.getVendorPhoneNumber());
		return vendor;
	}

	public static School convertToSchoolPojo(SchoolModel schoolModel) {
		School school = new School();
		school.setSchoolName(schoolModel.getSchoolName());
		school.setSchoolId(schoolModel.getSchoolId());
		return school;
	}

	public static Uniform convertToUniformPojo(UniformModel uniformModel) {
		Uniform uniform = new Uniform();
		uniform.setUniformId(uniformModel.getUniformId());
		uniform.setSchool(convertToSchoolPojo(uniformModel.getSchool()));
		uniform.setUniformDetail(uniformModel.getUniformDetail());
		uniform.setUniformId(uniformModel.getUniformId());
		return uniform;
	}

	public static List<UniformModel> convertUniformListToUniformModelList(List<Uniform> uniformList) {
		return uniformList.stream().map(x -> convertUniformToUniformModel(x)).collect(Collectors.toList());
	}

	public static UniformModel convertUniformToUniformModel(Uniform uniform) {
		UniformModel model = new UniformModel();
		model.setUniformId(uniform.getUniformId());
		model.setSchool(convertSchoolToSchoolModel(uniform.getSchool()));
		model.setUniformId(uniform.getUniformId());
		return model;
	}

	public static Lot convertToLotPojo(LotModel lotModel) {
		Lot lot = new Lot();
		lot.setLotId(lotModel.getLotId());
		lot.setInvoiceNumber(lotModel.getInvoiceNumber());
		lot.setExtras(lotModel.getExtras());
		lot.setLotItems(convertLotItemModelListToLotItemList(lotModel.getLotItems()));
		lot.setLotVendor(convertToVendorPojo(lotModel.getLotVendor()));
		lot.setLotCreatedDate(lotModel.getLotCreatedDate());
		lot.setLotModifiedDate(lotModel.getLotModifiedDate());
		return lot;
	}

	public static List<LotItem> convertLotItemModelListToLotItemList(List<LotItemModel> lotItems) {
		return lotItems.stream().map(x -> convertLotItemModelToLotItem(x)).collect(Collectors.toList());
	}

	public static LotItem convertLotItemModelToLotItem(LotItemModel lotItemModel) {
		LotItem lotItem = new LotItem();
		lotItem.setCostPrice(lotItemModel.getCostPrice());
		lotItem.setGst(lotItemModel.getGst());
		lotItem.setLotItemId(lotItemModel.getLotItemId());
		lotItem.setQuantity(lotItemModel.getQuantity());
		lotItem.setUniformName(convertToUniformPojo(lotItemModel.getUniformName()));
		lotItem.setGender(GENDER.valueOf(lotItemModel.getGender()));
		lotItem.setUniformNumber(lotItemModel.getUniformNumber());
		return lotItem;
	}

	public static List<LotModel> convertLotListToLotModelList(List<Lot> lotList) {
		return lotList.stream().map(x -> convertLotToLotModel(x)).collect(Collectors.toList());
	}

	public static LotModel convertLotToLotModel(Lot lot) {
		LotModel lotModel = new LotModel();
		lotModel.setLotId(lot.getLotId());
		lotModel.setExtras(lot.getExtras());
		lotModel.setInvoiceNumber(lot.getInvoiceNumber());
		lotModel.setLotId(lot.getLotId());
		lotModel.setLotItems(convertLotItemListToLotItemModelList(lot.getLotItems()));
		lotModel.setLotVendor(convertVendorToVendorModel(lot.getLotVendor()));
		lotModel.setLotCreatedDate(lot.getLotCreatedDate());
		lotModel.setLotModifiedDate(lot.getLotModifiedDate());
		return lotModel;
	}

	public static List<LotItemModel> convertLotItemListToLotItemModelList(List<LotItem> lotItems) {
		return lotItems.stream().map(x -> convertLotItemToLotItemModel(x)).collect(Collectors.toList());
	}

	private static LotItemModel convertLotItemToLotItemModel(LotItem lotItem) {
		LotItemModel lotItemModel = new LotItemModel();
		lotItemModel.setCostPrice(lotItem.getCostPrice());
		lotItemModel.setGst(lotItem.getGst());
		lotItemModel.setLotItemId(lotItem.getLotItemId());
		lotItemModel.setQuantity(lotItem.getQuantity());
		lotItemModel.setUniformName(convertUniformToUniformModel(lotItem.getUniformName()));
		lotItemModel.setGender(lotItem.getGender().name().toUpperCase());
		lotItemModel.setUniformNumber(lotItem.getUniformNumber());
		return lotItemModel;
	}

}
