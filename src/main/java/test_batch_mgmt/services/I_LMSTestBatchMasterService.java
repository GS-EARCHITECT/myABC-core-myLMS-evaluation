package test_batch_mgmt.services;

import java.util.ArrayList;
import test_batch_mgmt.model.dto.LMSTestBatchMasterDTO;

public interface I_LMSTestBatchMasterService {
	abstract public LMSTestBatchMasterDTO newLMSTestBatchMaster(LMSTestBatchMasterDTO testDTO);

	abstract public ArrayList<LMSTestBatchMasterDTO> getAllTestEnrolls();

	abstract public ArrayList<LMSTestBatchMasterDTO> getSelectStudentsForEnrolls(ArrayList<Long> ids);

	abstract public ArrayList<LMSTestBatchMasterDTO> getSelectStudents(ArrayList<Long> ids);

	abstract public void updLMSTestBatchMaster(LMSTestBatchMasterDTO LMSTestBatchMasterDTO);

	abstract public void delAllLMSTestBatchMasters();

	abstract public void delSelectStudentsForEnrolls(ArrayList<Long> ids);

	abstract public void delSelectStudents(ArrayList<Long> ids);

}