package test_master_mgmt.services;

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

import test_master_mgmt.model.dto.LMSTestMasterDTO;
import test_master_mgmt.model.master.LMSTestMaster;
import test_master_mgmt.model.repo.LMSTestMasterRepo;

@Service("lmsTestMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSTestMasterService implements I_LMSTestMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSTestMaster_Controller.class);
	
	@Autowired
    private LMSTestMasterRepo lmsTestMasterRepo;

	@Override
    public ArrayList<LMSTestMasterDTO> getAllTests() 
    {
    	ArrayList<LMSTestMasterDTO> courseMasterDTOs = new ArrayList<LMSTestMasterDTO>();
    	ArrayList<LMSTestMaster> courseMasterOpts =  (ArrayList<LMSTestMaster>) lmsTestMasterRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getTestMasterDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
	@Override
    public ArrayList<LMSTestMasterDTO> getSelectTestsForInst(ArrayList<Long> ids, ArrayList<Long> iSeqNos)
	{
		ArrayList<LMSTestMaster> lMasters = lmsTestMasterRepo.getSelectTestsForInst(ids, iSeqNos);
		ArrayList<LMSTestMasterDTO> LMSTestMasterDTOs = new ArrayList<LMSTestMasterDTO>();
		
		if (lMasters != null) 
		{
		LMSTestMasterDTOs = getTestMasterDtos(lMasters);				
		}
		
		return LMSTestMasterDTOs;
	}

	
	
    @Override
    public ArrayList<LMSTestMasterDTO> getSelectTests(ArrayList<Long> ids)
	{
		ArrayList<LMSTestMaster> lMasters = lmsTestMasterRepo.getSelectTests(ids);
		ArrayList<LMSTestMasterDTO> LMSTestMasterDTOs = new ArrayList<LMSTestMasterDTO>();
		
		if (lMasters != null) 
		{
		LMSTestMasterDTOs = getTestMasterDtos(lMasters);				
		}
		
		return LMSTestMasterDTOs;
	}
        
    @Override
    public ArrayList<LMSTestMasterDTO> getSelectTestsBetweenTimesForInst(String frDtTm, String toDtTm, ArrayList<Long> iSeqNos)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		ArrayList<LMSTestMaster> lMasters = lmsTestMasterRepo.getSelectTestsBetweenTimesForInst(ts_Fr, ts_To, iSeqNos);		
		ArrayList<LMSTestMasterDTO> LMSTestMasterDTOs = null;
	
		if (lMasters != null) 
		{
		LMSTestMasterDTOs = getTestMasterDtos(lMasters);				
		}
		
		return LMSTestMasterDTOs;
	}
    
    @Override
    public ArrayList<LMSTestMasterDTO> getSelectTestsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		ArrayList<LMSTestMaster> lMasters = lmsTestMasterRepo.getSelectTestsBetweenTimes(ids, ts_Fr, ts_To);		
		ArrayList<LMSTestMasterDTO> LMSTestMasterDTOs = null;

		if (lMasters != null) 
		{
		LMSTestMasterDTOs = getTestMasterDtos(lMasters);				
		}
		
		return LMSTestMasterDTOs;
	}
    
    
    public LMSTestMasterDTO newLMSTestMaster(LMSTestMasterDTO lms_TestMasterDTO) 
    {    	
    LMSTestMaster lms_TestMaster = lmsTestMasterRepo.save(setCustomerMaster(lms_TestMasterDTO));
    LMSTestMasterDTO courseMasterDTO2 = getTestMasterDto(lms_TestMaster);
	return courseMasterDTO2;
    }

    public void updLMSTestMaster(LMSTestMasterDTO lMSTestMasterDTO) 
    {
    LMSTestMaster lms_TestMaster = setCustomerMaster(lMSTestMasterDTO);
    lmsTestMasterRepo.save(lms_TestMaster);    
    }

    public void delSelectTestsForInst(ArrayList<Long> ids, ArrayList<Long> iSeqNo) 
    {
    lmsTestMasterRepo.delSelectTestsForInst(ids, iSeqNo);
    }
    
    public void delSelectTests(ArrayList<Long> ids) 
    {
    lmsTestMasterRepo.delSelectTests(ids);
    }

    public void delAllLMSTestMasters() 
    {
    lmsTestMasterRepo.deleteAll();
    }
    
    @Override
    public void delSelectTestsBetweenTimesForInst(String frDtTm, String toDtTm, ArrayList<Long> iSeqNo)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		lmsTestMasterRepo.delSelectTestsBetweenTimesForInst(ts_Fr, ts_To, iSeqNo);					
		return ;
	}
    
    
    @Override
    public void delSelectTestsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		lmsTestMasterRepo.delSelectTestsBetweenTimes(ids, ts_Fr, ts_To);
				
		return ;
	}

    
    private ArrayList<LMSTestMasterDTO> getTestMasterDtos(ArrayList<LMSTestMaster> lms_TestMasters) 
	{
		LMSTestMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestMasterDTO> courseMasterDTOs = new ArrayList<LMSTestMasterDTO>(); 
		
		for(int i=0; i<lms_TestMasters.size();i++)
		{		
		courseMasterDTO = getTestMasterDto(lms_TestMasters.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	
	private LMSTestMasterDTO getTestMasterDto(LMSTestMaster testMaster) 
	{
		LMSTestMasterDTO lDTO = new LMSTestMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");				
		lDTO.setFrDttm(formatter.format(testMaster.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(testMaster.getToDttm().toLocalDateTime()));
		lDTO.setInstitutionSeqNo(testMaster.getInstitutionSeqNo());
		lDTO.setTestCategorySeqNo(testMaster.getTestCategorySeqNo());
		lDTO.setTestId(testMaster.getTestId());
		lDTO.setTestSeqNo(testMaster.getTestSeqNo());		
		return lDTO;
		}
	
	private LMSTestMaster setCustomerMaster(LMSTestMasterDTO sMasterDTO) 
	{
		LMSTestMaster lms_TestMaster	=	new	LMSTestMaster();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(sMasterDTO.getFrDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(sMasterDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lms_TestMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_TestMaster.setTestCategorySeqNo(sMasterDTO.getTestCategorySeqNo());
		lms_TestMaster.setTestId(sMasterDTO.getTestId());
		lms_TestMaster.setFrDttm(ts_Fr);
		lms_TestMaster.setToDttm(ts_To);
		return lms_TestMaster;
	}

}
