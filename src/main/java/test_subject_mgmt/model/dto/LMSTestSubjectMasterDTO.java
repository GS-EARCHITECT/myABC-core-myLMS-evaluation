package test_subject_mgmt.model.dto;

import java.io.Serializable;

public class LMSTestSubjectMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8798500438019153710L;
	private long testScheduleSeqNo;
	private String frDttm;
	private Long paperSeqNo;
	private Long subjectSeqNo;
	private Long testSeqNo;
	private String toDttm;

	public long getTestScheduleSeqNo() {
		return testScheduleSeqNo;
	}

	public void setTestScheduleSeqNo(long testScheduleSeqNo) {
		this.testScheduleSeqNo = testScheduleSeqNo;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public Long getPaperSeqNo() {
		return paperSeqNo;
	}

	public void setPaperSeqNo(Long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	public Long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public Long getTestSeqNo() {
		return testSeqNo;
	}

	public void setTestSeqNo(Long testSeqNo) {
		this.testSeqNo = testSeqNo;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public LMSTestSubjectMasterDTO(long testScheduleSeqNo, String frDttm, Long paperSeqNo, Long subjectSeqNo,
			Long testSeqNo, String toDttm) {
		super();
		this.testScheduleSeqNo = testScheduleSeqNo;
		this.frDttm = frDttm;
		this.paperSeqNo = paperSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.testSeqNo = testSeqNo;
		this.toDttm = toDttm;
	}

	public LMSTestSubjectMasterDTO() {
		super();
	}

}