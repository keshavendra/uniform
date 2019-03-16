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
import com.kps.store.application.model.UniformSizeModel;
import com.kps.store.application.service.UniformSizeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class UniformSizeControllerTest {

	@InjectMocks
	private UniformSizeController uniformSizeController;

	@Mock
	UniformSizeService mockUniformSizeService;

	MockMvc mockMvc;

	ObjectMapper mapper;

	private static final List<UniformSizeModel> UNIFORM_SIZE_MODEL = Arrays
			.asList(new UniformSizeModel[] { new UniformSizeModel(), new UniformSizeModel() });

	@Before
	public void setup() {
		uniformSizeController = new UniformSizeController();
		mapper = new ObjectMapper();
		MockitoAnnotations.initMocks(this);
		when(mockUniformSizeService.save(any(UniformSizeModel.class))).thenReturn("UniformSize saved with id : ");
		when(mockUniformSizeService.list()).thenReturn(UNIFORM_SIZE_MODEL);
		mockMvc = MockMvcBuilders.standaloneSetup(this.uniformSizeController).build();
	}

	@Test
	public void testSave() {
		UniformSizeModel uniformSizeModel = new UniformSizeModel();
		String message = null;
		try {
			MvcResult mvcResult = mockMvc.perform(post("/uniformsize/save").contentType("application/json")
					.content(mapper.writeValueAsBytes(uniformSizeModel))).andReturn();
			message = mvcResult.getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("UniformSize saved with id : "));
	}

	@Test
	public void testList() {
		List<UniformSizeModel> uniformSizeModelList = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/uniformsize/list")).andReturn();
			uniformSizeModelList = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<List<UniformSizeModel>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(uniformSizeModelList);
		Assert.assertEquals(UNIFORM_SIZE_MODEL.size(), uniformSizeModelList.size());
	}
}
