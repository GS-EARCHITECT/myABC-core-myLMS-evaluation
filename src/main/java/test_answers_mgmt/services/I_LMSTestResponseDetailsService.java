package test_answers_mgmt.services;

import java.util.ArrayList;
import test_answers_mgmt.model.dto.LMSActualExpectedQuestionResponseDTO;
import test_answers_mgmt.model.dto.LMSTestResponseDetailsDTO;

public interface I_LMSTestResponseDetailsService 
{
	abstract public LMSTestResponseDetailsDTO newTestResponseDetails(LMSTestResponseDetailsDTO testResponseDTO);
	abstract public ArrayList<LMSTestResponseDetailsDTO> getAllTestResponseDetails();
	abstract public ArrayList<Long> getSubjectiveQuestionsList(Long pSeqNo);
	abstract public ArrayList<Long> getObjectiveQuestionsList(Long pSeqNo);
	abstract public LMSActualExpectedQuestionResponseDTO getActualExpectedQuestionResponse(Long pSeqNo, Long qSeqNo, Long rollNo);
	abstract public LMSTestResponseDetailsDTO getTestResponseDetails(Long pSeqNo, Long qSeqNo, Long sSeqNo);
	abstract public ArrayList<LMSTestResponseDetailsDTO> getSelectTestResponseDetailsForStudents(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestResponseDetailsDTO> getSelectResponsePapersDetails(ArrayList<Long> ids);
	abstract public void updTestResponseDetails(LMSTestResponseDetailsDTO LMSTestResponseDetailsDTO);
	abstract public void updateResponseMarks(Long rollno, Long pSeqNo, Long qSeqNo, Float marks);
	abstract public void delTestResponseDetails(LMSTestResponseDetailsDTO testResponseDTO);
	abstract public void delSelectResponseDetailsForStudents(ArrayList<Long> ids);
	abstract public void delSelectResponsePapersDetails(ArrayList<Long> ids);
	abstract public void delAllTestResponseDetails();
}