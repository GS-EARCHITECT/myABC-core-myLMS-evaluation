package test_answers_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_TEST_RESPONSE_DETAILS database table.
 * 
 */
@Embeddable
public class LMSTestResponseDetailsPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "TEST_ROLL_NUMBER")
	private long testRollNumber;

	@Column(name = "Q_SEQ_NO")
	private long qSeqNo;

	@Column(name = "PAPER_SEQ_NO")
	private long paperSeqNo;

	public LMSTestResponseDetailsPK() {
	}

	public long getTestRollNumber() {
		return testRollNumber;
	}

	public void setTestRollNumber(long testRollNumber) {
		this.testRollNumber = testRollNumber;
	}

	public long getqSeqNo() {
		return qSeqNo;
	}

	public void setqSeqNo(long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public long getPaperSeqNo() {
		return paperSeqNo;
	}

	public void setPaperSeqNo(long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (paperSeqNo ^ (paperSeqNo >>> 32));
		result = prime * result + (int) (qSeqNo ^ (qSeqNo >>> 32));
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
		LMSTestResponseDetailsPK other = (LMSTestResponseDetailsPK) obj;
		if (paperSeqNo != other.paperSeqNo)
			return false;
		if (qSeqNo != other.qSeqNo)
			return false;
		if (testRollNumber != other.testRollNumber)
			return false;
		return true;
	}

	public LMSTestResponseDetailsPK(long testRollNumber, long qSeqNo, long paperSeqNo) {
		super();
		this.testRollNumber = testRollNumber;
		this.qSeqNo = qSeqNo;
		this.paperSeqNo = paperSeqNo;
	}

}