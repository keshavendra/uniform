/**
 * 
 */
package com.kps.store.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kps.store.application.model.LotModel;
import com.kps.store.application.service.LotService;

/**
 * @author KPS
 *
 */
@RestController
@RequestMapping(value = { "/lot", "/LOT" })
public class LotController {
	@Autowired
	LotService lotService;

	@GetMapping
	@RequestMapping(value = "/list")
	public List<LotModel> getAllSchools() {
		return lotService.list();
	}

	@PostMapping
	@RequestMapping(value = "/save")
	public String save(@RequestBody LotModel lotModel) {
		return lotService.save(lotModel);
	}
}
