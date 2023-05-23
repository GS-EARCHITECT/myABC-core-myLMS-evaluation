package test_master_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSTestMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2492308104188479814L;
	private long testSeqNo;
	private String frDttm;
	private Long institutionSeqNo;
	private BigDecimal testCategorySeqNo;
	private String testId;
	private String toDttm;

	public long getTestSeqNo() {
		return testSeqNo;
	}

	public void setTestSeqNo(long testSeqNo) {
		this.testSeqNo = testSeqNo;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public BigDecimal getTestCategorySeqNo() {
		return testCategorySeqNo;
	}

	public void setTestCategorySeqNo(BigDecimal testCategorySeqNo) {
		this.testCategorySeqNo = testCategorySeqNo;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public LMSTestMasterDTO() {
		super();
	}

}