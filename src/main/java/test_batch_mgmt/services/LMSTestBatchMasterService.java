package test_batch_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test_batch_mgmt.model.dto.LMSTestBatchMasterDTO;
import test_batch_mgmt.model.master.LMSTestBatchMaster;
import test_batch_mgmt.model.repo.LMSTestBatchMasterRepo;

@Service("lmsTestBatchMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSTestBatchMasterService implements I_LMSTestBatchMasterService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSTestBatchMaster_Controller.class);

	@Autowired
	private LMSTestBatchMasterRepo lmsTestBatchMasterRepo;

	@Override
	public ArrayList<LMSTestBatchMasterDTO> getAllTestEnrolls() {
		ArrayList<LMSTestBatchMasterDTO> courseMasterDTOs = new ArrayList<LMSTestBatchMasterDTO>();
		ArrayList<LMSTestBatchMaster> courseMasterOpts = (ArrayList<LMSTestBatchMaster>) lmsTestBatchMasterRepo
				.findAll();

		if (courseMasterOpts != null) {
			courseMasterDTOs = getTestBatchMasterDtos(courseMasterOpts);
		} else {
			courseMasterDTOs = null;
		}

		return courseMasterDTOs;
	}

	@Override
	public ArrayList<LMSTestBatchMasterDTO> getSelectStudentsForEnrolls(ArrayList<Long> ids) {
		ArrayList<LMSTestBatchMaster> lMasters = lmsTestBatchMasterRepo.getSelectStudentsForEnrolls(ids);
		ArrayList<LMSTestBatchMasterDTO> LMSTestBatchMasterDTOs = new ArrayList<LMSTestBatchMasterDTO>();

		if (lMasters != null) {
			LMSTestBatchMasterDTOs = getTestBatchMasterDtos(lMasters);
		}

		return LMSTestBatchMasterDTOs;
	}

	@Override
	public ArrayList<LMSTestBatchMasterDTO> getSelectStudents(ArrayList<Long> ids) {
		ArrayList<LMSTestBatchMaster> lMasters = lmsTestBatchMasterRepo.getSelectStudents(ids);
		ArrayList<LMSTestBatchMasterDTO> LMSTestBatchMasterDTOs = new ArrayList<LMSTestBatchMasterDTO>();

		if (lMasters != null) {
			LMSTestBatchMasterDTOs = getTestBatchMasterDtos(lMasters);
		}

		return LMSTestBatchMasterDTOs;
	}

	public LMSTestBatchMasterDTO newLMSTestBatchMaster(LMSTestBatchMasterDTO lms_TestBatchMasterDTO) {

		LMSTestBatchMaster lms_TestBatchMaster = null;

		if (!lmsTestBatchMasterRepo.existsById(lms_TestBatchMasterDTO.getTestRollNumber())) {
			lms_TestBatchMasterDTO = this.getTestBatchMasterDto(
					lmsTestBatchMasterRepo.save(this.setTestBatchMaster(lms_TestBatchMasterDTO)));
		}

		return lms_TestBatchMasterDTO;
	}

	public void updLMSTestBatchMaster(LMSTestBatchMasterDTO lMSTestBatchMasterDTO) {
		LMSTestBatchMaster lms_TestBatchMaster = null;

		if (lmsTestBatchMasterRepo.existsById(lMSTestBatchMasterDTO.getTestRollNumber())) 
		{
			lms_TestBatchMaster = this.setTestBatchMaster(lMSTestBatchMasterDTO);
			lms_TestBatchMaster.setTestRollNumber(lMSTestBatchMasterDTO.getTestRollNumber());
			lMSTestBatchMasterDTO = this.getTestBatchMasterDto(lmsTestBatchMasterRepo.save(lms_TestBatchMaster));
		}

	}

	public void delSelectStudentsForEnrolls(ArrayList<Long> ids)
	{
		lmsTestBatchMasterRepo.delSelectStudentsForEnrolls(ids);
	}

	public void delSelectStudents(ArrayList<Long> ids) 
	{
		lmsTestBatchMasterRepo.delSelectStudents(ids);
	}

	public void delAllLMSTestBatchMasters() {
		lmsTestBatchMasterRepo.deleteAll();
	}


	private ArrayList<LMSTestBatchMasterDTO> getTestBatchMasterDtos(
			ArrayList<LMSTestBatchMaster> lms_TestBatchMasters) {
		LMSTestBatchMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestBatchMasterDTO> courseMasterDTOs = new ArrayList<LMSTestBatchMasterDTO>();

		for (int i = 0; i < lms_TestBatchMasters.size(); i++) {
			courseMasterDTO = getTestBatchMasterDto(lms_TestBatchMasters.get(i));
			courseMasterDTOs.add(courseMasterDTO);
		}
		return courseMasterDTOs;
	}

	private LMSTestBatchMasterDTO getTestBatchMasterDto(LMSTestBatchMaster testMaster) {
		LMSTestBatchMasterDTO lDTO = new LMSTestBatchMasterDTO();
		lDTO.setEnollSeqNo(testMaster.getEnollSeqNo());
		lDTO.setSourceStudentSeqNo(testMaster.getSourceStudentSeqNo());
		lDTO.setTestRollNumber(testMaster.getTestRollNumber());
		return lDTO;
	}

	private LMSTestBatchMaster setTestBatchMaster(LMSTestBatchMasterDTO sMasterDTO) {
		LMSTestBatchMaster lms_TestBatchMaster = new LMSTestBatchMaster();
		lms_TestBatchMaster.setEnollSeqNo(sMasterDTO.getEnollSeqNo());
		lms_TestBatchMaster.setSourceStudentSeqNo(sMasterDTO.getSourceStudentSeqNo());
		return lms_TestBatchMaster;
	}

}
