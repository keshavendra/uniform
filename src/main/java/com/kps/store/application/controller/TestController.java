package com.kps.store.application.controller;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.database.hibernate.Vendor;

@RestController
public class TestController {

	private static final Logger logger = Logger.getLogger(TestController.class);

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Vendor test() {
		logger.info("test Method is called");
		logger.info(sessionFactory.getClass());
		Vendor vendor = new Vendor();
		vendor.setVendorAddress("xyz");
		vendor.setVendorName("vendorName");
		vendor.setVendorPhoneNumber("8880207902");
		return vendor;
	}

}
