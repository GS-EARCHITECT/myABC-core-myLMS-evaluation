package test_paper_mgmt.controller;

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

import test_paper_mgmt.model.dto.LMSTestPaperMasterDTO;
import test_paper_mgmt.services.I_LMSTestPaperMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/paperPaperManagement")
public class LMSTestPaperMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestPaperMaster_Controller.class);

	@Autowired
	private I_LMSTestPaperMasterService lmsTestPaperMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestPaperMasterDTO> newpaper(@RequestBody LMSTestPaperMasterDTO paperDTO) {
		LMSTestPaperMasterDTO paperDTO2 = lmsTestPaperMasterServ.newLMSTestPaperMaster(paperDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(paperDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTestPapers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestPaperMasterDTO>> getAllLMSTestPaperMasters() {
		ArrayList<LMSTestPaperMasterDTO> paperDTOs = lmsTestPaperMasterServ.getAllTestPapers();
		return new ResponseEntity<>(paperDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestsPapers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestPaperMasterDTO>> getSelectLMSTestsPapers(
			@RequestBody ArrayList<Long> TestPapersSeqNos) {
		ArrayList<LMSTestPaperMasterDTO> paperDTOs = lmsTestPaperMasterServ.getSelectTestsPapers(TestPapersSeqNos);
		return new ResponseEntity<>(paperDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestPapersBySubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestPaperMasterDTO>> getSelectTestsPapersBySubjects(
			@RequestBody ArrayList<Long> paperSeqNos) {
		ArrayList<LMSTestPaperMasterDTO> paperDTOs = lmsTestPaperMasterServ.getSelectTestsPapersBySubjects(paperSeqNos);
		return new ResponseEntity<>(paperDTOs, HttpStatus.OK);
	}

	@PutMapping("/updTest")
	public void updatepaper(@RequestBody LMSTestPaperMasterDTO paperDTO) {
		lmsTestPaperMasterServ.updLMSTestPaperMaster(paperDTO);
		return;
	}

	@DeleteMapping("/delSelectTestsPapers")
	public void deleteSelectTestPapers(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestPaperMasterServ.delSelectTestsPapers(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllTestPapers")
	public void deleteAllTestPapers() {
		lmsTestPaperMasterServ.delAllLMSTestPaperMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectTestPapersBySubjects")
	public void delSelectTestPapersBySubjects(@RequestBody ArrayList<Long> iSeqNos) {
		lmsTestPaperMasterServ.delSelectTestPapersBySubjects(iSeqNos);
		return;
	}

}