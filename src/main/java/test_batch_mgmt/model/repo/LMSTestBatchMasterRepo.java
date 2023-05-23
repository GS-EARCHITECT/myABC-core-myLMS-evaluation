package test_batch_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_batch_mgmt.model.master.LMSTestBatchMaster;

@Repository("lmsTestBatchMasterRepo")
public interface LMSTestBatchMasterRepo extends CrudRepository<LMSTestBatchMaster, Long> 
{ 
	
	@Query(value = "select * FROM LMS_TEST_BATCH_MASTER b where a.ENOLL_SEQ_NO in :ids order by ENOLL_SEQ_NO, TEST_ROLL_NUMBER",nativeQuery = true) 
	ArrayList<LMSTestBatchMaster> getSelectStudentsForEnrolls(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_TEST_BATCH_MASTER a WHERE a.TEST_ROLL_NUMBER in :ids order by TEST_ROLL_NUMBER", nativeQuery = true)
	ArrayList<LMSTestBatchMaster> getSelectStudents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_BATCH_MASTER WHERE where a.ENOLL_SEQ_NO in :ids", nativeQuery = true)
	void delSelectStudentsForEnrolls(@Param("ids") ArrayList<Long> ids);
		
	@Query(value = "DELETE FROM LMS_TEST_BATCH_MASTER WHERE a.TEST_ROLL_NUMBER in :ids", nativeQuery = true)
	void delSelectStudents(@Param("ids") ArrayList<Long> ids);
	}
