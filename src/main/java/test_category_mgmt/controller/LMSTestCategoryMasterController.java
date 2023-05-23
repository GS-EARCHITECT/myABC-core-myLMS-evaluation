package test_category_mgmt.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_category_mgmt.model.dto.LMSTestCategoryMasterDTO;
import test_category_mgmt.services.I_LMSTestCategoryMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testCategoryManagement")
public class LMSTestCategoryMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestCategoryMaster_Controller.class);

	@Autowired
	private I_LMSTestCategoryMasterService lmsTestCategoryMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestCategoryMasterDTO> newtest(@RequestBody LMSTestCategoryMasterDTO testDTO) {
		LMSTestCategoryMasterDTO testDTO2 = lmsTestCategoryMasterServ.newLMSTestCategoryMaster(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTestCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestCategoryMasterDTO>> getAllLMSTestCategoryMasters() {
		ArrayList<LMSTestCategoryMasterDTO> testDTOs = lmsTestCategoryMasterServ.getAllTestCategories();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestCategories", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestCategoryMasterDTO>> getSelectLMSTestCategories(
			@RequestBody ArrayList<BigDecimal> testCatSeqNos) {
		ArrayList<LMSTestCategoryMasterDTO> testDTOs = lmsTestCategoryMasterServ.getSelectTestCategories(testCatSeqNos);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestCategoriesForInst", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestCategoryMasterDTO>> getSelectTestCategoriesForInst(
			@RequestBody ArrayList<Long> sSeqNos) {
		ArrayList<LMSTestCategoryMasterDTO> testDTOs = lmsTestCategoryMasterServ
				.getSelectTestCategoriesForInst(sSeqNos);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@PutMapping("/updTest")
	public void updatetest(@RequestBody LMSTestCategoryMasterDTO testDTO) {
		lmsTestCategoryMasterServ.updLMSTestCategoryMaster(testDTO);
		return;
	}

	@DeleteMapping("/delSelectTestCategories")
	public void deleteSelectTestCategories(@RequestBody ArrayList<BigDecimal> sSeqNoList) {
		lmsTestCategoryMasterServ.delSelectTestCategories(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAlltest")
	public void deleteAllTestCategories() {
		lmsTestCategoryMasterServ.delAllLMSTestCategoryMasters();
		return;
	}

	@DeleteMapping("/delSelectTestsForInst")
	public void delSelectTestCategoriesBetweenTimes(@RequestBody ArrayList<BigDecimal> sSeqNoList) {
		lmsTestCategoryMasterServ.delSelectTestCategories(sSeqNoList);
		return;
	}

}