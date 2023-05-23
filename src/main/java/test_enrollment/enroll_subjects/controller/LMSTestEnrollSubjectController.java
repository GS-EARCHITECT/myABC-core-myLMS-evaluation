package test_enrollment.enroll_subjects.controller;

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
import test_enrollment.enroll_subjects.model.dto.LMSTestEnrollSubjectDTO;
import test_enrollment.enroll_subjects.services.I_LMSTestEnrollSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testEnrollSubjectManagement")
public class LMSTestEnrollSubjectController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestEnrollSubject_Controller.class);

	@Autowired
	private I_LMSTestEnrollSubjectService lmsTestEnrollSubjectServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestEnrollSubjectDTO> newtest(@RequestBody LMSTestEnrollSubjectDTO testDTO) {
		LMSTestEnrollSubjectDTO testDTO2 = lmsTestEnrollSubjectServ.newLMSTestEnrollSubject(testDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllTestEnrollSubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollSubjectDTO>> getAllLMSTestEnrollSubjects() {
		ArrayList<LMSTestEnrollSubjectDTO> testDTOs = lmsTestEnrollSubjectServ.getAllTestEnrollSubjects();
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectTestSubjectsByEnrolls(", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollSubjectDTO>> getSelectTestSubjectsByEnrolls(
			@RequestBody ArrayList<Long> testEnrollSeqNos) {
		ArrayList<LMSTestEnrollSubjectDTO> testDTOs = lmsTestEnrollSubjectServ
				.getSelectTestSubjectsByEnrolls(testEnrollSeqNos);
		;
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectEnrollsForSubjects", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestEnrollSubjectDTO>> getSelectEnrollsForSubjects(
			@RequestBody ArrayList<Long> ids) {
		ArrayList<LMSTestEnrollSubjectDTO> testDTOs = lmsTestEnrollSubjectServ.getSelectEnrollsForSubjects(ids);
		return new ResponseEntity<>(testDTOs, HttpStatus.OK);
	}

	@PutMapping("/updLMSTestEnrollSubject")
	public void updLMSTestEnrollSubject(@RequestBody LMSTestEnrollSubjectDTO testDTO) {
		lmsTestEnrollSubjectServ.updLMSTestEnrollSubject(testDTO);
		return;
	}

	@DeleteMapping("/delSelectTestSubjectsByEnrolls")
	public void delSelectTestSubjectsByEnrolls(@RequestBody ArrayList<Long> testEnrollSeqNos) {
		lmsTestEnrollSubjectServ.delSelectTestSubjectsByEnrolls(testEnrollSeqNos);
		return;
	}

	@DeleteMapping("/delAllTestEnrollSubject")
	public void deleteAllTestEnrollSubject() {
		lmsTestEnrollSubjectServ.delAllLMSTestEnrollSubject();
		return;
	}

}