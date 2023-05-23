package test_enrollment.enroll_subjects.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_enrollment.enroll_subjects.model.details.LMSTestEnrollSubject;
import test_enrollment.enroll_subjects.model.details.LMSTestEnrollSubjectPK;

@Repository("lmsTestEnrollSubjectRepo")
public interface LMSTestEnrollSubjectRepo extends CrudRepository<LMSTestEnrollSubject, LMSTestEnrollSubjectPK> 
{

	@Query(value = "select * FROM LMS_TEST_ENROLL_SUBJECTS b where a.enroll_SEQ_NO in :enrollSeqNos order by enroll_seq_no", nativeQuery = true)
	ArrayList<LMSTestEnrollSubject> getSelectTestSubjectsByEnrolls(@Param("enrollSeqNos") ArrayList<Long> enrollSeqNos);

	@Query(value = "SELECT * FROM LMS_TEST_ENROLL_SUBJECTS a WHERE a.TARGET_SUBJECT_SEQ_NO in :ids order by enroll_seq_no", nativeQuery = true)
	ArrayList<LMSTestEnrollSubject> getSelectEnrollsForSubjects(@Param("id") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_TEST_ENROLL_SUBJECTS WHERE where a.enroll_SEQ_NO in :enrollSeqNos", nativeQuery = true)
	void delSelectTestSubjectsByEnrolls(@Param("enrollSeqNos") ArrayList<Long> enrollSeqNos);

	@Query(value = "DELETE FROM LMS_TEST_ENROLL_SUBJECTS WHERE a.TARGET_SUBJECT_SEQ_NO in :ids", nativeQuery = true)
	void delSelectEnrollsForSubjects(@Param("id") ArrayList<Long> ids);
}
