package com.kps.store.application.service;

import java.util.List;

import com.kps.store.application.model.UniformSizeModel;

/**
 * @author KPS
 *
 */
public interface UniformSizeService {
	public String save(UniformSizeModel uniformSizeModel);
	public List<UniformSizeModel> list();
}
