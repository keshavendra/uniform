package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.service.SchoolService;

@RestController
@RequestMapping(value = { "/school", "/SCHOOL" })
public class SchoolController {
	@Autowired
	SchoolService schoolService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<SchoolModel> getAllSchools() {
		return schoolService.list();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestBody SchoolModel schoolModel) {
		return schoolService.save(schoolModel);
	}
}
