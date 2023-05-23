package test_category_mgmt.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test_category_mgmt.model.dto.LMSTestCategoryMasterDTO;
import test_category_mgmt.model.master.LMSTestCategoryMaster;
import test_category_mgmt.model.repo.LMSTestCategoryMasterRepo;

@Service("lmsTestCategoryMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSTestCategoryMasterService implements I_LMSTestCategoryMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSTestCategoryMaster_Controller.class);
	
	@Autowired
    private LMSTestCategoryMasterRepo lmsTestCategoryMasterRepo;

	@Override
    public ArrayList<LMSTestCategoryMasterDTO> getAllTestCategories() 
    {
    	ArrayList<LMSTestCategoryMasterDTO> courseMasterDTOs = new ArrayList<LMSTestCategoryMasterDTO>();
    	ArrayList<LMSTestCategoryMaster> courseMasterOpts =  (ArrayList<LMSTestCategoryMaster>) lmsTestCategoryMasterRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getTestCategoryMasterDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSTestCategoryMasterDTO> getSelectTestCategories(ArrayList<BigDecimal> ids)
	{
		ArrayList<LMSTestCategoryMaster> lMasters = lmsTestCategoryMasterRepo.getSelectTestCategories(ids);
		ArrayList<LMSTestCategoryMasterDTO> LMSTestCategoryMasterDTOs = new ArrayList<LMSTestCategoryMasterDTO>();
		LMSTestCategoryMasterDTO LMSTestCategoryMasterDTO = null;

		if (lMasters != null) 
		{
		LMSTestCategoryMasterDTOs = getTestCategoryMasterDtos(lMasters);				
		}
		
		return LMSTestCategoryMasterDTOs;
	}

    @Override
    public ArrayList<LMSTestCategoryMasterDTO> getSelectTestCategoriesForInst(ArrayList<Long> ids)
	{
		ArrayList<LMSTestCategoryMaster> lMasters = lmsTestCategoryMasterRepo.getSelectTestCategoriesForInst(ids);		
		ArrayList<LMSTestCategoryMasterDTO> LMSTestCategoryMasterDTOs = null;
		LMSTestCategoryMasterDTO LMSTestCategoryMasterDTO = null;

		if (lMasters != null) 
		{
		LMSTestCategoryMasterDTOs = getTestCategoryMasterDtos(lMasters);				
		}
		
		return LMSTestCategoryMasterDTOs;
	}
    
    
    public LMSTestCategoryMasterDTO newLMSTestCategoryMaster(LMSTestCategoryMasterDTO lms_TestCategoryMasterDTO) 
    {    	
    LMSTestCategoryMaster lms_TestCategoryMaster = lmsTestCategoryMasterRepo.save(setCustomerMaster(lms_TestCategoryMasterDTO));
    LMSTestCategoryMasterDTO courseMasterDTO2 = getTestCategoryMasterDto(lms_TestCategoryMaster);
	return courseMasterDTO2;
    }

    public void updLMSTestCategoryMaster(LMSTestCategoryMasterDTO lMSTestCategoryMasterDTO) 
    {
    LMSTestCategoryMaster lms_TestCategoryMaster = setCustomerMaster(lMSTestCategoryMasterDTO);
    lmsTestCategoryMasterRepo.save(lms_TestCategoryMaster);    
    }
    
    public void delSelectTestCategories(ArrayList<BigDecimal> ids) 
    {
    lmsTestCategoryMasterRepo.delSelectTestCategories(ids);
    }

    public void delAllLMSTestCategoryMasters() 
    {
    lmsTestCategoryMasterRepo.deleteAll();
    }
    
    @Override
    public void delSelectTestsForInst(ArrayList<Long> ids)
	{
		lmsTestCategoryMasterRepo.delSelectTestsForInst(ids);				
		return ;
	}

    
    private ArrayList<LMSTestCategoryMasterDTO> getTestCategoryMasterDtos(ArrayList<LMSTestCategoryMaster> lms_TestCategoryMasters) 
	{
		LMSTestCategoryMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestCategoryMasterDTO> courseMasterDTOs = new ArrayList<LMSTestCategoryMasterDTO>(); 
		
		for(int i=0; i<lms_TestCategoryMasters.size();i++)
		{		
		courseMasterDTO = getTestCategoryMasterDto(lms_TestCategoryMasters.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	
	private LMSTestCategoryMasterDTO getTestCategoryMasterDto(LMSTestCategoryMaster categoryMaster) 
	{
		LMSTestCategoryMasterDTO lDTO = new LMSTestCategoryMasterDTO();
		lDTO.setInstitutionSeqNo(categoryMaster.getInstitutionSeqNo());
		lDTO.setTestCategorySeqNo(categoryMaster.getTestCategorySeqNo());
		lDTO.setTestCategory(categoryMaster.getTestCategory());			
		return lDTO;
		}
	
	private LMSTestCategoryMaster setCustomerMaster(LMSTestCategoryMasterDTO sMasterDTO) 
	{
		LMSTestCategoryMaster lms_TestCategoryMaster	=	new	LMSTestCategoryMaster();		
		lms_TestCategoryMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());		
		lms_TestCategoryMaster.setTestCategory(sMasterDTO.getTestCategory());
		return lms_TestCategoryMaster;
	}

}
