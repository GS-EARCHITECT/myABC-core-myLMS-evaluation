package test_master_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test_master_mgmt.model.dto.LMSTestMasterDTO;
import test_master_mgmt.services.I_LMSTestMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testManagement")
public class LMSTestMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestMaster_Controller.class);

	@Autowired
	private I_LMSTestMasterService lmsTestMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestMasterDTO> newtest(@RequestBody LMSTestMasterDTO testDTO) {
		LMSTestMasterDTO testDTO2 = lmsTestMasterServ.newLMSTestMaster(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestMasterDTO>> getAllLMSTestMasters() {
		ArrayList<LMSTestMasterDTO> testDTOs = lmsTestMasterServ.getAllTests();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestsForInst/{iSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestMasterDTO>> getSelectLMSTestsForInst(
			@RequestBody ArrayList<Long> testsSeqNos, @PathVariable ArrayList<Long> iSeqNos) {
		ArrayList<LMSTestMasterDTO> testDTOs = lmsTestMasterServ.getSelectTestsForInst(testsSeqNos, iSeqNos);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestMasterDTO>> getSelectLMSTests(@RequestBody ArrayList<Long> testsSeqNos) {
		ArrayList<LMSTestMasterDTO> testDTOs = lmsTestMasterServ.getSelectTests(testsSeqNos);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestsBetweenTimesForInst/{fr}/{to}/{iSeqNo}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestMasterDTO>> getSelectTestsBetweenTimesForInst(@PathVariable String fr,
			@PathVariable String to, @RequestBody ArrayList<Long> sSeqNos) {
		ArrayList<LMSTestMasterDTO> testDTOs = lmsTestMasterServ.getSelectTestsBetweenTimes(sSeqNos, fr, to);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestMasterDTO>> getSelectTestsBetweenTimes(@PathVariable String fr,
			@PathVariable String to, @RequestBody ArrayList<Long> sSeqNos) {
		ArrayList<LMSTestMasterDTO> testDTOs = lmsTestMasterServ.getSelectTestsBetweenTimes(sSeqNos, fr, to);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@PutMapping("/updTest")
	public void updatetest(@RequestBody LMSTestMasterDTO testDTO) {
		lmsTestMasterServ.updLMSTestMaster(testDTO);
		return;
	}

	@DeleteMapping("/delSelectTestsForInst")
	public void deleteSelecttestsForInst(@RequestBody ArrayList<Long> sSeqNoList,
			@RequestBody ArrayList<Long> iSeqNos) {
		lmsTestMasterServ.delSelectTestsForInst(sSeqNoList, iSeqNos);
		return;
	}

	@DeleteMapping("/delSelectTests")
	public void deleteSelecttests(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestMasterServ.delSelectTests(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllTests")
	public void deleteAllTests() {
		lmsTestMasterServ.delAllLMSTestMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectTestsBetweenTimesForInst/{fr}/{to}")
	public void delSelectTestsBetweenTimes(@PathVariable String fr, @PathVariable String to,
			@RequestBody ArrayList<Long> iSeqNos) {
		lmsTestMasterServ.delSelectTestsBetweenTimesForInst(fr, to, iSeqNos);
		return;
	}

	@DeleteMapping("/delSelectTestsBetweenTimes/{fr}/{to}")
	public void delSelectTestsBetweenTimes(@RequestBody ArrayList<Long> ids, @PathVariable String fr,
			@PathVariable String to) {
		lmsTestMasterServ.delSelectTestsBetweenTimes(ids, fr, to);
		return;
	}

}