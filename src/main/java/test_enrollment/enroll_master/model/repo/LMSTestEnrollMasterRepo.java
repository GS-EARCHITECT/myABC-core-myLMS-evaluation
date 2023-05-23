package test_enrollment.enroll_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test_enrollment.enroll_master.model.master.LMSTestEnrollMaster;

@Repository("lmsTestEnrollMasterRepo")
public interface LMSTestEnrollMasterRepo extends CrudRepository<LMSTestEnrollMaster, Long> {

	@Query(value = "select * FROM LMS_TEST_ENROLL_MASTER b where a.test_enroll_SEQ_NO in :enrollSeqNos order by enroll_seq_no", nativeQuery = true)
	ArrayList<LMSTestEnrollMaster> getSelectTestEnrollMasters(@Param("enrollSeqNos") ArrayList<Long> enrollSeqNos);

	@Query(value = "SELECT * FROM LMS_TEST_ENROLL_MASTER a WHERE a.test_SEQ_NO in :ids order by enroll_seq_no", nativeQuery = true)
	ArrayList<LMSTestEnrollMaster> getSelectEnrollsForTests(@Param("id") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_TEST_ENROLL_MASTER a WHERE a.INSTITUTION_SEQ_NO in :ids order by enroll_seq_no", nativeQuery = true)
	ArrayList<LMSTestEnrollMaster> getSelectEnrollsForInstitutes(@Param("id") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_ENROLL_MASTER WHERE where a.test_enroll_SEQ_NO in :enrollSeqNos", nativeQuery = true)
	void delSelectTestEnrolls(@Param("enrollSeqNos") ArrayList<Long> enrollSeqNos);

	@Query(value = "DELETE FROM LMS_TEST_ENROLL_MASTER WHERE WHERE a.INSTITUTION_SEQ_NO in :ids", nativeQuery = true)
	void delSelectEnrollsForInstitutes(@Param("id") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_ENROLL_MASTER WHERE a.test_SEQ_NO in :ids", nativeQuery = true)
	void delSelectTestEnrollxForTests(@Param("id") ArrayList<Long> ids);
}
