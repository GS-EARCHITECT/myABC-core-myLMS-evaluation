package test_subject_mgmt.services;

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
import test_subject_mgmt.model.dto.LMSTestSubjectMasterDTO;
import test_subject_mgmt.model.master.LMSTestSubjectMaster;
import test_subject_mgmt.model.repo.LMSTestSubjectMasterRepo;

@Service("lmsTestSubjectMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSTestSubjectMasterService implements I_LMSTestSubjectMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSTestSubjectMaster_Controller.class);
	
	@Autowired
    private LMSTestSubjectMasterRepo lmsTestSubjectMasterRepo;

	@Override
    public ArrayList<LMSTestSubjectMasterDTO> getAllTestSubjects() 
    {
    	ArrayList<LMSTestSubjectMasterDTO> courseMasterDTOs = new ArrayList<LMSTestSubjectMasterDTO>();
    	ArrayList<LMSTestSubjectMaster> courseMasterOpts =  (ArrayList<LMSTestSubjectMaster>) lmsTestSubjectMasterRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getTestSubjectMasterDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
    @Override
    public ArrayList<Long> getSelectTestSubjects(Long id)
	{
		ArrayList<Long> LMSTestSubjects = lmsTestSubjectMasterRepo.getSelectTestSubjects(id);		
		return LMSTestSubjects;
	}
    
    @Override
    public ArrayList<LMSTestSubjectMasterDTO> getSelectTestsSubjects(ArrayList<Long> ids)
	{
		ArrayList<LMSTestSubjectMaster> lMasters = lmsTestSubjectMasterRepo.getSelectTestsSubjects(ids);		
		ArrayList<LMSTestSubjectMasterDTO> LMSTestSubjectMasterDTOs = null;
	
		if (lMasters != null) 
		{
		LMSTestSubjectMasterDTOs = getTestSubjectMasterDtos(lMasters);				
		}
		
		return LMSTestSubjectMasterDTOs;
	}
    
        
    @Override
    public ArrayList<LMSTestSubjectMasterDTO> getSelectTestsSubjectsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		ArrayList<LMSTestSubjectMaster> lMasters = lmsTestSubjectMasterRepo.getSelectTestsSubjectsBetweenTimes(ids, ts_Fr, ts_To);		
		ArrayList<LMSTestSubjectMasterDTO> LMSTestSubjectMasterDTOs = null;
	
		if (lMasters != null) 
		{
		LMSTestSubjectMasterDTOs = getTestSubjectMasterDtos(lMasters);				
		}
		
		return LMSTestSubjectMasterDTOs;
	}
    
        
    public LMSTestSubjectMasterDTO newLMSTestSubjectMaster(LMSTestSubjectMasterDTO lms_TestSubjectMasterDTO) 
    {    	
    LMSTestSubjectMaster lms_TestSubjectMaster = lmsTestSubjectMasterRepo.save(setCustomerMaster(lms_TestSubjectMasterDTO));
    LMSTestSubjectMasterDTO courseMasterDTO2 = getTestSubjectMasterDto(lms_TestSubjectMaster);
	return courseMasterDTO2;
    }

    public void updLMSTestSubjectMaster(LMSTestSubjectMasterDTO lMSTestSubjectMasterDTO) 
    {
    LMSTestSubjectMaster lms_TestSubjectMaster = setCustomerMaster(lMSTestSubjectMasterDTO);
    lmsTestSubjectMasterRepo.save(lms_TestSubjectMaster);    
    }
    
    public void delSelectTestSubjects(ArrayList<Long> ids) 
    {
    lmsTestSubjectMasterRepo.delSelectTestSubjects(ids);
    }

    public void delAllLMSTestSubjectMasters() 
    {
    lmsTestSubjectMasterRepo.deleteAll();
    }
    
    @Override
    public void delSelectTestSubjectsBetweenTimes(ArrayList<Long> ids, String frDtTm, String toDtTm)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(frDtTm, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(toDtTm, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		lmsTestSubjectMasterRepo.delSelectTestSubjectsBetweenTimes(ids, ts_Fr, ts_To);					
		return ;
	}
    
    private ArrayList<LMSTestSubjectMasterDTO> getTestSubjectMasterDtos(ArrayList<LMSTestSubjectMaster> lms_TestSubjectMasters) 
	{
		LMSTestSubjectMasterDTO courseMasterDTO = null;
		ArrayList<LMSTestSubjectMasterDTO> courseMasterDTOs = new ArrayList<LMSTestSubjectMasterDTO>(); 
		
		for(int i=0; i<lms_TestSubjectMasters.size();i++)
		{		
		courseMasterDTO = getTestSubjectMasterDto(lms_TestSubjectMasters.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	
	private LMSTestSubjectMasterDTO getTestSubjectMasterDto(LMSTestSubjectMaster testMaster) 
	{
		LMSTestSubjectMasterDTO lDTO = new LMSTestSubjectMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");				
		lDTO.setFrDttm(formatter.format(testMaster.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(testMaster.getToDttm().toLocalDateTime()));
		lDTO.setPaperSeqNo(testMaster.getPaperSeqNo());
		lDTO.setSubjectSeqNo(testMaster.getSubjectSeqNo());
		lDTO.setTestScheduleSeqNo(testMaster.getTestScheduleSeqNo());
		lDTO.setTestSeqNo(testMaster.getTestSeqNo());		
		return lDTO;
		}
	
	private LMSTestSubjectMaster setCustomerMaster(LMSTestSubjectMasterDTO sMasterDTO) 
	{
		LMSTestSubjectMaster lms_TestSubjectMaster	=	new	LMSTestSubjectMaster();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(sMasterDTO.getFrDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(sMasterDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lms_TestSubjectMaster.setPaperSeqNo(sMasterDTO.getPaperSeqNo());
		lms_TestSubjectMaster.setSubjectSeqNo(sMasterDTO.getSubjectSeqNo());
		lms_TestSubjectMaster.setFrDttm(ts_Fr);
		lms_TestSubjectMaster.setToDttm(ts_To);
		lms_TestSubjectMaster.setTestSeqNo(sMasterDTO.getTestSeqNo());
		return lms_TestSubjectMaster;
	}

}
