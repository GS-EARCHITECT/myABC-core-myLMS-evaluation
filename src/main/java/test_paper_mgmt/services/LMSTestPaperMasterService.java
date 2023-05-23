package test_paper_mgmt.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import test_paper_mgmt.model.dto.LMSTestPaperMasterDTO;
import test_paper_mgmt.model.master.LMSTestPaperMaster;
import test_paper_mgmt.model.repo.LMSTestPaperMasterRepo;

@Service("lmsTestPaperMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSTestPaperMasterService implements I_LMSTestPaperMasterService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestPaperMaster_Controller.class);

	@Autowired
	private LMSTestPaperMasterRepo lmsTestPaperMasterRepo;

	@Override
	public ArrayList<LMSTestPaperMasterDTO> getAllTestPapers() {
		ArrayList<LMSTestPaperMasterDTO> courseMasterDTOs = new ArrayList<LMSTestPaperMasterDTO>();
		ArrayList<LMSTestPaperMaster> courseMasterOpts = (ArrayList<LMSTestPaperMaster>) lmsTestPaperMasterRepo
				.findAll();

		if (courseMasterOpts != null) {
			courseMasterDTOs = getTestPaperMasterDtos(courseMasterOpts);
		} else {
			courseMasterDTOs = null;
		}

		return courseMasterDTOs;
	}

	@Override
	public ArrayList<LMSTestPaperMasterDTO> getSelectTestsPapers(ArrayList<Long> ids) {
		ArrayList<LMSTestPaperMaster> lMasters = lmsTestPaperMasterRepo.getSelectTestsPapers(ids);
		ArrayList<LMSTestPaperMasterDTO> LMSTestPaperMasterDTOs = null;

		if (lMasters != null) {
			LMSTestPaperMasterDTOs = getTestPaperMasterDtos(lMasters);
		}

		return LMSTestPaperMasterDTOs;
	}

	@Override
	public ArrayList<LMSTestPaperMasterDTO> getSelectTestsPapersBySubjects(ArrayList<Long> ids) {
		ArrayList<LMSTestPaperMaster> lMasters = lmsTestPaperMasterRepo.getSelectTestsPapersBySubjects(ids);
		ArrayList<LMSTestPaperMasterDTO> LMSTestPaperMasterDTOs = null;

		if (lMasters != null) {
			LMSTestPaperMasterDTOs = getTestPaperMasterDtos(lMasters);
		}

		return LMSTestPaperMasterDTOs;
	}

	public LMSTestPaperMasterDTO newLMSTestPaperMaster(LMSTestPaperMasterDTO lms_TestPaperMasterDTO) {
		LMSTestPaperMaster lms_TestPaperMaster = lmsTestPaperMasterRepo.save(setCustomerMaster(lms_TestPaperMasterDTO));
		LMSTestPaperMasterDTO courseMasterDTO2 = getTestPaperMasterDto(lms_TestPaperMaster);
		return courseMasterDTO2;
	}

	public void updLMSTestPaperMaster(LMSTestPaperMasterDTO lMSTestPaperMasterDTO) {
		LMSTestPaperMaster lms_TestPaperMaster = setCustomerMaster(lMSTestPaperMasterDTO);
		lmsTestPaperMasterRepo.save(lms_TestPaperMaster);
	}

	public void delSelectTestsPapers(ArrayList<Long> ids) {
		lmsTestPaperMasterRepo.delSelectTestsPapers(ids);
	}

	public void delSelectTestPapersBySubjects(ArrayList<Long> ids) {
		lmsTestPaperMasterRepo.delSelectTestPapersPapersBySubjects(ids);
	}

	public void delAllLMSTestPaperMasters() {
		lmsTestPaperMasterRepo.deleteAll();
	}

	private ArrayList<LMSTestPaperMasterDTO> getTestPaperMasterDtos(
			ArrayList<LMSTestPaperMaster> lms_TestPaperMasters) {
		LMSTestPaperMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestPaperMasterDTO> courseMasterDTOs = new ArrayList<LMSTestPaperMasterDTO>();

		for (int i = 0; i < lms_TestPaperMasters.size(); i++) {
			courseMasterDTO = getTestPaperMasterDto(lms_TestPaperMasters.get(i));
			courseMasterDTOs.add(courseMasterDTO);
		}
		return courseMasterDTOs;
	}

	private LMSTestPaperMasterDTO getTestPaperMasterDto(LMSTestPaperMaster testMaster) {
		LMSTestPaperMasterDTO lDTO = new LMSTestPaperMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");				
		lDTO.setFrDtTm(formatter.format(testMaster.getFrDtTm().toLocalDateTime()));
		lDTO.setToDtTm(formatter.format(testMaster.getToDtTm().toLocalDateTime()));
		lDTO.setPaperSeqNo(testMaster.getPaperSeqNo());
		lDTO.setPaperId(testMaster.getPaperId());
		lDTO.setPaperTitle(testMaster.getPaperTitle());
		lDTO.setSubjectSeqNo(testMaster.getSubjectSeqNo());
		lDTO.setEvaluatorId(testMaster.getEvaluatorId());
		lDTO.setEvaluatorSeqNo(testMaster.getEvaluatorSeqNo());
		lDTO.setMarks(testMaster.getMarks());
		lDTO.setWeightage(testMaster.getWeightage());
		return lDTO;
	}

	private LMSTestPaperMaster setCustomerMaster(LMSTestPaperMasterDTO sMasterDTO) {
		LMSTestPaperMaster lms_TestPaperMaster = new LMSTestPaperMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(sMasterDTO.getFrDtTm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(sMasterDTO.getToDtTm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lms_TestPaperMaster.setFrDtTm(ts_Fr);
		lms_TestPaperMaster.setToDtTm(ts_To);
		lms_TestPaperMaster.setPaperId(sMasterDTO.getPaperId());
		lms_TestPaperMaster.setPaperTitle(sMasterDTO.getPaperTitle());
		lms_TestPaperMaster.setSubjectSeqNo(sMasterDTO.getSubjectSeqNo());
		lms_TestPaperMaster.setEvaluatorId(sMasterDTO.getEvaluatorId());
		lms_TestPaperMaster.setEvaluatorSeqNo(sMasterDTO.getEvaluatorSeqNo());
		lms_TestPaperMaster.setMarks(sMasterDTO.getMarks());
		lms_TestPaperMaster.setWeightage(sMasterDTO.getWeightage());
		return lms_TestPaperMaster;
	}

}
