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

import com.kps.store.application.model.LotModel;
import com.kps.store.application.model.util.ModelUtil;
import com.kps.store.application.service.LotService;
import com.kps.store.database.hibernate.Lot;

/**
 * @author KPS
 *
 */
@Service
public class LotServiceImpl implements LotService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public String save(LotModel lotModel) {
		String message;
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Lot lot = ModelUtil.convertToLotPojo(lotModel);
			session.saveOrUpdate(lot);
			tx.commit();
			message = "Lot saved with id : " + lot.getLotId();
		} catch (Exception e) {
			message = "Exception occured while saving object " + e.getMessage();
		}
		return message;
	}

	@Override
	@Transactional(readOnly = true)
	public List<LotModel> list() {
		List<Lot> lotList = null;
		try (Session session = sessionFactory.openSession()) {
			Query<Lot> query = session.createQuery("from Lot", Lot.class);
			lotList = query.list();
			session.close();
		}
		return ModelUtil.convertLotListToLotModelList(lotList);
	}

}
