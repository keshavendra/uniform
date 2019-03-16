/**
 * 
 */
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
import com.kps.store.application.model.LotModel;
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
public class LotControllerTest {

	@InjectMocks
	private LotController lotController;

	@Mock
	LotService mockLotService;

	MockMvc mockMvc;

	ObjectMapper mapper;

	private static final List<LotModel> LOT_LIST = Arrays
			.asList(new LotModel[] { new LotModel(), new LotModel() });

	@Before
	public void setup() {
		lotController = new LotController();
		mapper = new ObjectMapper();
		MockitoAnnotations.initMocks(this);
		when(mockLotService.save(any(LotModel.class))).thenReturn("Lot saved with id : ");
		when(mockLotService.list()).thenReturn(LOT_LIST);
		mockMvc = MockMvcBuilders.standaloneSetup(this.lotController).build();
	}

	@Test
	public void testSave() {
		LotModel lotModel = new LotModel();
		String message = null;
		try {
			MvcResult mvcResult = mockMvc.perform(
					post("/lot/save").contentType("application/json").content(mapper.writeValueAsBytes(lotModel)))
					.andReturn();
			message = mvcResult.getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("Lot saved with id : "));
	}

	@Test
	public void testList() {
		List<LotModel> lotList = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/lot/list")).andReturn();
			lotList = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<List<LotModel>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(lotList);
		Assert.assertEquals(LOT_LIST.size(), lotList.size());
	}
}
