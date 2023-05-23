package test_enrollment.enroll_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_TEST_ENROLL_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_ENROLL_MASTER")
public class LMSTestEnrollMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_TEST_ENROLL_SEQUENCE")
	@SequenceGenerator(name = "LMS_TEST_ENROLL_SEQUENCE", sequenceName = "LMS_TEST_ENROLL_SEQUENCE", allocationSize = 1)
	@Column(name = "ENROLL_SEQ_NO")
	private long enrollSeqNo;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "TEST_SEQ_NO")
	private Long testSeqNo;

	
	public LMSTestEnrollMaster() {
		super();
	}

	public long getEnrollSeqNo() {
		return this.enrollSeqNo;
	}

	public void setEnrollSeqNo(long enrollSeqNo) {
		this.enrollSeqNo = enrollSeqNo;
	}

	public Long getInstitutionSeqNo() {
		return this.institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getTestSeqNo() {
		return this.testSeqNo;
	}

	public void setTestSeqNo(Long testSeqNo) {
		this.testSeqNo = testSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (enrollSeqNo ^ (enrollSeqNo >>> 32));
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((testSeqNo == null) ? 0 : testSeqNo.hashCode());
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
		LMSTestEnrollMaster other = (LMSTestEnrollMaster) obj;
		if (enrollSeqNo != other.enrollSeqNo)
			return false;
		if (institutionSeqNo == null) {
			if (other.institutionSeqNo != null)
				return false;
		} else if (!institutionSeqNo.equals(other.institutionSeqNo))
			return false;
		if (testSeqNo == null) {
			if (other.testSeqNo != null)
				return false;
		} else if (!testSeqNo.equals(other.testSeqNo))
			return false;
		return true;
	}

	public LMSTestEnrollMaster(long enrollSeqNo, Long institutionSeqNo, Long testSeqNo) {
		super();
		this.enrollSeqNo = enrollSeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.testSeqNo = testSeqNo;
	}

}