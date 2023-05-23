package test_enrollment.enroll_master.services;

import java.util.ArrayList;
import test_enrollment.enroll_master.model.dto.LMSTestEnrollMasterDTO;

public interface I_LMSTestEnrollMasterService 
{
	abstract public LMSTestEnrollMasterDTO newLMSTestEnrollMaster(LMSTestEnrollMasterDTO testDTO);
	abstract public ArrayList<LMSTestEnrollMasterDTO> getAllTestEnrollMaster();
	abstract public ArrayList<LMSTestEnrollMasterDTO> getSelectTestEnrollMasters(ArrayList<Long> enrollSeqNos);
	abstract public ArrayList<LMSTestEnrollMasterDTO> getSelectEnrollsForTests(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestEnrollMasterDTO> getSelectEnrollsForInstitutes(ArrayList<Long> ids);
	abstract public void updLMSTestEnrollMaster(LMSTestEnrollMasterDTO LMSTestEnrollMasterDTO);	
	abstract public void delAllLMSTestEnrollMaster();
	abstract public void delSelectTestEnrolls(ArrayList<Long> enrollSeqNos);
	abstract public void delSelectEnrollsForInstitutes(ArrayList<Long> ids);
	abstract public void delSelectTestEnrollxForTests(ArrayList<Long> ids);
}