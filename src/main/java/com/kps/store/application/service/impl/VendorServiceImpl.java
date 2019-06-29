package com.kps.store.application.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kps.store.application.model.VendorModel;
import com.kps.store.application.model.util.ModelUtil;
import com.kps.store.application.service.VendorService;
import com.kps.store.database.hibernate.Vendor;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<VendorModel> getAllVendor() {
		List<Vendor> vendorList = null;
		try (Session session = sessionFactory.openSession()) {
			Query<Vendor> query = session.createQuery("from Vendor", Vendor.class);
			vendorList = query.list();
			session.close();
		}
		return ModelUtil.convertVendorListToVendorModelList(vendorList);
	}

	@Override
	@Transactional
	public String save(VendorModel vendorModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Vendor vendor = ModelUtil.convertToVendorPojo(vendorModel);
			session.saveOrUpdate(vendor);
			tx.commit();
			message = "Vendor saved with id : " + vendor.getVendorId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

	@Override
	@Transactional(readOnly = true)
	public VendorModel getVendorById(Long vendorId) {
		Vendor vendor = null;
		try (Session session = sessionFactory.openSession()) {
			vendor = session.get(Vendor.class, vendorId);
			session.close();
		}
		return ModelUtil.convertVendorToVendorModel(vendor);
	}
}
