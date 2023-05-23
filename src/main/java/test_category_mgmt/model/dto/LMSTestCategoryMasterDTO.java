package test_category_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSTestCategoryMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7878872688899184192L;
	private BigDecimal testCategorySeqNo;
	private Long institutionSeqNo;
	private String testCategory;

	public BigDecimal getTestCategorySeqNo() {
		return testCategorySeqNo;
	}

	public void setTestCategorySeqNo(BigDecimal testCategorySeqNo) {
		this.testCategorySeqNo = testCategorySeqNo;
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public String getTestCategory() {
		return testCategory;
	}

	public void setTestCategory(String testCategory) {
		this.testCategory = testCategory;
	}

	public LMSTestCategoryMasterDTO(BigDecimal testCategorySeqNo, Long institutionSeqNo, String testCategory) {
		super();
		this.testCategorySeqNo = testCategorySeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.testCategory = testCategory;
	}

	public LMSTestCategoryMasterDTO() {
		super();
	}

}