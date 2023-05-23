package test_paper_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSTestPaperMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321745780599888959L;
	private long paperSeqNo;
	private String paperId;
	private String paperTitle;
	private Long subjectSeqNo;
	private long evaluatorSeqNo;
	private String evaluatorId;
	private BigDecimal marks;
	private BigDecimal weightage;
	private String frDtTm;
	private String toDtTm;

	public long getPaperSeqNo() {
		return paperSeqNo;
	}

	public void setPaperSeqNo(long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
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

	public String getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(String frDtTm) {
		this.frDtTm = frDtTm;
	}

	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

	public LMSTestPaperMasterDTO(long paperSeqNo, String paperId, String paperTitle, Long subjectSeqNo,
			long evaluatorSeqNo, String evaluatorId, BigDecimal marks, BigDecimal weightage, String frDtTm,
			String toDtTm) {
		super();
		this.paperSeqNo = paperSeqNo;
		this.paperId = paperId;
		this.paperTitle = paperTitle;
		this.subjectSeqNo = subjectSeqNo;
		this.evaluatorSeqNo = evaluatorSeqNo;
		this.evaluatorId = evaluatorId;
		this.marks = marks;
		this.weightage = weightage;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
	}

	public LMSTestPaperMasterDTO() {
		super();
	}

}