package test_answers_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_answers_mgmt.model.master.LMSTestResponseDetails;
import test_answers_mgmt.model.master.LMSTestResponseDetailsPK;

@Repository("lmsTestResponseRepo")
public interface LMSTestResponseDetailsRepo extends CrudRepository<LMSTestResponseDetails, LMSTestResponseDetailsPK> 
{
	@Query(value = "SELECT * FROM LMS_TEST_RESPONSE_DETAILS a WHERE a.test_roll_number in :ids order by test_roll_number", nativeQuery = true)
	ArrayList<LMSTestResponseDetails> getSelectResponseDetailsForStudents(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_TEST_RESPONSE_DETAILS a WHERE a.paper_seq_no in :ids order by paper_seq_no, test_roll_number", nativeQuery = true)
	ArrayList<LMSTestResponseDetails> getSelectResponsePapersDetails(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "update LMS_TEST_RESPONSE_DETAILS set marks = :marks WHERE a.test_roll_number = :rollno and a.paper_seq_no = :pSeqNo and a.q_seq_no = :qSeqNo", nativeQuery = true)
	void updateResponseMarks(@Param("rollno") Long rollno, @Param("pSeqNo") Long pSeqNo, @Param("qSeqNo") Long qSeqNo, @Param("marks") Float marks);
	
	@Query(value = "DELETE FROM LMS_TEST_RESPONSE_DETAILS WHERE a.test_roll_number in :ids", nativeQuery = true)
	void delSelectResponseDetailsForStudents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_RESPONSE_DETAILS a WHERE a.paper_seq_no in :ids", nativeQuery = true)
	void delSelectResponsePapersDetails(@Param("ids") ArrayList<Long> ids);
	
}
