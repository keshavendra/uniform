package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.service.UniformSizeService;

@RestController
@CrossOrigin
@RequestMapping(value = { "/uniformsize", "/UNIFORMSIZE" })
public class UniformSizeController {
	@Autowired
	UniformSizeService uniformSizeService;

	@GetMapping
	@RequestMapping(value = "/list")
	public List<UniformSizeModel> getAll() {
		return uniformSizeService.list();
	}

	@PostMapping
	@RequestMapping(value = "/save")
	public String save(@RequestBody UniformSizeModel uniformSizeModel) {
		return uniformSizeService.save(uniformSizeModel);
	}
}
