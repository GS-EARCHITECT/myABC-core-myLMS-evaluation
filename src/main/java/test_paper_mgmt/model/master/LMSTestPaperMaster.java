package test_paper_mgmt.model.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;


/**
 * The persistent class for the LMS_TEST_PAPER_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_PAPER_MASTER")
public class LMSTestPaperMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_PAPER_SEQUENCE")
	@SequenceGenerator(name = "LMS_PAPER_SEQUENCE", sequenceName = "LMS_PAPER_SEQUENCE", allocationSize = 1)
	@Column(name = "PAPER_SEQ_NO")
	private long paperSeqNo;

	@Column(name = "EVALUATOR_SEQ_NO")
	private long evaluatorSeqNo;

	@Column(name = "EVALUATOR_ID")
	private String evaluatorId;

	@Column(name = "PAPER_ID")
	private String paperId;

	@Column(name = "PAPER_TITLE")
	private String paperTitle;

	@Column(name = "SUBJECT_SEQ_NO")
	private Long subjectSeqNo;

	@Column(name = "MARKS")
	private BigDecimal marks;

	@Column(name = "WEIGHTAGE")
	private BigDecimal weightage;

	@Column(name = "FR_DTTM")
	private Timestamp frDtTm;

	@Column(name = "TO_DTTM")
	private Timestamp toDtTm;

	public LMSTestPaperMaster() {
	}

	public long getPaperSeqNo() {
		return paperSeqNo;
	}

	public void setPaperSeqNo(long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	public long getEvaluatorSeqNo() {
		return evaluatorSeqNo;
	}

	public void setEvaluatorSeqNo(long evaluatorSeqNo) {
		this.evaluatorSeqNo = evaluatorSeqNo;
	}

	public String getEvaluatorId() {
		return evaluatorId;
	}

	public void setEvaluatorId(String evaluatorId) {
		this.evaluatorId = evaluatorId;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public Long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public BigDecimal getMarks() {
		return marks;
	}

	public void setMarks(BigDecimal marks) {
		this.marks = marks;
	}

	public BigDecimal getWeightage() {
		return weightage;
	}

	public void setWeightage(BigDecimal weightage) {
		this.weightage = weightage;
	}

	public Timestamp getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(Timestamp frDtTm) {
		this.frDtTm = frDtTm;
	}

	public Timestamp getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(Timestamp toDtTm) {
		this.toDtTm = toDtTm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evaluatorId == null) ? 0 : evaluatorId.hashCode());
		result = prime * result + (int) (evaluatorSeqNo ^ (evaluatorSeqNo >>> 32));
		result = prime * result + ((frDtTm == null) ? 0 : frDtTm.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((paperId == null) ? 0 : paperId.hashCode());
		result = prime * result + (int) (paperSeqNo ^ (paperSeqNo >>> 32));
		result = prime * result + ((paperTitle == null) ? 0 : paperTitle.hashCode());
		result = prime * result + ((subjectSeqNo == null) ? 0 : subjectSeqNo.hashCode());
		result = prime * result + ((toDtTm == null) ? 0 : toDtTm.hashCode());
		result = prime * result + ((weightage == null) ? 0 : weightage.hashCode());
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
		LMSTestPaperMaster other = (LMSTestPaperMaster) obj;
		if (evaluatorId == null) {
			if (other.evaluatorId != null)
				return false;
		} else if (!evaluatorId.equals(other.evaluatorId))
			return false;
		if (evaluatorSeqNo != other.evaluatorSeqNo)
			return false;
		if (frDtTm == null) {
			if (other.frDtTm != null)
				return false;
		} else if (!frDtTm.equals(other.frDtTm))
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
			return false;
		if (paperId == null) {
			if (other.paperId != null)
				return false;
		} else if (!paperId.equals(other.paperId))
			return false;
		if (paperSeqNo != other.paperSeqNo)
			return false;
		if (paperTitle == null) {
			if (other.paperTitle != null)
				return false;
		} else if (!paperTitle.equals(other.paperTitle))
			return false;
		if (subjectSeqNo == null) {
			if (other.subjectSeqNo != null)
				return false;
		} else if (!subjectSeqNo.equals(other.subjectSeqNo))
			return false;
		if (toDtTm == null) {
			if (other.toDtTm != null)
				return false;
		} else if (!toDtTm.equals(other.toDtTm))
			return false;
		if (weightage == null) {
			if (other.weightage != null)
				return false;
		} else if (!weightage.equals(other.weightage))
			return false;
		return true;
	}

	public LMSTestPaperMaster(long paperSeqNo, long evaluatorSeqNo, String evaluatorId, String paperId,
			String paperTitle, Long subjectSeqNo, BigDecimal marks, BigDecimal weightage, Timestamp frDtTm,
			Timestamp toDtTm) {
		super();
		this.paperSeqNo = paperSeqNo;
		this.evaluatorSeqNo = evaluatorSeqNo;
		this.evaluatorId = evaluatorId;
		this.paperId = paperId;
		this.paperTitle = paperTitle;
		this.subjectSeqNo = subjectSeqNo;
		this.marks = marks;
		this.weightage = weightage;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
	}

}