package test_enrollment.enroll_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test_enrollment.enroll_master.model.dto.LMSTestEnrollMasterDTO;
import test_enrollment.enroll_master.model.master.LMSTestEnrollMaster;
import test_enrollment.enroll_master.model.repo.LMSTestEnrollMasterRepo;

@Service("lmsTestEnrollMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSTestEnrollMasterService implements I_LMSTestEnrollMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSTestEnrollMaster_Controller.class);
	
	@Autowired
    private LMSTestEnrollMasterRepo lmsTestEnrollMasterRepo;

	@Override
    public ArrayList<LMSTestEnrollMasterDTO> getAllTestEnrollMaster() 
    {
    	ArrayList<LMSTestEnrollMasterDTO> courseMasterDTOs = new ArrayList<LMSTestEnrollMasterDTO>();
    	ArrayList<LMSTestEnrollMaster> courseMasterOpts =  (ArrayList<LMSTestEnrollMaster>) lmsTestEnrollMasterRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getTestEnrollMasterDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
	@Override
    public ArrayList<LMSTestEnrollMasterDTO> getSelectTestEnrollMasters(ArrayList<Long> enrollSeqNos)
	{
		ArrayList<LMSTestEnrollMaster> lMasters = lmsTestEnrollMasterRepo.getSelectTestEnrollMasters(enrollSeqNos);
		ArrayList<LMSTestEnrollMasterDTO> LMSTestEnrollMasterDTOs = new ArrayList<LMSTestEnrollMasterDTO>();
		
		if (lMasters != null) 
		{
		LMSTestEnrollMasterDTOs = getTestEnrollMasterDtos(lMasters);				
		}
		
		return LMSTestEnrollMasterDTOs;
	}

	
	
    @Override
    public ArrayList<LMSTestEnrollMasterDTO> getSelectEnrollsForTests(ArrayList<Long> ids)
	{
		ArrayList<LMSTestEnrollMaster> lMasters = lmsTestEnrollMasterRepo.getSelectEnrollsForTests(ids);
		ArrayList<LMSTestEnrollMasterDTO> LMSTestEnrollMasterDTOs = new ArrayList<LMSTestEnrollMasterDTO>();
		
		if (lMasters != null) 
		{
		LMSTestEnrollMasterDTOs = getTestEnrollMasterDtos(lMasters);				
		}
		
		return LMSTestEnrollMasterDTOs;
	}
    
    @Override
    public ArrayList<LMSTestEnrollMasterDTO> getSelectEnrollsForInstitutes(ArrayList<Long> ids)
	{
		ArrayList<LMSTestEnrollMaster> lMasters = lmsTestEnrollMasterRepo.getSelectEnrollsForInstitutes(ids);
		ArrayList<LMSTestEnrollMasterDTO> LMSTestEnrollMasterDTOs = new ArrayList<LMSTestEnrollMasterDTO>();
		
		if (lMasters != null) 
		{
		LMSTestEnrollMasterDTOs = getTestEnrollMasterDtos(lMasters);				
		}
		
		return LMSTestEnrollMasterDTOs;
	}
        
    public LMSTestEnrollMasterDTO newLMSTestEnrollMaster(LMSTestEnrollMasterDTO lms_TestEnrollMasterDTO) 
    {    	
    	LMSTestEnrollMaster lmsTestEnrollMaster = null;
		
		if (!lmsTestEnrollMasterRepo.existsById(lms_TestEnrollMasterDTO.getEnrollSeqNo()))
		{						
		lms_TestEnrollMasterDTO = this.getTestEnrollMasterDto(lmsTestEnrollMasterRepo.save(this.setCustomerMaster(lms_TestEnrollMasterDTO)));
		}
		return lms_TestEnrollMasterDTO;
}

    public void updLMSTestEnrollMaster(LMSTestEnrollMasterDTO lMSTestEnrollMasterDTO) 
    {
    LMSTestEnrollMaster lms_TestEnrollMaster = null;
    
    if (lmsTestEnrollMasterRepo.existsById(lMSTestEnrollMasterDTO.getEnrollSeqNo()))
	{						
    	lms_TestEnrollMaster = this.setCustomerMaster(lMSTestEnrollMasterDTO);
    	lms_TestEnrollMaster.setEnrollSeqNo(lMSTestEnrollMasterDTO.getEnrollSeqNo());
    	lMSTestEnrollMasterDTO = this.getTestEnrollMasterDto(lmsTestEnrollMasterRepo.save(this.setCustomerMaster(lMSTestEnrollMasterDTO)));
	}        
    }

    public void delSelectTestEnrolls(ArrayList<Long> enrollSeqNos) 
    {
    lmsTestEnrollMasterRepo.delSelectTestEnrolls(enrollSeqNos);
    }
    
    public void delSelectEnrollsForInstitutes(ArrayList<Long> ids) 
    {
    lmsTestEnrollMasterRepo.delSelectEnrollsForInstitutes(ids);
    }
    
    public void delSelectTestEnrollxForTests(ArrayList<Long> ids) 
    {
    lmsTestEnrollMasterRepo.delSelectTestEnrollxForTests(ids);;
    }

    public void delAllLMSTestEnrollMaster() 
    {
    lmsTestEnrollMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSTestEnrollMasterDTO> getTestEnrollMasterDtos(ArrayList<LMSTestEnrollMaster> lms_TestEnrollMasters) 
	{
		LMSTestEnrollMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestEnrollMasterDTO> courseMasterDTOs = new ArrayList<LMSTestEnrollMasterDTO>(); 
		
		for(int i=0; i<lms_TestEnrollMasters.size();i++)
		{		
		courseMasterDTO = getTestEnrollMasterDto(lms_TestEnrollMasters.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	
	private LMSTestEnrollMasterDTO getTestEnrollMasterDto(LMSTestEnrollMaster testMaster) 
	{
		LMSTestEnrollMasterDTO lDTO = new LMSTestEnrollMasterDTO();
		lDTO.setEnrollSeqNo(testMaster.getEnrollSeqNo());
		lDTO.setTestSeqNo(testMaster.getTestSeqNo());
		lDTO.setInstitutionSeqNo(testMaster.getInstitutionSeqNo());
		return lDTO;
		}
	
	private LMSTestEnrollMaster setCustomerMaster(LMSTestEnrollMasterDTO sMasterDTO) 
	{
		LMSTestEnrollMaster lms_TestEnrollMaster	=	new	LMSTestEnrollMaster();		
		lms_TestEnrollMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_TestEnrollMaster.setTestSeqNo(sMasterDTO.getTestSeqNo());
		return lms_TestEnrollMaster;
	}

}
