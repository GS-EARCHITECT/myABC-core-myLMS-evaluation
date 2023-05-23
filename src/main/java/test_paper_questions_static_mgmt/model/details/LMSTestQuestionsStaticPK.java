package test_paper_questions_static_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_TEST_QUESTIONS_STATIC database table.
 * 
 */
@Embeddable
public class LMSTestQuestionsStaticPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "PAPER_SEQ_NO")
	private long paperSeqNo;

	@Column(name = "Q_SEQ_NO")
	private long qSeqNo;

	public LMSTestQuestionsStaticPK() {
	}

	public long getPaperSeqNo() {
		return this.paperSeqNo;
	}

	public void setPaperSeqNo(long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	public long getQSeqNo() {
		return this.qSeqNo;
	}

	public void setQSeqNo(long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSTestQuestionsStaticPK)) {
			return false;
		}
		LMSTestQuestionsStaticPK castOther = (LMSTestQuestionsStaticPK) other;
		return (this.paperSeqNo == castOther.paperSeqNo) && (this.qSeqNo == castOther.qSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.paperSeqNo ^ (this.paperSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.qSeqNo ^ (this.qSeqNo >>> 32)));

		return hash;
	}

	public LMSTestQuestionsStaticPK(long paperSeqNo, long qSeqNo) {
		super();
		this.paperSeqNo = paperSeqNo;
		this.qSeqNo = qSeqNo;
	}

}