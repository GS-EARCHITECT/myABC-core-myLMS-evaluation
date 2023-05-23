package test_subject_mgmt.services;

import java.util.ArrayList;

import test_subject_mgmt.model.dto.LMSTestSubjectMasterDTO;

public interface I_LMSTestSubjectMasterService 
{
	abstract public LMSTestSubjectMasterDTO newLMSTestSubjectMaster(LMSTestSubjectMasterDTO testDTO);
	abstract public ArrayList<LMSTestSubjectMasterDTO> getAllTestSubjects();	
	abstract public ArrayList<Long> getSelectTestSubjects(Long id);
	abstract public ArrayList<LMSTestSubjectMasterDTO> getSelectTestsSubjects(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestSubjectMasterDTO> getSelectTestsSubjectsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	abstract public void updLMSTestSubjectMaster(LMSTestSubjectMasterDTO LMSTestSubjectMasterDTO);	
	abstract public void delAllLMSTestSubjectMasters();	
	abstract public void delSelectTestSubjects(ArrayList<Long> ids);
	abstract public void delSelectTestSubjectsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm);
	
}