package test_answers_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test_answers_mgmt.model.dto.LMSActualExpectedQuestionResponseDTO;
import test_answers_mgmt.model.dto.LMSSubjectQuestionsMasterDTO;
import test_answers_mgmt.model.dto.LMSTestResponseDetailsDTO;
import test_answers_mgmt.model.master.LMSTestResponseDetails;
import test_answers_mgmt.model.master.LMSTestResponseDetailsPK;
import test_answers_mgmt.model.repo.LMSTestResponseDetailsRepo;
import test_paper_questions_static_mgmt.model.dto.LMSTestQuestionsStaticDTO;
import test_paper_questions_static_mgmt.services.LMSTestQuestionsStaticService;

@Service("lmsTestResponseDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSTestResponseDetailsService implements I_LMSTestResponseDetailsService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestResponseDetails_Controller.class);

	@Autowired
	private LMSTestResponseDetailsRepo lmsTestResponseDetailsRepo;
	
	@Autowired
	private LMSTestQuestionsStaticService lmsTestQuestionsStaticServ;
	
	@Autowired
	private WebClient webClient;
	
	public ArrayList<Long> getSubjectiveQuestionsList(Long pSeqNo) 
	{
		ArrayList<Long> pList = new ArrayList<Long>();
		pList.add(pSeqNo);
				 
		ArrayList<LMSTestQuestionsStaticDTO> qList = lmsTestQuestionsStaticServ.getSelectQuestionsForPapers(pList);
		
		Flux<Long> qSeqNoList = webClient.method(HttpMethod.GET)
				.uri("/subjectQuestionsMasterQuestionsManagement/getSubjectiveInList")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Flux.fromIterable(qList), Long.class).retrieve().bodyToFlux(Long.class);
		ArrayList<Long> filteredSeqNos = (ArrayList<Long>) qSeqNoList.collectList().block();
				
		return filteredSeqNos;
	}
	
	public ArrayList<Long> getObjectiveQuestionsList(Long pSeqNo) 
	{
		ArrayList<Long> pList = new ArrayList<Long>();
		pList.add(pSeqNo);
				 
		ArrayList<LMSTestQuestionsStaticDTO> qList = lmsTestQuestionsStaticServ.getSelectQuestionsForPapers(pList);
		
		Flux<Long> qSeqNoList = webClient.method(HttpMethod.GET)
				.uri("/subjectQuestionsMasterQuestionsManagement/getObjectiveInList")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Flux.fromIterable(qList), Long.class).retrieve().bodyToFlux(Long.class);
		ArrayList<Long> filteredSeqNos = (ArrayList<Long>) qSeqNoList.collectList().block();
				
		return filteredSeqNos;
	}
	
	public LMSActualExpectedQuestionResponseDTO getActualExpectedQuestionResponse(Long pSeqNo, Long qSeqNo, Long rollNo) 
	{
		Float marks = lmsTestQuestionsStaticServ.getQuestionMarksForPaper(pSeqNo, qSeqNo); 
		
		Mono<LMSSubjectQuestionsMasterDTO> lmsSubDTO = webClient.method(HttpMethod.GET).uri("/subjectQuestionsMasterQuestionsManagement/getById/"+qSeqNo)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(qSeqNo), Long.class).retrieve()
				.bodyToMono(LMSSubjectQuestionsMasterDTO.class);		
		LMSSubjectQuestionsMasterDTO lmsSubjectQuestionsMasterDTO = lmsSubDTO.block();		
		
		LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO = this.getTestResponseDetails(pSeqNo, qSeqNo, rollNo);		
		LMSActualExpectedQuestionResponseDTO lmsActualExpectedQuestionResponseDTO = new LMSActualExpectedQuestionResponseDTO();
		lmsActualExpectedQuestionResponseDTO.setLmsSubjectQuestionsMasterDTO(lmsSubjectQuestionsMasterDTO);
		lmsActualExpectedQuestionResponseDTO.setLmsTestResponseDetailsDTO(lmsTestResponseDetailsDTO);
		lmsActualExpectedQuestionResponseDTO.setpSeqNo(pSeqNo);
		lmsActualExpectedQuestionResponseDTO.setqSeqNo(qSeqNo);
		lmsActualExpectedQuestionResponseDTO.setRollNo(rollNo);
		lmsActualExpectedQuestionResponseDTO.setMax_marks(marks);
		return lmsActualExpectedQuestionResponseDTO;
	}

	public void updateResponseMarks(Long rollno, Long pSeqNo, Long qSeqNo, Float marks)
	 {		 
	 lmsTestResponseDetailsRepo.updateResponseMarks(rollno, pSeqNo, qSeqNo, marks);;
	 }
	 
	
	public LMSTestResponseDetailsDTO newTestResponseDetails(LMSTestResponseDetailsDTO testResponseDTO) {
		LMSTestResponseDetailsPK lmsTestResponseDetailsPK = new LMSTestResponseDetailsPK();
		lmsTestResponseDetailsPK.setPaperSeqNo(testResponseDTO.getPaperSeqNo());
		lmsTestResponseDetailsPK.setqSeqNo(testResponseDTO.getqSeqNo());
		lmsTestResponseDetailsPK.setTestRollNumber(testResponseDTO.getTestRollNumber());
		LMSTestResponseDetails lmsTestResponseDetails = null;

		if (!lmsTestResponseDetailsRepo.existsById(lmsTestResponseDetailsPK)) {
			lmsTestResponseDetails = this.setTestResponseDetails(testResponseDTO);
			lmsTestResponseDetails.setId(lmsTestResponseDetailsPK);
			testResponseDTO = getTestResponseDetailsDTO(lmsTestResponseDetailsRepo.save(lmsTestResponseDetails));
		}
		return testResponseDTO;
	}

	public ArrayList<LMSTestResponseDetailsDTO> getAllTestResponseDetails() {
		ArrayList<LMSTestResponseDetailsDTO> courseTestResponseDetailsDTOs = new ArrayList<LMSTestResponseDetailsDTO>();
		ArrayList<LMSTestResponseDetails> courseTestResponseDetailsOpts = (ArrayList<LMSTestResponseDetails>) lmsTestResponseDetailsRepo
				.findAll();

		if (courseTestResponseDetailsOpts != null) {
			courseTestResponseDetailsDTOs = getTestResponseDetailsDTOs(courseTestResponseDetailsOpts);
		} else {
			courseTestResponseDetailsDTOs = null;
		}

		return courseTestResponseDetailsDTOs;
	}

	public LMSTestResponseDetailsDTO getTestResponseDetails(Long pSeqNo, Long qSeqNo, Long sSeqNo) 
	{
		LMSTestResponseDetailsPK lmsTestResponseDetailsPK = new LMSTestResponseDetailsPK();
		lmsTestResponseDetailsPK.setPaperSeqNo(pSeqNo);
		lmsTestResponseDetailsPK.setqSeqNo(qSeqNo);
		lmsTestResponseDetailsPK.setTestRollNumber(sSeqNo);
		LMSTestResponseDetails lmsTestResponseDetails = null;
		LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO = null;

		if (lmsTestResponseDetailsRepo.existsById(lmsTestResponseDetailsPK)) {
			lmsTestResponseDetails = lmsTestResponseDetailsRepo.findById(lmsTestResponseDetailsPK).get();
			lmsTestResponseDetailsDTO = getTestResponseDetailsDTO(lmsTestResponseDetails);
		}
		return lmsTestResponseDetailsDTO;
	}

	public ArrayList<LMSTestResponseDetailsDTO> getSelectTestResponseDetailsForStudents(ArrayList<Long> ids) {
		ArrayList<LMSTestResponseDetails> lTestResponseDetailss = lmsTestResponseDetailsRepo
				.getSelectResponseDetailsForStudents(ids);
		ArrayList<LMSTestResponseDetailsDTO> LMSTestResponseDetailsDTOs = null;

		if (lTestResponseDetailss != null) {
			LMSTestResponseDetailsDTOs = getTestResponseDetailsDTOs(lTestResponseDetailss);
		}

		return LMSTestResponseDetailsDTOs;
	}

	public ArrayList<LMSTestResponseDetailsDTO> getSelectResponsePapersDetails(ArrayList<Long> ids) {
		ArrayList<LMSTestResponseDetails> lTestResponseDetailss = lmsTestResponseDetailsRepo
				.getSelectResponsePapersDetails(ids);
		ArrayList<LMSTestResponseDetailsDTO> LMSTestResponseDetailsDTOs = null;

		if (lTestResponseDetailss != null) {
			LMSTestResponseDetailsDTOs = getTestResponseDetailsDTOs(lTestResponseDetailss);
		}

		return LMSTestResponseDetailsDTOs;
	}

	public void updTestResponseDetails(LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO) {
		LMSTestResponseDetailsPK lmsTestResponseDetailsPK = new LMSTestResponseDetailsPK();
		lmsTestResponseDetailsPK.setPaperSeqNo(lmsTestResponseDetailsDTO.getPaperSeqNo());
		lmsTestResponseDetailsPK.setqSeqNo(lmsTestResponseDetailsDTO.getqSeqNo());
		lmsTestResponseDetailsPK.setTestRollNumber(lmsTestResponseDetailsDTO.getTestRollNumber());
		
		if (lmsTestResponseDetailsRepo.existsById(lmsTestResponseDetailsPK)) {
			lmsTestResponseDetailsDTO = getTestResponseDetailsDTO(
					lmsTestResponseDetailsRepo.save(this.setTestResponseDetails(lmsTestResponseDetailsDTO)));
		}
		return;
	}

	public void delTestResponseDetails(LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO) {
		LMSTestResponseDetailsPK lmsTestResponseDetailsPK = new LMSTestResponseDetailsPK();
		lmsTestResponseDetailsPK.setPaperSeqNo(lmsTestResponseDetailsDTO.getPaperSeqNo());
		lmsTestResponseDetailsPK.setqSeqNo(lmsTestResponseDetailsDTO.getqSeqNo());
		lmsTestResponseDetailsPK.setTestRollNumber(lmsTestResponseDetailsDTO.getTestRollNumber());

		if (lmsTestResponseDetailsRepo.existsById(lmsTestResponseDetailsPK)) {
			lmsTestResponseDetailsRepo.deleteById(lmsTestResponseDetailsPK);
		}
		return;
	}

	public void delSelectResponseDetailsForStudents(ArrayList<Long> ids)
	{
		lmsTestResponseDetailsRepo.delSelectResponseDetailsForStudents(ids);
	}

	public void delSelectResponsePapersDetails(ArrayList<Long> ids)
	{
		lmsTestResponseDetailsRepo.delSelectResponsePapersDetails(ids);
	}

	public void delAllTestResponseDetails() {
		lmsTestResponseDetailsRepo.deleteAll();
	}

	private ArrayList<LMSTestResponseDetailsDTO> getTestResponseDetailsDTOs(
			ArrayList<LMSTestResponseDetails> lms_TestResponseDetailss) {
		LMSTestResponseDetailsDTO courseTestResponseDetailsDTO = null;
		ArrayList<LMSTestResponseDetailsDTO> courseTestResponseDetailsDTOs = new ArrayList<LMSTestResponseDetailsDTO>();

		for (int i = 0; i < lms_TestResponseDetailss.size(); i++) {
			courseTestResponseDetailsDTO = getTestResponseDetailsDTO(lms_TestResponseDetailss.get(i));
			courseTestResponseDetailsDTOs.add(courseTestResponseDetailsDTO);
		}
		return courseTestResponseDetailsDTOs;
	}

	private LMSTestResponseDetailsDTO getTestResponseDetailsDTO(LMSTestResponseDetails lMaster) {
		LMSTestResponseDetailsDTO lDTO = new LMSTestResponseDetailsDTO();
		lDTO.setTestRollNumber(lMaster.getId().getTestRollNumber());
		lDTO.setqSeqNo(lMaster.getId().getqSeqNo());		
		lDTO.setBlankTxt1(lMaster.getBlankTxt1());		
		lDTO.setBlankTxt2(lMaster.getBlankTxt2());
		lDTO.setBlankTxt3(lMaster.getBlankTxt3());
		lDTO.setBlankTxt4(lMaster.getBlankTxt4());
		lDTO.setBlankTxt5(lMaster.getBlankTxt5());
		lDTO.setBlankTxt6(lMaster.getBlankTxt6());
		lDTO.setBlankTxt7(lMaster.getBlankTxt7());
		lDTO.setChoiceFlg1(lMaster.getChoiceFlg1());
		lDTO.setChoiceFlg2(lMaster.getChoiceFlg2());
		lDTO.setChoiceFlg3(lMaster.getChoiceFlg3());
		lDTO.setChoiceFlg4(lMaster.getChoiceFlg4());
		lDTO.setChoiceFlg5(lMaster.getChoiceFlg5());
		lDTO.setChoiceFlg6(lMaster.getChoiceFlg6());
		lDTO.setChoiceFlg7(lMaster.getChoiceFlg7());				
		lDTO.setParagraphTxt(lMaster.getParagraphTxt());
		return lDTO;
	}

	private LMSTestResponseDetails setTestResponseDetails(LMSTestResponseDetailsDTO sDTO) {
		LMSTestResponseDetails lMaster = new LMSTestResponseDetails();
		lMaster.setBlankTxt1(sDTO.getBlankTxt1());		
		lMaster.setBlankTxt2(sDTO.getBlankTxt2());
		lMaster.setBlankTxt3(sDTO.getBlankTxt3());		
		lMaster.setBlankTxt4(sDTO.getBlankTxt4());		
		lMaster.setBlankTxt5(sDTO.getBlankTxt5());		
		lMaster.setBlankTxt6(sDTO.getBlankTxt6());		
		lMaster.setBlankTxt7(sDTO.getBlankTxt7());		
		lMaster.setChoiceFlg1(sDTO.getChoiceFlg1());
		lMaster.setChoiceFlg2(sDTO.getChoiceFlg2());
		lMaster.setChoiceFlg3(sDTO.getChoiceFlg3());
		lMaster.setChoiceFlg4(sDTO.getChoiceFlg4());
		lMaster.setChoiceFlg5(sDTO.getChoiceFlg5());
		lMaster.setChoiceFlg6(sDTO.getChoiceFlg6());
		lMaster.setChoiceFlg7(sDTO.getChoiceFlg7());				
		lMaster.setParagraphTxt(sDTO.getParagraphTxt());
	return lMaster;
	}

}
