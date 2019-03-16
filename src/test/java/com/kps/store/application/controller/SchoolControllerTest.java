package com.kps.store.application.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kps.angularproject.application.config.TestDatabaseConfiguration;
import com.kps.store.application.model.SchoolModel;
import com.kps.store.application.service.SchoolService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class SchoolControllerTest {

	@InjectMocks
	private SchoolController schoolController;

	@Mock
	SchoolService mockSchoolService;

	MockMvc mockMvc;

	ObjectMapper mapper;

	private static final List<SchoolModel> USER_MODEL_LIST = Arrays
			.asList(new SchoolModel[] { new SchoolModel(), new SchoolModel() });

	@Before
	public void setup() {
		schoolController = new SchoolController();
		mapper = new ObjectMapper();
		MockitoAnnotations.initMocks(this);
		when(mockSchoolService.save(any(SchoolModel.class))).thenReturn("School saved with id : ");
		when(mockSchoolService.list()).thenReturn(USER_MODEL_LIST);
		mockMvc = MockMvcBuilders.standaloneSetup(this.schoolController).build();
	}

	@Test
	public void testSave() {
		SchoolModel schoolModel = new SchoolModel();
		String message = null;
		try {
			MvcResult mvcResult = mockMvc.perform(
					post("/school/save").contentType("application/json").content(mapper.writeValueAsBytes(schoolModel)))
					.andReturn();
			message = mvcResult.getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("School saved with id : "));
	}

	@Test
	public void testList() {
		List<SchoolModel> schoolModelList = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/school/list")).andReturn();
			schoolModelList = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<List<SchoolModel>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(schoolModelList);
		Assert.assertEquals(USER_MODEL_LIST.size(), schoolModelList.size());
	}
}
