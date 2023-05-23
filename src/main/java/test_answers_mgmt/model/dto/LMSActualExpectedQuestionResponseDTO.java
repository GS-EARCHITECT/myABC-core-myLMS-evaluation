package test_answers_mgmt.model.dto;

import java.io.Serializable;

public class LMSActualExpectedQuestionResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5453497468761571577L;
	private Long pSeqNo;
	private Long qSeqNo;
	private Long rollNo;
	private Float max_marks;
	private LMSSubjectQuestionsMasterDTO lmsSubjectQuestionsMasterDTO;
	private LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO;

	public Long getpSeqNo() {
		return pSeqNo;
	}

	public void setpSeqNo(Long pSeqNo) {
		this.pSeqNo = pSeqNo;
	}

	public Long getqSeqNo() {
		return qSeqNo;
	}

	public void setqSeqNo(Long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public LMSSubjectQuestionsMasterDTO getLmsSubjectQuestionsMasterDTO() {
		return lmsSubjectQuestionsMasterDTO;
	}

	public void setLmsSubjectQuestionsMasterDTO(LMSSubjectQuestionsMasterDTO lmsSubjectQuestionsMasterDTO) {
		this.lmsSubjectQuestionsMasterDTO = lmsSubjectQuestionsMasterDTO;
	}

	public LMSTestResponseDetailsDTO getLmsTestResponseDetailsDTO() {
		return lmsTestResponseDetailsDTO;
	}

	public void setLmsTestResponseDetailsDTO(LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO) {
		this.lmsTestResponseDetailsDTO = lmsTestResponseDetailsDTO;
	}

	public LMSActualExpectedQuestionResponseDTO(Long pSeqNo, Long qSeqNo, Long rollNo, Float max_marks,
			LMSSubjectQuestionsMasterDTO lmsSubjectQuestionsMasterDTO,
			LMSTestResponseDetailsDTO lmsTestResponseDetailsDTO) {
		super();
		this.pSeqNo = pSeqNo;
		this.qSeqNo = qSeqNo;
		this.rollNo = rollNo;
		this.max_marks = max_marks;
		this.lmsSubjectQuestionsMasterDTO = lmsSubjectQuestionsMasterDTO;
		this.lmsTestResponseDetailsDTO = lmsTestResponseDetailsDTO;
	}

	public Float getMax_marks() {
		return max_marks;
	}

	public void setMax_marks(Float max_marks) {
		this.max_marks = max_marks;
	}

	public LMSActualExpectedQuestionResponseDTO() {
		super();
	}

}