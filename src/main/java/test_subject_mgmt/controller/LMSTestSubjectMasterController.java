package test_subject_mgmt.controller;

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

import test_subject_mgmt.model.dto.LMSTestSubjectMasterDTO;
import test_subject_mgmt.services.I_LMSTestSubjectMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testSubjectManagement")
public class LMSTestSubjectMasterController {

//	private static final Logger logger = LoggerFactory.getLogger(LMSTestSubjectMaster_Controller.class);

	@Autowired
	private I_LMSTestSubjectMasterService lmsTestSubjectMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSTestSubjectMasterDTO> newtest(@RequestBody LMSTestSubjectMasterDTO testDTO) {
		LMSTestSubjectMasterDTO testDTO2 = lmsTestSubjectMasterServ.newLMSTestSubjectMaster(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllTestSubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestSubjectMasterDTO>> getAllLMSTestSubjectMasters() {
		ArrayList<LMSTestSubjectMasterDTO> testDTOs = lmsTestSubjectMasterServ.getAllTestSubjects();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestsSubjects", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestSubjectMasterDTO>> getSelectLMSTestsSubjects(@RequestBody ArrayList<Long> TestSubjectsSeqNos)
	{
		ArrayList<LMSTestSubjectMasterDTO> testDTOs = lmsTestSubjectMasterServ.getSelectTestsSubjects(TestSubjectsSeqNos);		
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}	

	
	@GetMapping(value = "/getSelectTestSubjects/{testSeqNo}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<Long>> getSelectLMSTestSubjects(@PathVariable Long testSeqNo) {
		ArrayList<Long> testDTOs = lmsTestSubjectMasterServ.getSelectTestSubjects(testSeqNo);		
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectTestSubjectsBetweenTimes/{fr}/{to}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestSubjectMasterDTO>> getSelectTestSubjectsBetweenTimesForInst(@PathVariable String fr, @PathVariable String to, @RequestBody ArrayList<Long> sSeqNos) {
		ArrayList<LMSTestSubjectMasterDTO> testDTOs = lmsTestSubjectMasterServ.getSelectTestsSubjectsBetweenTimes(sSeqNos, fr, to);		
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updTest")
	public void updatetest(@RequestBody LMSTestSubjectMasterDTO testDTO) 
	{
			lmsTestSubjectMasterServ.updLMSTestSubjectMaster(testDTO);	
		return;
	}

	@DeleteMapping("/delSelectTestSubjects")
	public void deleteSelectTestSubjects(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestSubjectMasterServ.delSelectTestSubjects(sSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllTestSubjects")
	public void deleteAllTestSubjects() {
		lmsTestSubjectMasterServ.delAllLMSTestSubjectMasters();;
		return;
	}
	
	@DeleteMapping("/delSelectTestSubjectsBetweenTimes/{fr}/{to}")
	public void delSelectTestSubjectsBetweenTimes(@PathVariable String fr, @PathVariable String to, @RequestBody ArrayList<Long> iSeqNos)
	{
		lmsTestSubjectMasterServ.delSelectTestSubjectsBetweenTimes(iSeqNos, fr, to);
		return;
	}
	
			
}