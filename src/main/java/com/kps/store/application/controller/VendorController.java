package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.VendorModel;
import com.kps.store.application.service.VendorService;

@RestController
@CrossOrigin
@RequestMapping(value = { "/vendor", "/VENDOR" })
public class VendorController {
	@Autowired
	VendorService vendorService;

	@GetMapping
	@RequestMapping(value = "/list")
	public List<VendorModel> getAllVendor() {
		return vendorService.getAllVendor();
	}

	@PostMapping
	@RequestMapping(value = "/save")
	public String save(@RequestBody VendorModel vendorModel) {
		return vendorService.save(vendorModel);
	}

	@GetMapping
	@RequestMapping(value = "/getVendorById")
	public VendorModel getVendorById(@RequestParam(name = "vendorId") String vendorId) {
		return vendorService.getVendorById(Long.parseLong(vendorId));
	}
	
	@GetMapping
	@RequestMapping(value="/list/{term}")
	public List<VendorModel> getVendorsByTerm(@PathVariable("term") String term){
		return vendorService.getVendorsByTerm(term);
	}
}
