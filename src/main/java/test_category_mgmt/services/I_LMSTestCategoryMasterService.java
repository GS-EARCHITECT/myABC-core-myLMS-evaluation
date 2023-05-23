package test_category_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import test_category_mgmt.model.dto.LMSTestCategoryMasterDTO;

public interface I_LMSTestCategoryMasterService 
{
	abstract public LMSTestCategoryMasterDTO newLMSTestCategoryMaster(LMSTestCategoryMasterDTO testDTO);

	abstract public ArrayList<LMSTestCategoryMasterDTO> getAllTestCategories();

	abstract public ArrayList<LMSTestCategoryMasterDTO> getSelectTestCategories(ArrayList<BigDecimal> ids);

	abstract public ArrayList<LMSTestCategoryMasterDTO> getSelectTestCategoriesForInst(ArrayList<Long> ids);

	abstract public void updLMSTestCategoryMaster(LMSTestCategoryMasterDTO LMSTestCategoryMasterDTO);

	abstract public void delAllLMSTestCategoryMasters();

	abstract public void delSelectTestCategories(ArrayList<BigDecimal> ids);

	abstract public void delSelectTestsForInst(ArrayList<Long> ids);

}