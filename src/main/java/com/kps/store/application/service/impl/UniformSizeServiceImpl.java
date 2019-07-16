package com.kps.store.application.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.model.util.ModelUtil;
import com.kps.store.application.service.UniformSizeService;
import com.kps.store.database.hibernate.UniformSize;

@Service
public class UniformSizeServiceImpl implements UniformSizeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String save(UniformSizeModel uniformSizeModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			UniformSize uniformSize = ModelUtil.convertToUniformSizePojo(uniformSizeModel);
			session.saveOrUpdate(uniformSize);
			tx.commit();
			message = "UniformSize saved with id : " + uniformSize.getSizeId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

	@Override
	public List<UniformSizeModel> list() {
		List<UniformSize> uniformSizeList = null;
		try (Session session = sessionFactory.openSession()) {
			Query<UniformSize> query = session.createQuery("from UniformSize", UniformSize.class);
			uniformSizeList = query.list();
			session.close();
		}
		return ModelUtil.convertUniformSizeListToUniformSizeModelList(uniformSizeList);
	}

}
