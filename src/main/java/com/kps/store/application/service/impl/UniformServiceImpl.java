/**
 * 
 */
package com.kps.store.application.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kps.store.application.model.UniformModel;
import com.kps.store.application.model.util.ModelUtil;
import com.kps.store.application.service.UniformService;
import com.kps.store.database.hibernate.Uniform;

/**
 * @author KPS
 *
 */
@Service
public class UniformServiceImpl implements UniformService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public String save(UniformModel uniformModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Uniform uniform = ModelUtil.convertToUniformPojo(uniformModel);
			session.saveOrUpdate(uniform);
			tx.commit();
			message = "Uniform saved with id : " + uniform.getUniformId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

	@Override
	public List<UniformModel> list() {
		List<Uniform> uniformList = null;
		try (Session session = sessionFactory.openSession()) {
			Query<Uniform> query = session.createQuery("from Uniform", Uniform.class);
			uniformList = query.list();
			session.close();
		}
		return ModelUtil.convertUniformListToUniformModelList(uniformList);
	}

}
