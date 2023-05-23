package test_paper_questions_static_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test_paper_questions_static_mgmt.model.details.LMSTestQuestionsStatic;
import test_paper_questions_static_mgmt.model.details.LMSTestQuestionsStaticPK;
import test_paper_questions_static_mgmt.model.dto.LMSTestQuestionsStaticDTO;
import test_paper_questions_static_mgmt.model.repo.LMSTestQuestionsStaticRepo;

@Service("lmsTestQuestionsStaticServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSTestQuestionsStaticService implements I_LMSTestQuestionsStaticService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestQuestionsStatic_Controller.class);

	@Autowired
	private LMSTestQuestionsStaticRepo lmsTestQuestionsStaticRepo;

	@Override
	public ArrayList<LMSTestQuestionsStaticDTO> getAllPapersQuestions() {
		ArrayList<LMSTestQuestionsStaticDTO> courseMasterDTOs = new ArrayList<LMSTestQuestionsStaticDTO>();
		ArrayList<LMSTestQuestionsStatic> courseMasterOpts = (ArrayList<LMSTestQuestionsStatic>) lmsTestQuestionsStaticRepo
				.findAll();

		if (courseMasterOpts != null) {
			courseMasterDTOs = getTestQuestionsStaticDtos(courseMasterOpts);
		} else {
			courseMasterDTOs = null;
		}

		return courseMasterDTOs;
	}

	@Override
	public ArrayList<LMSTestQuestionsStaticDTO> getSelectQuestionsForPapers(ArrayList<Long> ids) {
		ArrayList<LMSTestQuestionsStatic> lMasters = lmsTestQuestionsStaticRepo.getSelectQuestionsForPapers(ids);
		ArrayList<LMSTestQuestionsStaticDTO> LMSTestQuestionsStaticDTOs = new ArrayList<LMSTestQuestionsStaticDTO>();

		if (lMasters != null) {
			LMSTestQuestionsStaticDTOs = getTestQuestionsStaticDtos(lMasters);
		}

		return LMSTestQuestionsStaticDTOs;
	}

	@Override
	public Float getQuestionMarksForPaper(Long pSeqNo, Long qSeqNo)
	{
		Float marks = lmsTestQuestionsStaticRepo.getQuestionMarksForPaper(pSeqNo, qSeqNo);		
		return marks;
	}
	
	@Override
	public ArrayList<LMSTestQuestionsStaticDTO> getQuestionForPapersBetweenMarks(ArrayList<Long> pNos, Float fr, Float to) 
	{
		ArrayList<LMSTestQuestionsStatic> lMasters = lmsTestQuestionsStaticRepo.getQuestionsForPapersBetweenMarks(pNos,	fr, to);
		
		ArrayList<LMSTestQuestionsStaticDTO> LMSTestQuestionsStaticDTOs = new ArrayList<LMSTestQuestionsStaticDTO>();

		if (lMasters != null) {
			LMSTestQuestionsStaticDTOs = getTestQuestionsStaticDtos(lMasters);
		}

		return LMSTestQuestionsStaticDTOs;
	}

	@Override
	public LMSTestQuestionsStaticDTO getPaperQuestionbyId(LMSTestQuestionsStaticDTO qDTO) {
		LMSTestQuestionsStaticPK lmsTestQuestionsStaticPK = new LMSTestQuestionsStaticPK();
		lmsTestQuestionsStaticPK.setPaperSeqNo(qDTO.getPaperSeqNo());
		lmsTestQuestionsStaticPK.setQSeqNo(qDTO.getqSeqNo());
		LMSTestQuestionsStatic lmsTestQuestionsStatic = null;

		if (!lmsTestQuestionsStaticRepo.existsById(lmsTestQuestionsStaticPK)) {
			lmsTestQuestionsStatic = this.setCustomerMaster(qDTO);
			lmsTestQuestionsStatic.setId(lmsTestQuestionsStaticPK);
			qDTO = this.getTestQuestionsStaticDto(lmsTestQuestionsStaticRepo.save(lmsTestQuestionsStatic));
		}
		return qDTO;
	}

	public LMSTestQuestionsStaticDTO newPaperQuestion(LMSTestQuestionsStaticDTO qDTO) {
		LMSTestQuestionsStaticPK lmsTestQuestionsStaticPK = new LMSTestQuestionsStaticPK();
		lmsTestQuestionsStaticPK.setPaperSeqNo(qDTO.getPaperSeqNo());
		lmsTestQuestionsStaticPK.setQSeqNo(qDTO.getqSeqNo());
		LMSTestQuestionsStatic lmsTestQuestionsStatic = null;

		if (!lmsTestQuestionsStaticRepo.existsById(lmsTestQuestionsStaticPK)) {
			lmsTestQuestionsStatic = this.setCustomerMaster(qDTO);
			lmsTestQuestionsStatic.setId(lmsTestQuestionsStaticPK);
			qDTO = this.getTestQuestionsStaticDto(lmsTestQuestionsStaticRepo.save(lmsTestQuestionsStatic));
		}
		return qDTO;
	}

	public void updPaperQuestion(LMSTestQuestionsStaticDTO qDTO) {
		LMSTestQuestionsStaticPK lmsTestQuestionsStaticPK = new LMSTestQuestionsStaticPK();
		lmsTestQuestionsStaticPK.setPaperSeqNo(qDTO.getPaperSeqNo());
		lmsTestQuestionsStaticPK.setQSeqNo(qDTO.getqSeqNo());
		LMSTestQuestionsStatic lmsTestQuestionsStatic = null;

		if (lmsTestQuestionsStaticRepo.existsById(lmsTestQuestionsStaticPK)) {
			lmsTestQuestionsStatic = this.setCustomerMaster(qDTO);
			lmsTestQuestionsStatic.setId(lmsTestQuestionsStaticPK);
			qDTO = this.getTestQuestionsStaticDto(lmsTestQuestionsStaticRepo.save(lmsTestQuestionsStatic));
		}
		return;

	}

	public void delPaperQuestion(LMSTestQuestionsStaticDTO qDTO) {
		LMSTestQuestionsStaticPK lmsTestQuestionsStaticPK = new LMSTestQuestionsStaticPK();
		lmsTestQuestionsStaticPK.setPaperSeqNo(qDTO.getPaperSeqNo());
		lmsTestQuestionsStaticPK.setQSeqNo(qDTO.getqSeqNo());
		LMSTestQuestionsStatic lmsTestQuestionsStatic = null;

		if (lmsTestQuestionsStaticRepo.existsById(lmsTestQuestionsStaticPK)) {
			lmsTestQuestionsStaticRepo.deleteById(lmsTestQuestionsStaticPK);
		}
		return;

	}

	public void delSelectQuestionsForPapers(ArrayList<Long> ids) {
		lmsTestQuestionsStaticRepo.delSelectQuestionsForPapers(ids);
	}

	public void delQuestionForPapersBetweenMarks(ArrayList<Long> pNos, Float fr, Float to) {
		lmsTestQuestionsStaticRepo.delQuestionForPapersBetweenMarks(pNos, fr, to);
	}

	public void delAllPaperQuestions() {
		lmsTestQuestionsStaticRepo.deleteAll();
	}

	private ArrayList<LMSTestQuestionsStaticDTO> getTestQuestionsStaticDtos(
			ArrayList<LMSTestQuestionsStatic> lms_TestQuestionsStatics) {
		LMSTestQuestionsStaticDTO courseMasterDTO = null;
		ArrayList<LMSTestQuestionsStaticDTO> courseMasterDTOs = new ArrayList<LMSTestQuestionsStaticDTO>();

		for (int i = 0; i < lms_TestQuestionsStatics.size(); i++) {
			courseMasterDTO = getTestQuestionsStaticDto(lms_TestQuestionsStatics.get(i));
			courseMasterDTOs.add(courseMasterDTO);
		}
		return courseMasterDTOs;
	}

	private LMSTestQuestionsStaticDTO getTestQuestionsStaticDto(LMSTestQuestionsStatic qMaster) {
		LMSTestQuestionsStaticDTO lDTO = new LMSTestQuestionsStaticDTO();
		lDTO.setMarks(qMaster.getMarks());
		lDTO.setPaperSeqNo(qMaster.getId().getPaperSeqNo());
		lDTO.setqSeqNo(qMaster.getId().getQSeqNo());
		lDTO.setQuestionNo(qMaster.getQuestionNo());
		lDTO.setWeightage(qMaster.getWeightage());		
		return lDTO;
	}

	private LMSTestQuestionsStatic setCustomerMaster(LMSTestQuestionsStaticDTO sMasterDTO) {
		LMSTestQuestionsStatic lms_PaperQuestionsStatic = new LMSTestQuestionsStatic();
		LMSTestQuestionsStaticPK lmsTestQuestionsStaticPK = new LMSTestQuestionsStaticPK();
		lmsTestQuestionsStaticPK.setPaperSeqNo(sMasterDTO.getPaperSeqNo());
		lmsTestQuestionsStaticPK.setQSeqNo(sMasterDTO.getqSeqNo());
		lms_PaperQuestionsStatic.setId(lmsTestQuestionsStaticPK);
		lms_PaperQuestionsStatic.setMarks(sMasterDTO.getMarks());
		lms_PaperQuestionsStatic.setQuestionNo(sMasterDTO.getQuestionNo());
		lms_PaperQuestionsStatic.setWeightage(sMasterDTO.getWeightage());		
		return lms_PaperQuestionsStatic;
	}

}
