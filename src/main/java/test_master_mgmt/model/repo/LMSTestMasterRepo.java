package test_master_mgmt.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test_master_mgmt.model.master.LMSTestMaster;
@Repository("lmsTestMasterRepo")

public interface LMSTestMasterRepo extends CrudRepository<LMSTestMaster, Long> 
{ 
	
	@Query(value = "select * FROM LMS_TEST_MASTER b where ((a.test_test_SEQ_NO in :ids) and (b.institution_seq_no in :instSeqNos))",nativeQuery = true) 
	ArrayList<LMSTestMaster> getSelectTestsForInst(@Param("ids") ArrayList<Long> ids, @Param("instSeqNo") ArrayList<Long> instSeqNos);
	
	@Query(value = "SELECT * FROM LMS_TEST_MASTER a WHERE a.test_SEQ_NO in :ids order by test_seq_no", nativeQuery = true)
	ArrayList<LMSTestMaster> getSelectTests(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "select * FROM LMS_TEST_MASTER b where ((a.test_test_SEQ_NO in :ids) and (b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm) and (b.institution_seq_no in :instSeqNos))",nativeQuery = true) 
	ArrayList<LMSTestMaster> getSelectTestsBetweenTimesForInst(@Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm, @Param("instSeqNo") ArrayList<Long> instSeqNos);
		
	@Query(value = "select * FROM LMS_TEST_MASTER b where ((a.test_test_SEQ_NO in :ids) and (b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm))",nativeQuery = true) 
	ArrayList<LMSTestMaster> getSelectTestsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm);
	
	@Query(value = "DELETE FROM LMS_TEST_MASTER WHERE ((a.test_SEQ_NO in :ids) and (b.institution_seq_no in :instSeqNos))", nativeQuery = true)
	void delSelectTestsForInst(@Param("ids") ArrayList<Long> ids, @Param("instSeqNo") ArrayList<Long> instSeqNos);
		
	@Query(value = "DELETE FROM LMS_TEST_MASTER WHERE a.test_SEQ_NO in :ids", nativeQuery = true)
	void delSelectTests(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM LMS_TEST_MASTER b where ((b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm) and (b.institution_seq_no = :instSeqNos))",nativeQuery = true) 
	void delSelectTestsBetweenTimesForInst(@Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm, @Param("instSeqNo") ArrayList<Long> instSeqNos);
	
	@Query(value = "delete FROM LMS_TEST_MASTER b where (b.FROM_DTTM >= :frDtTm and b.FROM_DTTM <= :toDtTm)",nativeQuery = true) 
	void delSelectTestsBetweenTimes(@Param("ids") ArrayList<Long> ids, @Param("frDtTm") Timestamp frDtTm, @Param("frDtTm") Timestamp toDtTm); 
}
