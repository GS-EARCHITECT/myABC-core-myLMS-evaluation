package test_enrollment.enroll_subjects.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test_enrollment.enroll_subjects.model.details.LMSTestEnrollSubject;
import test_enrollment.enroll_subjects.model.details.LMSTestEnrollSubjectPK;
import test_enrollment.enroll_subjects.model.dto.LMSTestEnrollSubjectDTO;
import test_enrollment.enroll_subjects.model.repo.LMSTestEnrollSubjectRepo;

@Service("lmsTestEnrollSubjectServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSTestEnrollSubjectService implements I_LMSTestEnrollSubjectService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSTestEnrollSubject_Controller.class);
	
	@Autowired
    private LMSTestEnrollSubjectRepo lmsTestEnrollSubjectRepo;

	@Override
	public ArrayList<LMSTestEnrollSubjectDTO> getAllTestEnrollSubjects() 
    {
    	ArrayList<LMSTestEnrollSubjectDTO> courseSubjectDTOs = new ArrayList<LMSTestEnrollSubjectDTO>();
    	ArrayList<LMSTestEnrollSubject> courseSubjectOpts =  (ArrayList<LMSTestEnrollSubject>) lmsTestEnrollSubjectRepo.findAll();
    	    	
    	if(courseSubjectOpts!=null)
    	{
    		courseSubjectDTOs = getTestEnrollSubjectDtos(courseSubjectOpts);
    	}
    	else
    	{
    		courseSubjectDTOs= null;    	
    	}
            	
        return courseSubjectDTOs;
    }
    
	@Override
	public ArrayList<LMSTestEnrollSubjectDTO> getSelectTestSubjectsByEnrolls(ArrayList<Long> enrollSeqNos)
	{
		ArrayList<LMSTestEnrollSubject> lSubjects = lmsTestEnrollSubjectRepo.getSelectTestSubjectsByEnrolls(enrollSeqNos);
		ArrayList<LMSTestEnrollSubjectDTO> LMSTestEnrollSubjectDTOs = new ArrayList<LMSTestEnrollSubjectDTO>();
		
		if (lSubjects != null) 
		{
		LMSTestEnrollSubjectDTOs = getTestEnrollSubjectDtos(lSubjects);				
		}
		
		return LMSTestEnrollSubjectDTOs;
	}

    @Override
    public ArrayList<LMSTestEnrollSubjectDTO> getSelectEnrollsForSubjects(ArrayList<Long> ids)
	{
		ArrayList<LMSTestEnrollSubject> lSubjects = lmsTestEnrollSubjectRepo.getSelectEnrollsForSubjects(ids);
		ArrayList<LMSTestEnrollSubjectDTO> LMSTestEnrollSubjectDTOs = new ArrayList<LMSTestEnrollSubjectDTO>();
		
		if (lSubjects != null) 
		{
		LMSTestEnrollSubjectDTOs = getTestEnrollSubjectDtos(lSubjects);				
		}
		
		return LMSTestEnrollSubjectDTOs;
	}
    
         
    public LMSTestEnrollSubjectDTO newLMSTestEnrollSubject(LMSTestEnrollSubjectDTO lms_TestEnrollSubjectDTO) 
    {    	
    	LMSTestEnrollSubject lmsTestEnrollSubject = null;
    	LMSTestEnrollSubjectPK lmsTestEnrollSubjectPK = new LMSTestEnrollSubjectPK();
    	lmsTestEnrollSubjectPK.setEnrollSeqNo(lms_TestEnrollSubjectDTO.getEnrollSeqNo());
    	lmsTestEnrollSubjectPK.setSourceSubjectSeqNo(lms_TestEnrollSubjectDTO.getSourceSubjectSeqNo());
    	lmsTestEnrollSubjectPK.setTargetSubjectSeqNo(lms_TestEnrollSubjectDTO.getTargetSubjectSeqNo());
						
		if (!lmsTestEnrollSubjectRepo.existsById(lmsTestEnrollSubjectPK))
		{						
			lmsTestEnrollSubject = this.setTestEnrollSubject(lms_TestEnrollSubjectDTO);
			lmsTestEnrollSubject.setId(lmsTestEnrollSubjectPK);
			lms_TestEnrollSubjectDTO = this.getTestEnrollSubjectDto(lmsTestEnrollSubjectRepo.save(lmsTestEnrollSubject));		
		}
		return lms_TestEnrollSubjectDTO;
}

    public void updLMSTestEnrollSubject(LMSTestEnrollSubjectDTO lMSTestEnrollSubjectDTO) 
    {
    	LMSTestEnrollSubject lmsTestEnrollSubject = null;
    	LMSTestEnrollSubjectPK lmsTestEnrollSubjectPK = new LMSTestEnrollSubjectPK();
    	lmsTestEnrollSubjectPK.setEnrollSeqNo(lMSTestEnrollSubjectDTO.getEnrollSeqNo());
    	lmsTestEnrollSubjectPK.setSourceSubjectSeqNo(lMSTestEnrollSubjectDTO.getSourceSubjectSeqNo());
    	lmsTestEnrollSubjectPK.setTargetSubjectSeqNo(lMSTestEnrollSubjectDTO.getTargetSubjectSeqNo());
	
    	if (lmsTestEnrollSubjectRepo.existsById(lmsTestEnrollSubjectPK))
    	{
    		lmsTestEnrollSubject = this.setTestEnrollSubject(lMSTestEnrollSubjectDTO);
    		lmsTestEnrollSubject.setId(lmsTestEnrollSubjectPK);
    		lMSTestEnrollSubjectDTO = this.getTestEnrollSubjectDto(lmsTestEnrollSubjectRepo.save(lmsTestEnrollSubject));
		}
        
    }

    public void delSelectTestSubjectsByEnrolls(ArrayList<Long> enrollSeqNos) 
    {
    lmsTestEnrollSubjectRepo.delSelectTestSubjectsByEnrolls(enrollSeqNos);
    }
    
    public void delSelectEnrollsForSubjects(ArrayList<Long> ids) 
    {
    lmsTestEnrollSubjectRepo.delSelectEnrollsForSubjects(ids);
    }
    
    public void delAllLMSTestEnrollSubject() 
    {
    lmsTestEnrollSubjectRepo.deleteAll();
    }
    
    private ArrayList<LMSTestEnrollSubjectDTO> getTestEnrollSubjectDtos(ArrayList<LMSTestEnrollSubject> lms_TestEnrollSubjects) 
	{
		LMSTestEnrollSubjectDTO courseSubjectDTO = null;
		ArrayList<LMSTestEnrollSubjectDTO> courseSubjectDTOs = new ArrayList<LMSTestEnrollSubjectDTO>(); 
		
		for(int i=0; i<lms_TestEnrollSubjects.size();i++)
		{		
		courseSubjectDTO = getTestEnrollSubjectDto(lms_TestEnrollSubjects.get(i));
		courseSubjectDTOs.add(courseSubjectDTO);
		}		
		return courseSubjectDTOs;
	}
	
	
	private LMSTestEnrollSubjectDTO getTestEnrollSubjectDto(LMSTestEnrollSubject testSubject) 
	{
		LMSTestEnrollSubjectDTO lDTO = new LMSTestEnrollSubjectDTO();
		lDTO.setEnrollSeqNo(testSubject.getId().getEnrollSeqNo());
		lDTO.setSourceSubjectSeqNo(testSubject.getId().getSourceSubjectSeqNo());
		lDTO.setTargetSubjectSeqNo(testSubject.getId().getTargetSubjectSeqNo());
		return lDTO;
		}
	
	private LMSTestEnrollSubject setTestEnrollSubject(LMSTestEnrollSubjectDTO sSubjectDTO) 
	{
		LMSTestEnrollSubjectPK testEnrollSubjectPK = new LMSTestEnrollSubjectPK();
		testEnrollSubjectPK.setEnrollSeqNo(sSubjectDTO.getEnrollSeqNo());
		testEnrollSubjectPK.setSourceSubjectSeqNo(sSubjectDTO.getSourceSubjectSeqNo());
		testEnrollSubjectPK.setTargetSubjectSeqNo(sSubjectDTO.getTargetSubjectSeqNo());
		LMSTestEnrollSubject lms_TestEnrollSubject	=	new	LMSTestEnrollSubject();		
		lms_TestEnrollSubject.setId(testEnrollSubjectPK);
		return lms_TestEnrollSubject;
	}

}
