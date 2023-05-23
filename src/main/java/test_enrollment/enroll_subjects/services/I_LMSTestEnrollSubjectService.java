package test_enrollment.enroll_subjects.services;

import java.util.ArrayList;
import test_enrollment.enroll_subjects.model.dto.LMSTestEnrollSubjectDTO;

public interface I_LMSTestEnrollSubjectService 
{
	abstract public LMSTestEnrollSubjectDTO newLMSTestEnrollSubject(LMSTestEnrollSubjectDTO testDTO);
	abstract public ArrayList<LMSTestEnrollSubjectDTO> getAllTestEnrollSubjects();
	abstract public ArrayList<LMSTestEnrollSubjectDTO> getSelectTestSubjectsByEnrolls(ArrayList<Long> enrollSeqNos);
	abstract public ArrayList<LMSTestEnrollSubjectDTO> getSelectEnrollsForSubjects(ArrayList<Long> ids);	
	abstract public void updLMSTestEnrollSubject(LMSTestEnrollSubjectDTO LMSTestEnrollSubjectDTO);	
	abstract public void delAllLMSTestEnrollSubject();
	abstract public void delSelectTestSubjectsByEnrolls(ArrayList<Long> enrollSeqNos);
	abstract public void delSelectEnrollsForSubjects(ArrayList<Long> ids);	
}