package test_enrollment.enroll_master.model.dto;

import java.io.Serializable;

/**
 * The persistent class for the LMS_TEST_ENROLL_MASTER database table.
 * 
 */
public class LMSTestEnrollMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -625956187011662357L;
	private long enrollSeqNo;
	private Long institutionSeqNo;
	private Long testSeqNo;

	public long getEnrollSeqNo() {
		return enrollSeqNo;
	}

	public void setEnrollSeqNo(long enrollSeqNo) {
		this.enrollSeqNo = enrollSeqNo;
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getTestSeqNo() {
		return testSeqNo;
	}

	public void setTestSeqNo(Long testSeqNo) {
		this.testSeqNo = testSeqNo;
	}

	public LMSTestEnrollMasterDTO(long enrollSeqNo, Long institutionSeqNo, Long testSeqNo) {
		super();
		this.enrollSeqNo = enrollSeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.testSeqNo = testSeqNo;
	}

	public LMSTestEnrollMasterDTO() {
		super();
	}

}