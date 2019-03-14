package com.kps.store.application.service;

import java.util.List;

import com.kps.store.application.model.UniformModel;

/**
 * 
 * @author KPS
 *
 */
public interface UniformService {
	public String save(UniformModel uniformModel);
	public List<UniformModel> list();
}
