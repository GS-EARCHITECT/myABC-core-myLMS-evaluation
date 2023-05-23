package test_paper_questions_static_mgmt.model.details;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_TEST_QUESTIONS_STATIC database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_QUESTIONS_STATIC")
public class LMSTestQuestionsStatic implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSTestQuestionsStaticPK id;

	@Column(name = "MARKS")
	private Float marks;

	@Column(name = "QUESTION_NO")
	private BigDecimal questionNo;

	@Column(name = "WEIGHTAGE")
	private Float weightage;

	public LMSTestQuestionsStatic() {
	}

	public LMSTestQuestionsStaticPK getId() {
		return id;
	}

	public void setId(LMSTestQuestionsStaticPK id) {
		this.id = id;
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

	public LMSTestQuestionsStatic(LMSTestQuestionsStaticPK id, Float marks, BigDecimal questionNo, Float weightage) {
		super();
		this.id = id;
		this.marks = marks;
		this.questionNo = questionNo;	
		this.weightage = weightage;
	}

}