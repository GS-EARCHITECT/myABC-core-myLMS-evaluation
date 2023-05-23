package test_subject_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_subject_mgmt.model.master.LMSTestSubjectMaster;

@Repository("lmsTestSubjectMasterRepo")
public interface LMSTestSubjectMasterRepo extends CrudRepository<LMSTestSubjectMaster, Long> 
{ 
	@Query(value = "select coalesce(subject_seq_no,0) FROM LMS_TEST_SUBJECT_MASTER b where a.test_SEQ_NO = :id",nativeQuery = true) 
	ArrayList<Long> getSelectTestSubjects(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM LMS_TEST_SUBJECT_MASTER a WHERE a.test_SEQ_NO in :ids order by test_seq_no", nativeQuery = true)
	ArrayList<LMSTestSubjectMaster> getSelectTestsSubjects(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "select * FROM LMS_TEST_SUBJECT_MASTER b where ((a.test_test_SEQ_NO in :ids) and (b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm))",nativeQuery = true) 
	ArrayList<LMSTestSubjectMaster> getSelectTestsSubjectsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM LMS_TEST_SUBJECT_MASTER WHERE a.test_SEQ_NO in :ids", nativeQuery = true)
	void delSelectTestSubjects(@Param("ids") ArrayList<Long> ids);
		
	@Query(value = "delete FROM LMS_TEST_SUBJECT_MASTER b where ((a.test_test_SEQ_NO in :ids) and (b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm))",nativeQuery = true) 
	void delSelectTestSubjectsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm); 
}
