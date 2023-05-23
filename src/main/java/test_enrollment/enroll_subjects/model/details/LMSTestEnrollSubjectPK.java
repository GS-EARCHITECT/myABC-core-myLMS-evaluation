package test_enrollment.enroll_subjects.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_TEST_ENROLL_SUBJECTS database table.
 * 
 */
@Embeddable
public class LMSTestEnrollSubjectPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ENROLL_SEQ_NO")
	private long enrollSeqNo;

	@Column(name = "SOURCE_SUBJECT_SEQ_NO")
	private long sourceSubjectSeqNo;

	@Column(name = "TARGET_SUBJECT_SEQ_NO")
	private long targetSubjectSeqNo;

	public LMSTestEnrollSubjectPK() {
	}

	public long getEnrollSeqNo() {
		return this.enrollSeqNo;
	}

	public void setEnrollSeqNo(long enrollSeqNo) {
		this.enrollSeqNo = enrollSeqNo;
	}

	public long getSourceSubjectSeqNo() {
		return this.sourceSubjectSeqNo;
	}

	public void setSourceSubjectSeqNo(long sourceSubjectSeqNo) {
		this.sourceSubjectSeqNo = sourceSubjectSeqNo;
	}

	public long getTargetSubjectSeqNo() {
		return this.targetSubjectSeqNo;
	}

	public void setTargetSubjectSeqNo(long targetSubjectSeqNo) {
		this.targetSubjectSeqNo = targetSubjectSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSTestEnrollSubjectPK)) {
			return false;
		}
		LMSTestEnrollSubjectPK castOther = (LMSTestEnrollSubjectPK) other;
		return (this.enrollSeqNo == castOther.enrollSeqNo) && (this.sourceSubjectSeqNo == castOther.sourceSubjectSeqNo)
				&& (this.targetSubjectSeqNo == castOther.targetSubjectSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.enrollSeqNo ^ (this.enrollSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.sourceSubjectSeqNo ^ (this.sourceSubjectSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.targetSubjectSeqNo ^ (this.targetSubjectSeqNo >>> 32)));

		return hash;
	}

	public LMSTestEnrollSubjectPK(long enrollSeqNo, long sourceSubjectSeqNo, long targetSubjectSeqNo) {
		super();
		this.enrollSeqNo = enrollSeqNo;
		this.sourceSubjectSeqNo = sourceSubjectSeqNo;
		this.targetSubjectSeqNo = targetSubjectSeqNo;
	}

}