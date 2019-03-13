package com.kps.store.application.service;

import java.util.List;

import com.kps.store.application.model.SchoolModel;

public interface SchoolService {
	public String save(SchoolModel schoolModel);
	public List<SchoolModel> list();
}
