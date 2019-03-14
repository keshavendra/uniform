/**
 * 
 */
package com.kps.store.application.service.impl;

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
import com.kps.store.application.model.VendorModel;
import com.kps.store.application.service.VendorService;

/**
 * @author KPS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class VendorServiceImplTest {

	@Autowired
	SessionFactory sessionFactory;

	@InjectMocks
	VendorService vendorService;

	@Before
	public void setup() {
		vendorService = new VendorServiceImpl();
		ReflectionTestUtils.setField(vendorService, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSave() {
		VendorModel vendor = new VendorModel();
		vendor.setVendorAddress("Rajajipuram");
		vendor.setVendorName("Tiwari&Sons");
		vendor.setVendorPhoneNumber("+91-8765432190");
		String message = vendorService.save(vendor);
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("Vendor saved with id : "));
	}

	@Test
	public void testList() {
		VendorModel vendor = new VendorModel();
		vendor.setVendorAddress("Rajajipuram");
		vendor.setVendorName("Tiwari&Sons");
		vendor.setVendorPhoneNumber("+91-8765432190");
		vendorService.save(vendor);
		List<VendorModel> vendorModelList = vendorService.getAllVendor();
		Assert.assertFalse(CollectionUtils.isEmpty(vendorModelList));
	}

	@Test
	public void failSave() {
		VendorModel vendor = new VendorModel();
		vendor.setVendorAddress("Rajajipuram");
		vendor.setVendorName("Tiwari&Sons");
		vendor.setVendorPhoneNumber("+91-8765432190");
		ReflectionTestUtils.setField(vendorService, "sessionFactory", null);
		String message = vendorService.save(vendor);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}

}
