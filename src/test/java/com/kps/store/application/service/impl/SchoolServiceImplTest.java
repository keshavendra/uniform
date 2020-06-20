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
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.service.SchoolService;

/**
 * @author KPS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class SchoolServiceImplTest {
	@Autowired
	SessionFactory sessionFactory;

	@InjectMocks
	SchoolService schoolService;

	@Before
	public void setup() {
		schoolService = new SchoolServiceImpl();
		ReflectionTestUtils.setField(schoolService, "sessionFactory", sessionFactory);
	}

	@Test
	public void testSave() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");
		String message = schoolService.save(school);
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("School saved with id : "));
	}

	@Test
	public void testList() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");
		schoolService.save(school);
		List<SchoolModel> schoolModelList = schoolService.list();
		Assert.assertFalse(CollectionUtils.isEmpty(schoolModelList));
	}

	@Test
	public void failSave() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");
		ReflectionTestUtils.setField(schoolService, "sessionFactory", null);
		String message = schoolService.save(school);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}
	
	@Test
	public void testUpdate() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");
		schoolService.save(school);
		school = schoolService.list().get(0);
		school.setSchoolName("CMS");
		String message = schoolService.update(school);
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("School updated with id : "));
	}
	
	@Test
	public void failUpdate() {
		SchoolModel school = new SchoolModel();
		school.setSchoolName("LPS");
		String message = schoolService.update(school);
		Assert.assertTrue(message.contains("Exception occured while saving object"));
	}
}
