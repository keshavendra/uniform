package com.kps.store.application.model.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kps.store.application.model.LotItemModel;
import com.kps.store.application.model.LotModel;
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.UniformModel;
import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.model.VendorModel;
import com.kps.store.database.hibernate.GENDER;
import com.kps.store.database.hibernate.Lot;
import com.kps.store.database.hibernate.LotItem;
import com.kps.store.database.hibernate.School;
import com.kps.store.database.hibernate.Uniform;
import com.kps.store.database.hibernate.UniformSize;
import com.kps.store.database.hibernate.Vendor;

public class ModelUtil {
	public static List<VendorModel> convertVendorListToVendorModelList(List<Vendor> vendorList) {
		return vendorList.stream().map(x->convertVendorToVendorModel(x)).collect(Collectors.toList());
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
		uniform.setSize(convertToUniformSizePojo(uniformModel.getSize()));
		uniform.setUniformDetail(uniformModel.getUniformDetail());
		uniform.setUniformId(uniformModel.getUniformId());
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
		model.setSchool(convertSchoolToSchoolModel(uniform.getSchool()));
		model.setSize(convertUniformSizeToUniformSizeModel(uniform.getSize()));
		model.setUniformId(uniform.getUniformId());
		return model;
	}

	public static UniformSize convertToUniformSizePojo(UniformSizeModel uniformSizeModel) {
		UniformSize uniformSize = new UniformSize();
		uniformSize.setSizeId(uniformSizeModel.getSizeId());
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

	public static Lot convertToLotPojo(LotModel lotModel) {
		Lot lot = new Lot();
		lot.setLotId(lotModel.getLotId());
		lot.setInvoiceNumber(lotModel.getInvoiceNumber());
		lot.setExtras(lotModel.getExtras());
		lot.setLotItems(convertLotItemModelListToLotItemList(lotModel.getLotItems()));
		lot.setLotVendor(convertToVendorPojo(lotModel.getLotVendor()));
		return lot;
	}

	public static List<LotItem> convertLotItemModelListToLotItemList(List<LotItemModel> lotItems) {
		List<LotItem> lotItemList = new ArrayList<LotItem>();
		for (LotItemModel lotItemModel : lotItems) {
			lotItemList.add(convertLotItemModelToLotItem(lotItemModel));
		}
		return lotItemList;
	}

	public static LotItem convertLotItemModelToLotItem(LotItemModel lotItemModel) {
		LotItem lotItem = new LotItem();
		lotItem.setCostPrice(lotItemModel.getCostPrice());
		lotItem.setGst(lotItemModel.getGst());
		lotItem.setLotItemId(lotItemModel.getLotItemId());
		lotItem.setQuantity(lotItemModel.getQuantity());
		lotItem.setUniformName(convertToUniformPojo(lotItemModel.getUniformName()));
		return lotItem;
	}

	public static List<LotModel> convertLotListToLotModelList(List<Lot> lotList) {
		return lotList.stream().map(x->convertLotToLotModel(x)).collect(Collectors.toList());
	}

	public static LotModel convertLotToLotModel(Lot lot) {
		LotModel lotModel = new LotModel();
		lotModel.setLotId(lot.getLotId());
		lotModel.setExtras(lot.getExtras());
		lotModel.setInvoiceNumber(lot.getInvoiceNumber());
		lotModel.setLotId(lot.getLotId());
		lotModel.setLotItems(convertLotItemListToLotItemModelList(lot.getLotItems()));
		lotModel.setLotVendor(convertVendorToVendorModel(lot.getLotVendor()));
		return lotModel;
	}

	public static List<LotItemModel> convertLotItemListToLotItemModelList(List<LotItem> lotItems) {
		return lotItems.stream().map(x->convertLotItemToLotItemModel(x)).collect(Collectors.toList());
	}

	private static LotItemModel convertLotItemToLotItemModel(LotItem lotItem) {
		LotItemModel lotItemModel = new LotItemModel();
		lotItemModel.setCostPrice(lotItem.getCostPrice());
		lotItemModel.setGst(lotItem.getGst());
		lotItemModel.setLotItemId(lotItem.getLotItemId());
		lotItemModel.setQuantity(lotItem.getQuantity());
		lotItemModel.setUniformName(convertUniformToUniformModel(lotItem.getUniformName()));
		return lotItemModel;
	}

}
