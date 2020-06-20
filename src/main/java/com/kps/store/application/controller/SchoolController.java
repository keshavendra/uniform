package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.service.SchoolService;

@RestController
@CrossOrigin(methods= {RequestMethod.OPTIONS,RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET},origins= {"http://localhost:4200"})
@RequestMapping(value = { "/school", "/SCHOOL" })
public class SchoolController {
	@Autowired
	SchoolService schoolService;

	@GetMapping
	@RequestMapping(value = "/list")
	public List<SchoolModel> getAllSchools() {
		return schoolService.list();
	}

	@PostMapping
	@RequestMapping(value = "/save")
	public String save(@RequestBody SchoolModel schoolModel) {
		return schoolService.save(schoolModel);
	}
	
	@PutMapping
	@RequestMapping(value = "/update")
	public String update(@RequestBody SchoolModel schoolModel) {
		return schoolService.update(schoolModel);
	}
}
