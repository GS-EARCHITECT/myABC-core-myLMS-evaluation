package test_category_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the LMS_TEST_CATEGORY_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_CATEGORY_MASTER")
public class LMSTestCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_TEST_CATEGORY_SEQ_NO")
	@SequenceGenerator(name = "LMS_TEST_CATEGORY_SEQ_NO", sequenceName = "LMS_TEST_CATEGORY_SEQ_NO", allocationSize = 1)
	@Column(name = "TEST_CATEGORY_SEQ_NO")
	private BigDecimal testCategorySeqNo;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "TEST_CATEGORY")
	private String testCategory;

	public LMSTestCategoryMaster() {
	}

	public BigDecimal getTestCategorySeqNo() {
		return this.testCategorySeqNo;
	}

	public void setTestCategorySeqNo(BigDecimal testCategorySeqNo) {
		this.testCategorySeqNo = testCategorySeqNo;
	}

	public Long getInstitutionSeqNo() {
		return this.institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public String getTestCategory() {
		return this.testCategory;
	}

	public void setTestCategory(String testCategory) {
		this.testCategory = testCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((testCategory == null) ? 0 : testCategory.hashCode());
		result = prime * result + ((testCategorySeqNo == null) ? 0 : testCategorySeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSTestCategoryMaster other = (LMSTestCategoryMaster) obj;
		if (institutionSeqNo == null) {
			if (other.institutionSeqNo != null)
				return false;
		} else if (!institutionSeqNo.equals(other.institutionSeqNo))
			return false;
		if (testCategory == null) {
			if (other.testCategory != null)
				return false;
		} else if (!testCategory.equals(other.testCategory))
			return false;
		if (testCategorySeqNo == null) {
			if (other.testCategorySeqNo != null)
				return false;
		} else if (!testCategorySeqNo.equals(other.testCategorySeqNo))
			return false;
		return true;
	}

	public LMSTestCategoryMaster(BigDecimal testCategorySeqNo, java.lang.Long institutionSeqNo, String testCategory) {
		super();
		this.testCategorySeqNo = testCategorySeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.testCategory = testCategory;
	}
}