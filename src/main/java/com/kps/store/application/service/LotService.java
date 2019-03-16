package com.kps.store.application.service;

import java.util.List;

import com.kps.store.application.model.LotModel;

public interface LotService {
	public String save(LotModel lotModel);

	public List<LotModel> list();
}
