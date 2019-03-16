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
import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.service.UniformSizeService;
import com.kps.store.database.hibernate.GENDER;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UniformSizeServiceImplTest {
	@Autowired
	SessionFactory sessionFactory;

	@InjectMocks
	UniformSizeService uniformSizeService;

	@Before
	public void setup() {
		uniformSizeService = new UniformSizeServiceImpl();
		ReflectionTestUtils.setField(uniformSizeService, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSave() {
		UniformSizeModel uniformSize = new UniformSizeModel();
		uniformSize.setGender(GENDER.BOY.name().toUpperCase());
		uniformSize.setUniformNumber(30);
		String message = uniformSizeService.save(uniformSize);

		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("UniformSize saved with id : "));
	}

	@Test
	public void testList() {
		UniformSizeModel uniformSize = new UniformSizeModel();
		uniformSize.setGender(GENDER.BOY.name().toUpperCase());
		uniformSize.setUniformNumber(30);
		uniformSizeService.save(uniformSize);
		List<UniformSizeModel> uniformSizeModelList = uniformSizeService.list();
		Assert.assertFalse(CollectionUtils.isEmpty(uniformSizeModelList));
	}

	@Test
	public void failSave() {
		UniformSizeModel uniformSize = new UniformSizeModel();
		uniformSize.setGender(GENDER.BOY.name().toUpperCase());
		uniformSize.setUniformNumber(30);
		ReflectionTestUtils.setField(uniformSizeService, "sessionFactory", null);
		String message = uniformSizeService.save(uniformSize);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}
}
