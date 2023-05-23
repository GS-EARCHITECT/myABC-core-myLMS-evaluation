package test_batch_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_TEST_BATCH_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_BATCH_MASTER")
public class LMSTestBatchMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_TEST_ROLL_NUMBER")
	@SequenceGenerator(name = "LMS_TEST_ROLL_NUMBER", sequenceName = "LMS_TEST_ROLL_NUMBER", allocationSize = 1)
	@Column(name = "TEST_ROLL_NUMBER")
	private long testRollNumber;

	@Column(name = "ENOLL_SEQ_NO")
	private Long enollSeqNo;

	@Column(name = "SOURCE_STUDENT_SEQ_NO")
	private Long sourceStudentSeqNo;

	public LMSTestBatchMaster() {
	}

	public long getTestRollNumber() {
		return this.testRollNumber;
	}

	public void setTestRollNumber(long testRollNumber) {
		this.testRollNumber = testRollNumber;
	}

	public Long getEnollSeqNo() {
		return this.enollSeqNo;
	}

	public void setEnollSeqNo(Long enollSeqNo) {
		this.enollSeqNo = enollSeqNo;
	}

	public Long getSourceStudentSeqNo() {
		return this.sourceStudentSeqNo;
	}

	public void setSourceStudentSeqNo(Long sourceStudentSeqNo) {
		this.sourceStudentSeqNo = sourceStudentSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enollSeqNo == null) ? 0 : enollSeqNo.hashCode());
		result = prime * result + ((sourceStudentSeqNo == null) ? 0 : sourceStudentSeqNo.hashCode());
		result = prime * result + (int) (testRollNumber ^ (testRollNumber >>> 32));
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
		LMSTestBatchMaster other = (LMSTestBatchMaster) obj;
		if (enollSeqNo == null) {
			if (other.enollSeqNo != null)
				return false;
		} else if (!enollSeqNo.equals(other.enollSeqNo))
			return false;
		if (sourceStudentSeqNo == null) {
			if (other.sourceStudentSeqNo != null)
				return false;
		} else if (!sourceStudentSeqNo.equals(other.sourceStudentSeqNo))
			return false;
		if (testRollNumber != other.testRollNumber)
			return false;
		return true;
	}

	public LMSTestBatchMaster(long testRollNumber, Long enollSeqNo, Long sourceStudentSeqNo) {
		super();
		this.testRollNumber = testRollNumber;
		this.enollSeqNo = enollSeqNo;
		this.sourceStudentSeqNo = sourceStudentSeqNo;
	}

}