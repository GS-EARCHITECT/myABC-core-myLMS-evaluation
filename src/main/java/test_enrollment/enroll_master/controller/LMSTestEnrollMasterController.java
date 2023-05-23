package test_enrollment.enroll_master.controller;

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
import test_enrollment.enroll_master.model.dto.LMSTestEnrollMasterDTO;
import test_enrollment.enroll_master.services.I_LMSTestEnrollMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testEnrollMasterManagement")
public class LMSTestEnrollMasterController 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestEnrollMaster_Controller.class);

	@Autowired
	private I_LMSTestEnrollMasterService lmsTestEnrollMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestEnrollMasterDTO> newtest(@RequestBody LMSTestEnrollMasterDTO testDTO) {
		LMSTestEnrollMasterDTO testDTO2 = lmsTestEnrollMasterServ.newLMSTestEnrollMaster(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTestEnrollMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollMasterDTO>> getAllLMSTestEnrollMasters() {
		ArrayList<LMSTestEnrollMasterDTO> testDTOs = lmsTestEnrollMasterServ.getAllTestEnrollMaster();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestEnrollMaster", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollMasterDTO>> getSelectLMSTestEnrollMaster(
			@RequestBody ArrayList<Long> testEnrollSeqNos) {
		ArrayList<LMSTestEnrollMasterDTO> testDTOs = lmsTestEnrollMasterServ
				.getSelectTestEnrollMasters(testEnrollSeqNos);
		;
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestEnrollForTests", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollMasterDTO>> getSelectLMSTestEnrollsForTests(
			@RequestBody ArrayList<Long> testEnrollSeqNos) {
		ArrayList<LMSTestEnrollMasterDTO> testDTOs = lmsTestEnrollMasterServ.getSelectEnrollsForTests(testEnrollSeqNos);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestEnrollForInst", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollMasterDTO>> getSelectLMSTestEnrollsForInst(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSTestEnrollMasterDTO> testDTOs = lmsTestEnrollMasterServ.getSelectEnrollsForInstitutes(ids);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@PutMapping("/updTest")
	public void updatetest(@RequestBody LMSTestEnrollMasterDTO testDTO) {
		lmsTestEnrollMasterServ.updLMSTestEnrollMaster(testDTO);
		return;
	}

	@DeleteMapping("/delSelectTestEnrolls")
	public void delSelectTestEnrolls(@RequestBody ArrayList<Long> testEnrollSeqNos) {
		lmsTestEnrollMasterServ.delSelectTestEnrolls(testEnrollSeqNos);
		return;
	}

	@DeleteMapping("/delSelectEnrollsForInstitutes")
	public void delSelectEnrollsForInstitutes(@RequestBody ArrayList<Long> ids) {
		lmsTestEnrollMasterServ.delSelectEnrollsForInstitutes(ids);
		return;
	}

	@DeleteMapping("/delSelectTestEnrollxForTests")
	public void delSelectTestEnrollxForTests(@RequestBody ArrayList<Long> ids) {
		lmsTestEnrollMasterServ.delSelectTestEnrollxForTests(ids);
		return;
	}

	@DeleteMapping("/delAllTestEnrollMaster")
	public void deleteAllTestEnrollMaster() {
		lmsTestEnrollMasterServ.delAllLMSTestEnrollMaster();
		return;
	}

}