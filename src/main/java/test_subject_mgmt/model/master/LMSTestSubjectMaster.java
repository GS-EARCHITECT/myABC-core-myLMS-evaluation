package test_subject_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the LMS_TEST_SUBJECT_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_SUBJECT_MASTER")
public class LMSTestSubjectMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_TEST_SUBJECT_SEQUENCE")
	@SequenceGenerator(name = "LMS_TEST_SUBJECT_SEQUENCE", sequenceName = "LMS_TEST_SUBJECT_SEQUENCE", allocationSize = 1)
	@Column(name = "TEST_SCHEDULE_SEQ_NO")
	private long testScheduleSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "PAPER_SEQ_NO")
	private Long paperSeqNo;

	@Column(name = "SUBJECT_SEQ_NO")
	private Long subjectSeqNo;

	@Column(name = "TEST_SEQ_NO")
	private Long testSeqNo;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public LMSTestSubjectMaster() {
	}

	public long getTestScheduleSeqNo() {
		return this.testScheduleSeqNo;
	}

	public void setTestScheduleSeqNo(long testScheduleSeqNo) {
		this.testScheduleSeqNo = testScheduleSeqNo;
	}

	public Timestamp getFrDttm() {
		return this.frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
		this.frDttm = frDttm;
	}

	public Long getPaperSeqNo() {
		return this.paperSeqNo;
	}

	public void setPaperSeqNo(Long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	public Long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public Long getTestSeqNo() {
		return this.testSeqNo;
	}

	public void setTestSeqNo(Long testSeqNo) {
		this.testSeqNo = testSeqNo;
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
		result = prime * result + ((paperSeqNo == null) ? 0 : paperSeqNo.hashCode());
		result = prime * result + ((subjectSeqNo == null) ? 0 : subjectSeqNo.hashCode());
		result = prime * result + (int) (testScheduleSeqNo ^ (testScheduleSeqNo >>> 32));
		result = prime * result + ((testSeqNo == null) ? 0 : testSeqNo.hashCode());
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
		LMSTestSubjectMaster other = (LMSTestSubjectMaster) obj;
		if (frDttm == null) {
			if (other.frDttm != null)
				return false;
		} else if (!frDttm.equals(other.frDttm))
			return false;
		if (paperSeqNo == null) {
			if (other.paperSeqNo != null)
				return false;
		} else if (!paperSeqNo.equals(other.paperSeqNo))
			return false;
		if (subjectSeqNo == null) {
			if (other.subjectSeqNo != null)
				return false;
		} else if (!subjectSeqNo.equals(other.subjectSeqNo))
			return false;
		if (testScheduleSeqNo != other.testScheduleSeqNo)
			return false;
		if (testSeqNo == null) {
			if (other.testSeqNo != null)
				return false;
		} else if (!testSeqNo.equals(other.testSeqNo))
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

	public LMSTestSubjectMaster(long testScheduleSeqNo, Timestamp frDttm, Long paperSeqNo, Long subjectSeqNo,
			Long testSeqNo, Timestamp toDttm) {
		super();
		this.testScheduleSeqNo = testScheduleSeqNo;
		this.frDttm = frDttm;
		this.paperSeqNo = paperSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.testSeqNo = testSeqNo;
		this.toDttm = toDttm;
	}

}