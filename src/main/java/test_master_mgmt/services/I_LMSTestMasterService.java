package test_master_mgmt.services;

import java.util.ArrayList;

import test_master_mgmt.model.dto.LMSTestMasterDTO;

public interface I_LMSTestMasterService 
{
	abstract public LMSTestMasterDTO newLMSTestMaster(LMSTestMasterDTO testDTO);
	abstract public ArrayList<LMSTestMasterDTO> getAllTests();
	abstract public ArrayList<LMSTestMasterDTO> getSelectTestsForInst(ArrayList<Long> ids, ArrayList<Long> iSeqNo);
	abstract public ArrayList<LMSTestMasterDTO> getSelectTests(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestMasterDTO> getSelectTestsBetweenTimesForInst(String frDtTm, String toDtTm, ArrayList<Long> iSeqNo);
	abstract public ArrayList<LMSTestMasterDTO> getSelectTestsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	abstract public void updLMSTestMaster(LMSTestMasterDTO LMSTestMasterDTO);	
	abstract public void delAllLMSTestMasters();
	abstract public void delSelectTests(ArrayList<Long> ids);
	abstract public void delSelectTestsForInst(ArrayList<Long> ids, ArrayList<Long> iSeqNo);
	abstract public void delSelectTestsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	abstract public void delSelectTestsBetweenTimesForInst(String frDtTm, String toDtTm, ArrayList<Long> iSeqNo);	
}