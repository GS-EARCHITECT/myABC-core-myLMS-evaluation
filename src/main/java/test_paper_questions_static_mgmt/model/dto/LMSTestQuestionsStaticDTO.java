package test_paper_questions_static_mgmt.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSTestQuestionsStaticDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3513052238367470280L;
	private long paperSeqNo;
	private long qSeqNo;
	private Float marks;
	private BigDecimal questionNo;
	private Float weightage;

	public long getPaperSeqNo() {
		return paperSeqNo;
	}

	public void setPaperSeqNo(long paperSeqNo) {
		this.paperSeqNo = paperSeqNo;
	}

	public long getqSeqNo() {
		return qSeqNo;
	}

	public void setqSeqNo(long qSeqNo) {
		this.qSeqNo = qSeqNo;
	}

	public Float getMarks() {
		return marks;
	}

	public void setMarks(Float marks) {
		this.marks = marks;
	}

	public BigDecimal getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(BigDecimal questionNo) {
		this.questionNo = questionNo;
	}

	public Float getWeightage() {
		return weightage;
	}

	public void setWeightage(Float weightage) {
		this.weightage = weightage;
	}

	public LMSTestQuestionsStaticDTO(long paperSeqNo, long qSeqNo, Float marks, BigDecimal questionNo,
			Float weightage) {
		super();
		this.paperSeqNo = paperSeqNo;
		this.qSeqNo = qSeqNo;
		this.marks = marks;
		this.questionNo = questionNo;
		this.weightage = weightage;
	}

	public LMSTestQuestionsStaticDTO() {
		super();
	}

}