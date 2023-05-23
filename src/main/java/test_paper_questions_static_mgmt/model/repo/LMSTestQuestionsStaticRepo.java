package test_paper_questions_static_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_paper_questions_static_mgmt.model.details.LMSTestQuestionsStatic;
import test_paper_questions_static_mgmt.model.details.LMSTestQuestionsStaticPK;

@Repository("lmsTestQuestionsStaticRepo")
public interface LMSTestQuestionsStaticRepo extends CrudRepository<LMSTestQuestionsStatic, LMSTestQuestionsStaticPK> 
{

	@Query(value = "select * FROM LMS_TEST_Questions_Static where paper_SEQ_NO in :ids order by paper_seq_no", nativeQuery = true)
	ArrayList<LMSTestQuestionsStatic> getSelectQuestionsForPapers(@Param("id") ArrayList<Long> ids);

	@Query(value = "select coalesce(marks,0) FROM LMS_TEST_Questions_Static where a.paper_SEQ_NO = :pSeqNo and q_SEQ_NO = :qSeqNo", nativeQuery = true)
	Float getQuestionMarksForPaper(@Param("pSeqNo") Long pSeqNo, @Param("qSeqNo") Long qSeqNo);
	
	@Query(value = "select * FROM LMS_TEST_Questions_Static  where  ((paper_SEQ_NO in :pNos) and (marks >= :fr and marks <= :to)) order by paper_seq_no", nativeQuery = true)
	ArrayList<LMSTestQuestionsStatic> getQuestionsForPapersBetweenMarks(@Param("pNo") ArrayList<Long> pNos, @Param("fr") Float fr, @Param("to") Float to);
	
	@Query(value = "DELETE FROM LMS_TEST_Questions_Static WHERE paper_SEQ_NO in :ids", nativeQuery = true)
	void delSelectQuestionsForPapers(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_Questions_Static where  ((paper_SEQ_NO in :pNos) and (marks >= :fr and marks <= :to))", nativeQuery = true)
	void delQuestionForPapersBetweenMarks(@Param("pNo") ArrayList<Long> pNos, @Param("fr") Float fr, @Param("to") Float to);
	
}
