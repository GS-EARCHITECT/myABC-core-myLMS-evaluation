package test_answers_mgmt.controller;

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

import test_answers_mgmt.model.dto.LMSActualExpectedQuestionResponseDTO;
import test_answers_mgmt.model.dto.LMSTestResponseDetailsDTO;
import test_answers_mgmt.services.I_LMSTestResponseDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testResponseManagement")
public class LMSTestResponseController {

//	private static final Logger logger = LoggerFactory.getLogger(LMSTestResponse_Controller.class);

	@Autowired
	private I_LMSTestResponseDetailsService lmsTestResponseDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSTestResponseDetailsDTO> newResponse(@RequestBody LMSTestResponseDetailsDTO testResponseDTO) {
		LMSTestResponseDetailsDTO testResponseDTO2 = lmsTestResponseDetailsServ.newTestResponseDetails(testResponseDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testResponseDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllTestResponseDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestResponseDetailsDTO>> getAllTestResponseDetails() {
		ArrayList<LMSTestResponseDetailsDTO> testResponseDTOs = lmsTestResponseDetailsServ.getAllTestResponseDetails();
		return new ResponseEntity<>(testResponseDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getTestResponseDetails/{pSeqNo}/{qSeqNo}/{sSeqNo}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSTestResponseDetailsDTO> getTestResponseDetails(@PathVariable Long pSeqNo, @PathVariable Long qSeqNo, @PathVariable Long sSeqNo)
	{
		LMSTestResponseDetailsDTO testResponseDTO = lmsTestResponseDetailsServ.getTestResponseDetails(pSeqNo, qSeqNo, sSeqNo);		
		return new ResponseEntity<>(testResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSubjectiveQuestionsList/{pSeqNo}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<Long>> getSubjectiveQuestionsList(@PathVariable Long pSeqNo)
	{
		ArrayList<Long> lstSeqNos = lmsTestResponseDetailsServ.getSubjectiveQuestionsList(pSeqNo);		
		return new ResponseEntity<>(lstSeqNos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getObjectiveQuestionsList/{pSeqNo}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<Long>> getObjectiveQuestionsList(@PathVariable Long pSeqNo)
	{
		ArrayList<Long> lstSeqNos = lmsTestResponseDetailsServ.getObjectiveQuestionsList(pSeqNo);		
		return new ResponseEntity<>(lstSeqNos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getActualExpectedQuestionResponse/{pSeqNo}/{qSeqNo}/{rollNo}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSActualExpectedQuestionResponseDTO> getActualExpectedQuestionResponse(@PathVariable Long pSeqNo, @PathVariable Long qSeqNo, @PathVariable Long rollNo)
	{
		LMSActualExpectedQuestionResponseDTO lmsActualExpectedQuestionResponseDTO = lmsTestResponseDetailsServ.getActualExpectedQuestionResponse(pSeqNo, pSeqNo, rollNo);		
		return new ResponseEntity<>(lmsActualExpectedQuestionResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectTestResponseDetailsForStudents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestResponseDetailsDTO>> getSelectTestResponseDetailsForStudents(@RequestBody ArrayList<Long> responseSeqNos) {
		ArrayList<LMSTestResponseDetailsDTO> testResponseDTOs = lmsTestResponseDetailsServ.getSelectTestResponseDetailsForStudents(responseSeqNos);		
		return new ResponseEntity<>(testResponseDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResponsePapersDetails", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestResponseDetailsDTO>> getSelectResponsePapersDetails(@RequestBody ArrayList<Long> responseSeqNos) {
		ArrayList<LMSTestResponseDetailsDTO> testResponseDTOs = lmsTestResponseDetailsServ.getSelectResponsePapersDetails(responseSeqNos);		
		return new ResponseEntity<>(testResponseDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updTest")
	public void updTestResponseDetails(LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO) 
	{
		lmsTestResponseDetailsServ.updTestResponseDetails(lmsTestResponseDetailsDTO);	
		return;
	}
	
	@PutMapping(value = "/updateResponseMarks/{rollNo}/{pSeqNo}/{qSeqNo}/{marks}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public void updateResponseMarks(@PathVariable Long rollno, @PathVariable Long pSeqNo, @PathVariable Long qSeqNo, @PathVariable Float marks)
	{
		lmsTestResponseDetailsServ.updateResponseMarks(rollno, pSeqNo, qSeqNo, marks);		
		return;
	}

	@DeleteMapping("/delTestResponseDetails")	
	public void deleteSelecttestResponses(@RequestBody LMSTestResponseDetailsDTO testResponseDTO) 
	{
		lmsTestResponseDetailsServ.delTestResponseDetails(testResponseDTO);
		return;
	}
		
	@DeleteMapping("/delSelectResponseDetailsForStudents")
	public void delSelectResponseDetailsForStudents(@RequestBody ArrayList<Long> ids)
	{
		lmsTestResponseDetailsServ.delSelectResponseDetailsForStudents(ids);
		return;
	}
	
	@DeleteMapping("/delAllTestResponseDetails")
	public void delAllTestResponseDetails() 
	{
		lmsTestResponseDetailsServ.delAllTestResponseDetails();
		return;
	}
	
		
}