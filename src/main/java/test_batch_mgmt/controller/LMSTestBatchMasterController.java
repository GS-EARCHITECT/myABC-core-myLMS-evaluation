package test_batch_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_batch_mgmt.model.dto.LMSTestBatchMasterDTO;
import test_batch_mgmt.services.I_LMSTestBatchMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testBatchManagement")
public class LMSTestBatchMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestBatchMaster_Controller.class);

	@Autowired
	private I_LMSTestBatchMasterService lmsTestBatchMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestBatchMasterDTO> newtestBatch(@RequestBody LMSTestBatchMasterDTO testDTO) {
		LMSTestBatchMasterDTO testDTO2 = lmsTestBatchMasterServ.newLMSTestBatchMaster(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTestBatches", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestBatchMasterDTO>> getAllLMSTestBatchMasters() {
		ArrayList<LMSTestBatchMasterDTO> testDTOs = lmsTestBatchMasterServ.getAllTestEnrolls();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectStudentsForBatches", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestBatchMasterDTO>> getSelectStudentsForBatches(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSTestBatchMasterDTO> testDTOs = lmsTestBatchMasterServ.getSelectStudentsForEnrolls(ids);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectStudents(ArrayList<Long> ids)", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestBatchMasterDTO>> getSelectStudents(@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSTestBatchMasterDTO> testDTOs = lmsTestBatchMasterServ.getSelectStudents(ids);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@PutMapping("/updLMSTestBatch")
	public void updLMSTestBatch(@RequestBody LMSTestBatchMasterDTO testDTO) {
		lmsTestBatchMasterServ.updLMSTestBatchMaster(testDTO);
		return;
	}

	@DeleteMapping("/delSelectStudentsForBatches")
	public void delSelectStudentsForBatches(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestBatchMasterServ.delSelectStudentsForEnrolls(sSeqNoList);
		;
		return;
	}

	@DeleteMapping("/delSelectTests")
	public void deleteSelecttests(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestBatchMasterServ.delSelectStudents(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllTests")
	public void deleteAllTests() {
		lmsTestBatchMasterServ.delAllLMSTestBatchMasters();
		
		return;
	}

}