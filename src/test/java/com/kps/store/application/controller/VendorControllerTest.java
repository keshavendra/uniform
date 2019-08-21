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
import com.kps.store.application.model.VendorModel;
import com.kps.store.application.service.VendorService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestDatabaseConfiguration.class })
@Transactional
@Rollback
public class VendorControllerTest {

	@InjectMocks
	private VendorController vendorController;

	@Mock
	VendorService mockVendorService;

	MockMvc mockMvc;

	ObjectMapper mapper;

	private static final List<VendorModel> VENDOR_MODEL_LIST = Arrays
			.asList(new VendorModel[] { new VendorModel(), new VendorModel() });

	@Before
	public void setup() {
		vendorController = new VendorController();
		mapper = new ObjectMapper();
		MockitoAnnotations.initMocks(this);
		when(mockVendorService.save(any(VendorModel.class))).thenReturn("Vendor saved with id : ");
		when(mockVendorService.getAllVendor()).thenReturn(VENDOR_MODEL_LIST);
		when(mockVendorService.getVendorById(1L)).thenReturn(VENDOR_MODEL_LIST.get(0));
		when(mockVendorService.getVendorsByTerm("Kps")).thenReturn(VENDOR_MODEL_LIST);
		mockMvc = MockMvcBuilders.standaloneSetup(this.vendorController).build();
	}

	@Test
	public void testSave() {
		VendorModel vendorModel = new VendorModel();
		String message = null;
		try {
			MvcResult mvcResult = mockMvc.perform(
					post("/vendor/save").contentType("application/json").content(mapper.writeValueAsBytes(vendorModel)))
					.andReturn();
			message = mvcResult.getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(message);
		Assert.assertTrue(message.contains("Vendor saved with id : "));
	}

	@Test
	public void testList() {
		List<VendorModel> vendorModelList = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/vendor/list")).andReturn();
			vendorModelList = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<List<VendorModel>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(vendorModelList);
		Assert.assertEquals(VENDOR_MODEL_LIST.size(), vendorModelList.size());
	}

	@Test
	public void testGetVendorById() {
		VendorModel vendorModel = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/vendor/getVendorById").param("vendorId", "1")).andReturn();
			vendorModel = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<VendorModel>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(vendorModel);
	}

	@Test
	public void testGetVendorsByTerm() {
		List<VendorModel> listVendorModel = null;
		try {
			MvcResult mvcResult = mockMvc.perform(get("/vendor/list/Kes")).andReturn();
			listVendorModel = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(),
					new TypeReference<List<VendorModel>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(listVendorModel);
	}
}
