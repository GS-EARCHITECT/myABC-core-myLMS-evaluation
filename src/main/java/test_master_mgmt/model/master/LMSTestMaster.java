package test_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the LMS_TEST_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_MASTER")
public class LMSTestMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_TEST_SEQUENCE")
	@SequenceGenerator(name = "LMS_TEST_SEQUENCE", sequenceName = "LMS_TEST_SEQUENCE", allocationSize = 1)
	@Column(name = "TEST_SEQ_NO")
	private long testSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "TEST_CATEGORY_SEQ_NO")
	private BigDecimal testCategorySeqNo;

	@Column(name = "TEST_ID")
	private String testId;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public LMSTestMaster() {
	}

	public long getTestSeqNo() {
		return this.testSeqNo;
	}

	public void setTestSeqNo(long testSeqNo) {
		this.testSeqNo = testSeqNo;
	}

	public Timestamp getFrDttm() {
		return this.frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
		this.frDttm = frDttm;
	}

	public Long getInstitutionSeqNo() {
		return this.institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public BigDecimal getTestCategorySeqNo() {
		return this.testCategorySeqNo;
	}

	public void setTestCategorySeqNo(BigDecimal testCategorySeqNo) {
		this.testCategorySeqNo = testCategorySeqNo;
	}

	public String getTestId() {
		return this.testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frDttm == null) ? 0 : frDttm.hashCode());
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((testCategorySeqNo == null) ? 0 : testCategorySeqNo.hashCode());
		result = prime * result + ((testId == null) ? 0 : testId.hashCode());
		result = prime * result + (int) (testSeqNo ^ (testSeqNo >>> 32));
		result = prime * result + ((toDttm == null) ? 0 : toDttm.hashCode());
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
		LMSTestMaster other = (LMSTestMaster) obj;
		if (frDttm == null) {
			if (other.frDttm != null)
				return false;
		} else if (!frDttm.equals(other.frDttm))
			return false;
		if (institutionSeqNo == null) {
			if (other.institutionSeqNo != null)
				return false;
		} else if (!institutionSeqNo.equals(other.institutionSeqNo))
			return false;
		if (testCategorySeqNo == null) {
			if (other.testCategorySeqNo != null)
				return false;
		} else if (!testCategorySeqNo.equals(other.testCategorySeqNo))
			return false;
		if (testId == null) {
			if (other.testId != null)
				return false;
		} else if (!testId.equals(other.testId))
			return false;
		if (testSeqNo != other.testSeqNo)
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

	public LMSTestMaster(long testSeqNo, Timestamp frDttm, Long institutionSeqNo, BigDecimal testCategorySeqNo,
			String testId, Timestamp toDttm) {
		super();
		this.testSeqNo = testSeqNo;
		this.frDttm = frDttm;
		this.institutionSeqNo = institutionSeqNo;
		this.testCategorySeqNo = testCategorySeqNo;
		this.testId = testId;
		this.toDttm = toDttm;
	}

}