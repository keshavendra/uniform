package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.VendorModel;
import com.kps.store.application.service.VendorService;

@RestController
@RequestMapping(value = { "/vendor", "/VENDOR" })
public class VendorController {
	@Autowired
	VendorService vendorService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<VendorModel> getAllVendor() {
		return vendorService.getAllVendor();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestBody VendorModel vendorModel) {
		return vendorService.save(vendorModel);
	}
}
