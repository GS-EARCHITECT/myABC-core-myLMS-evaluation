package test_enrollment.enroll_subjects.model.dto;

import java.io.Serializable;

/**
 * The persistent class for the LMS_TEST_ENROLL_MASTER database table.
 * 
 */
public class LMSTestEnrollSubjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1055330036083415731L;
	private long enrollSeqNo;
	private long sourceSubjectSeqNo;
	private long targetSubjectSeqNo;

	public long getEnrollSeqNo() {
		return enrollSeqNo;
	}

	public void setEnrollSeqNo(long enrollSeqNo) {
		this.enrollSeqNo = enrollSeqNo;
	}

	public long getSourceSubjectSeqNo() {
		return sourceSubjectSeqNo;
	}

	public void setSourceSubjectSeqNo(long sourceSubjectSeqNo) {
		this.sourceSubjectSeqNo = sourceSubjectSeqNo;
	}

	public long getTargetSubjectSeqNo() {
		return targetSubjectSeqNo;
	}

	public void setTargetSubjectSeqNo(long targetSubjectSeqNo) {
		this.targetSubjectSeqNo = targetSubjectSeqNo;
	}

	public LMSTestEnrollSubjectDTO(long enrollSeqNo, long sourceSubjectSeqNo, long targetSubjectSeqNo) {
		super();
		this.enrollSeqNo = enrollSeqNo;
		this.sourceSubjectSeqNo = sourceSubjectSeqNo;
		this.targetSubjectSeqNo = targetSubjectSeqNo;
	}

	public LMSTestEnrollSubjectDTO() {
		super();
	}

}