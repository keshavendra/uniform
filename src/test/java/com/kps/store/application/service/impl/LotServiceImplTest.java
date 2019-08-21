/**
 * 
 */
package com.kps.store.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.kps.angularproject.application.config.TestDatabaseConfiguration;
import com.kps.store.application.model.LotItemModel;
import com.kps.store.application.model.LotModel;
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.UniformModel;
import com.kps.store.application.model.VendorModel;
import com.kps.store.application.service.LotService;

/**
 * @author KPS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class LotServiceImplTest {
	@Autowired
	SessionFactory sessionFactory;

	@InjectMocks
	LotService lotService;

	@Before
	public void setup() {
		lotService = new LotServiceImpl();
		ReflectionTestUtils.setField(lotService, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSave() {
		LotModel lotModel = getLotModel();
		String message = lotService.save(lotModel);
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("Lot saved with id : "));
	}

	@Test
	public void testList() {
		LotModel lotModel = getLotModel();
		lotService.save(lotModel);
		List<LotModel> lotModelList = lotService.list();
		Assert.assertFalse(CollectionUtils.isEmpty(lotModelList));
	}

	@Test
	public void failSave() {
		LotModel lotModel = getLotModel();
		ReflectionTestUtils.setField(lotService, "sessionFactory", null);
		String message = lotService.save(lotModel);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}

	private LotModel getLotModel() {
		SchoolModel schoolModel = new SchoolModel();
		schoolModel.setSchoolName("LPS");

		UniformModel uniformModel = new UniformModel();
		uniformModel.setSchool(schoolModel);
		uniformModel.setUniformDetail("DummyDetails");

		LotItemModel lotItemModel1 = new LotItemModel();
		lotItemModel1.setCostPrice(12.9);
		lotItemModel1.setGst(12.0);
		lotItemModel1.setQuantity(1);
		lotItemModel1.setUniformName(uniformModel);
		lotItemModel1.setGender("BOY");
		lotItemModel1.setUniformNumber(23);

		LotItemModel lotItemModel2 = new LotItemModel();
		lotItemModel2.setCostPrice(19.9);
		lotItemModel2.setGst(12.0);
		lotItemModel2.setQuantity(4);
		lotItemModel2.setUniformName(uniformModel);
		lotItemModel2.setGender("BOY");
		lotItemModel2.setUniformNumber(23);

		List<LotItemModel> listLotItemModel = new ArrayList<LotItemModel>();
		listLotItemModel.add(lotItemModel1);
		listLotItemModel.add(lotItemModel2);

		VendorModel vendorModel = new VendorModel();
		vendorModel.setVendorAddress("Lucknow");
		vendorModel.setVendorName("Lala Jugal Kishore");
		vendorModel.setVendorPhoneNumber("+1234567890");

		LotModel lotModel = new LotModel();
		lotModel.setExtras(30.1);
		lotModel.setInvoiceNumber("Invoice#123");
		lotModel.setLotItems(listLotItemModel);
		lotModel.setLotVendor(vendorModel);

		return lotModel;
	}
}
