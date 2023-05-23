package test_paper_mgmt.services;

import java.util.ArrayList;

import test_paper_mgmt.model.dto.LMSTestPaperMasterDTO;

public interface I_LMSTestPaperMasterService 
{
	abstract public LMSTestPaperMasterDTO newLMSTestPaperMaster(LMSTestPaperMasterDTO testDTO);
	abstract public ArrayList<LMSTestPaperMasterDTO> getAllTestPapers();
	abstract public ArrayList<LMSTestPaperMasterDTO> getSelectTestsPapers(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestPaperMasterDTO> getSelectTestsPapersBySubjects(ArrayList<Long> ids);
	abstract public void updLMSTestPaperMaster(LMSTestPaperMasterDTO LMSTestPaperMasterDTO);	
	abstract public void delAllLMSTestPaperMasters();	
	abstract public void delSelectTestsPapers(ArrayList<Long> ids);
	abstract public void delSelectTestPapersBySubjects(ArrayList<Long> ids);
	
}