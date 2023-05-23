package test_category_mgmt.model.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test_category_mgmt.model.master.LMSTestCategoryMaster;

@Repository("lmsTestCategoryMasterRepo")
public interface LMSTestCategoryMasterRepo extends CrudRepository<LMSTestCategoryMaster, BigDecimal> 
{ 
	@Query(value = "SELECT * FROM LMS_TEST_CATEGORY_MASTER a WHERE a.test_category_SEQ_NO in :ids order by test_category_seq_no", nativeQuery = true)
	ArrayList<LMSTestCategoryMaster> getSelectTestCategories(@Param("ids") ArrayList<BigDecimal> ids);
	
	@Query(value = "SELECT * FROM LMS_TEST_CATEGORY_MASTER a WHERE a.institution_SEQ_NO in :ids order by test_category_seq_no", nativeQuery = true)
	ArrayList<LMSTestCategoryMaster> getSelectTestCategoriesForInst(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_TEST_CATEGORY_MASTER WHERE a.test_category_SEQ_NO in :ids", nativeQuery = true)
	void delSelectTestCategories(@Param("ids") ArrayList<BigDecimal> ids);
		
	@Query(value = "delete FROM LMS_TEST_CATEGORY_MASTER b where a.institution_SEQ_NO in :ids",nativeQuery = true) 
	void delSelectTestsForInst(@Param("ids") ArrayList<Long> ids); 
}
