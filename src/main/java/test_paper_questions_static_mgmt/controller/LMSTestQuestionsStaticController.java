package test_paper_questions_static_mgmt.controller;

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

import test_paper_questions_static_mgmt.model.dto.LMSTestQuestionsStaticDTO;
import test_paper_questions_static_mgmt.services.I_LMSTestQuestionsStaticService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/testPaperQuestionsStaticManagement")
public class LMSTestQuestionsStaticController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestQuestionsStatic_Controller.class);

	@Autowired
	private I_LMSTestQuestionsStaticService lmsTestQuestionsStaticServ;

	@PostMapping("/new")
	public ResponseEntity<LMSTestQuestionsStaticDTO> newPaperQuestion(
			@RequestBody LMSTestQuestionsStaticDTO testPaperQuestionDTO) {
		LMSTestQuestionsStaticDTO testPaperQuestionDTO2 = lmsTestQuestionsStaticServ
				.newPaperQuestion(testPaperQuestionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(testPaperQuestionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllPapersQuestions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestQuestionsStaticDTO>> getAllPapersQuestions() {
		ArrayList<LMSTestQuestionsStaticDTO> testPaperQuestionDTOs = lmsTestQuestionsStaticServ.getAllPapersQuestions();
		return new ResponseEntity<>(testPaperQuestionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getPaperQuestionbyId", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LMSTestQuestionsStaticDTO> getPaperQuestionbyId(@RequestBody LMSTestQuestionsStaticDTO qDTO) {
		LMSTestQuestionsStaticDTO testPaperQuestionDTO = lmsTestQuestionsStaticServ.getPaperQuestionbyId(qDTO);
		return new ResponseEntity<>(testPaperQuestionDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getQuestionForPapersBetweenMarks/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSTestQuestionsStaticDTO>> getSelectLMSTests(
			@RequestBody ArrayList<Long> testPaperSeqNos, @RequestBody Float fr, @RequestBody Float to) {
		ArrayList<LMSTestQuestionsStaticDTO> testPaperQuestionDTOs = lmsTestQuestionsStaticServ
				.getQuestionForPapersBetweenMarks(testPaperSeqNos, fr, to);
		return new ResponseEntity<>(testPaperQuestionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getQuestionMarksForPaper/{pSeqNo}/{qSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Float> getQuestionMarksForPaper(
			@PathVariable Long pSeqNo, @PathVariable Long qSeqNo) 
	{
		Float marks = lmsTestQuestionsStaticServ.getQuestionMarksForPaper(pSeqNo, qSeqNo);
		return new ResponseEntity<>(marks, HttpStatus.OK);
	}

	
	@PutMapping("/updPaperQuestion")
	public void updPaperQuestion(@RequestBody LMSTestQuestionsStaticDTO testPaperQuestionDTO) {
		lmsTestQuestionsStaticServ.updPaperQuestion(testPaperQuestionDTO);
		return;
	}

	@DeleteMapping("/delPaperQuestion")
	public void delPaperQuestion(LMSTestQuestionsStaticDTO testPaperQuestionDTO) {
		lmsTestQuestionsStaticServ.delPaperQuestion(testPaperQuestionDTO);
		return;
	}

	@DeleteMapping("/delAllPaperQuestions")
	public void delAllPaperQuestions() {
		lmsTestQuestionsStaticServ.delAllPaperQuestions();
		return;
	}

	@DeleteMapping("/delSelectQuestionsForPapers")
	public void delSelectQuestionsForPapers(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsTestQuestionsStaticServ.delSelectQuestionsForPapers(sSeqNoList);
		return;
	}

	@DeleteMapping("delQuestionForPapersBetweenMarks/{fr}/{to}")
	public void delSelectTestsBetweenTimes(@PathVariable Float fr, @PathVariable Float to,
			@RequestBody ArrayList<Long> iSeqNos) {
		lmsTestQuestionsStaticServ.delQuestionForPapersBetweenMarks(iSeqNos, fr, to);
		return;
	}

}