package com.kps.store.application.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.util.ModelUtil;
import com.kps.store.application.service.SchoolService;
import com.kps.store.database.hibernate.School;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public String save(SchoolModel schoolModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			School school = ModelUtil.convertToSchoolPojo(schoolModel);
			session.save(school);
			tx.commit();
			message = "School saved with id : " + school.getSchoolId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SchoolModel> list() {
		List<School> schoolList = null;
		try (Session session = sessionFactory.openSession()) {
			Query<School> query = session.createQuery("from School", School.class);
			schoolList = query.list();
			session.close();
		}
		return ModelUtil.convertSchoolListToSchoolModelList(schoolList);
	}
	
	@Override
	@Transactional
	public String update(SchoolModel schoolModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			School school = ModelUtil.convertToSchoolPojo(schoolModel);
			session.update(school);
			tx.commit();
			message = "School updated with id : " + school.getSchoolId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

}
