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
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.model.UniformModel;
import com.kps.store.application.service.UniformService;
import com.kps.store.database.hibernate.GENDER;

/**
 * 
 * @author KPS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UniformServiceImplTest {
	@Autowired
	SessionFactory sessionFactory;

	@InjectMocks
	UniformService uniformService;

	@Before
	public void setup() {
		uniformService = new UniformServiceImpl();
		ReflectionTestUtils.setField(uniformService, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSave() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");

		UniformModel uniformModel = new UniformModel();
		uniformModel.setSchool(school);
		uniformModel.setUniformDetail("TestUniform detail");
		String message = uniformService.save(uniformModel);

		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("Uniform saved with id : "));
	}

	@Test
	public void testList() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");

		UniformModel uniformModel = new UniformModel();
		uniformModel.setSchool(school);
		uniformModel.setUniformDetail("TestUniform detail");
		uniformService.save(uniformModel);
		List<UniformModel> uniformModelList = uniformService.list();
		Assert.assertFalse(CollectionUtils.isEmpty(uniformModelList));
	}

	@Test
	public void failSave() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");

		UniformModel uniformModel = new UniformModel();
		uniformModel.setSchool(school);
		uniformModel.setUniformDetail("TestUniform detail");
		ReflectionTestUtils.setField(uniformService, "sessionFactory", null);
		String message = uniformService.save(uniformModel);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}
}
