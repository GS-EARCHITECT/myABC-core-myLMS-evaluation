package test_paper_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test_paper_mgmt.model.master.LMSTestPaperMaster;

@Repository("lmsTestPaperMasterRepo")
public interface LMSTestPaperMasterRepo extends CrudRepository<LMSTestPaperMaster, Long> 
{ 
	@Query(value = "select * FROM LMS_TEST_PAPER_MASTER b where a.paper_SEQ_NO = :ids",nativeQuery = true) 
	ArrayList<LMSTestPaperMaster> getSelectTestsPapers(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_TEST_PAPER_MASTER a WHERE a.subject_SEQ_NO in :ids order by paper_seq_no", nativeQuery = true)
	ArrayList<LMSTestPaperMaster> getSelectTestsPapersBySubjects(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_PAPER_MASTER WHERE a.paper_SEQ_NO in :ids", nativeQuery = true)
	void delSelectTestsPapers(@Param("ids") ArrayList<Long> ids);
		
	@Query(value = "delete FROM LMS_TEST_PAPER_MASTER b where a.paper_paper_SEQ_NO in :ids",nativeQuery = true) 
	void delSelectTestPapersPapersBySubjects(@Param("ids") ArrayList<Long> ids); 
}
