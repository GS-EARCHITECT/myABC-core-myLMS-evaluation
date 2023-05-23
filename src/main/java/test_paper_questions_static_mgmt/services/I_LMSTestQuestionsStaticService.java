package test_paper_questions_static_mgmt.services;

import java.util.ArrayList;
import org.springframework.data.repository.query.Param;

import test_paper_questions_static_mgmt.model.dto.LMSTestQuestionsStaticDTO;

public interface I_LMSTestQuestionsStaticService 
{
	abstract public LMSTestQuestionsStaticDTO newPaperQuestion(LMSTestQuestionsStaticDTO qDTO);
	abstract public LMSTestQuestionsStaticDTO getPaperQuestionbyId(LMSTestQuestionsStaticDTO qDTO);
	abstract public ArrayList<LMSTestQuestionsStaticDTO> getAllPapersQuestions();
	abstract public Float getQuestionMarksForPaper(Long pSeqNo, Long qSeqNo);
	abstract public ArrayList<LMSTestQuestionsStaticDTO> getSelectQuestionsForPapers(ArrayList<Long> ids);
	abstract public ArrayList<LMSTestQuestionsStaticDTO> getQuestionForPapersBetweenMarks(ArrayList<Long> pNos, Float fr, @Param("to") Float to);
	abstract public void updPaperQuestion(LMSTestQuestionsStaticDTO qDTO);
	abstract public void delPaperQuestion(LMSTestQuestionsStaticDTO qDTO);
	abstract public void delAllPaperQuestions();	
	abstract public void delSelectQuestionsForPapers(ArrayList<Long> ids);
	abstract public	void delQuestionForPapersBetweenMarks(ArrayList<Long> pNos, Float fr, Float to);
}