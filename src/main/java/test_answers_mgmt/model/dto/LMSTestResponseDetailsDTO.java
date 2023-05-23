package test_answers_mgmt.model.dto;

import java.io.Serializable;

public class LMSTestResponseDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6969869950189621080L;
	private long testRollNumber;
	private long qSeqNo;
	private long paperSeqNo;
	private String blankTxt1;
	private String blankTxt2;
	private String blankTxt3;
	private String blankTxt4;
	private String blankTxt5;
	private String blankTxt6;
	private String blankTxt7;
	private Character choiceFlg1;
	private Character choiceFlg2;
	private Character choiceFlg3;
	private Character choiceFlg4;
	private Character choiceFlg5;
	private Character choiceFlg6;
	private Character choiceFlg7;
	private String paragraphTxt;

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

	public String getBlankTxt1() {
		return blankTxt1;
	}

	public void setBlankTxt1(String blankTxt1) {
		this.blankTxt1 = blankTxt1;
	}

	public String getBlankTxt2() {
		return blankTxt2;
	}

	public void setBlankTxt2(String blankTxt2) {
		this.blankTxt2 = blankTxt2;
	}

	public String getBlankTxt3() {
		return blankTxt3;
	}

	public void setBlankTxt3(String blankTxt3) {
		this.blankTxt3 = blankTxt3;
	}

	public String getBlankTxt4() {
		return blankTxt4;
	}

	public void setBlankTxt4(String blankTxt4) {
		this.blankTxt4 = blankTxt4;
	}

	public String getBlankTxt5() {
		return blankTxt5;
	}

	public void setBlankTxt5(String blankTxt5) {
		this.blankTxt5 = blankTxt5;
	}

	public String getBlankTxt6() {
		return blankTxt6;
	}

	public void setBlankTxt6(String blankTxt6) {
		this.blankTxt6 = blankTxt6;
	}

	public String getBlankTxt7() {
		return blankTxt7;
	}

	public void setBlankTxt7(String blankTxt7) {
		this.blankTxt7 = blankTxt7;
	}

	public Character getChoiceFlg1() {
		return choiceFlg1;
	}

	public void setChoiceFlg1(Character choiceFlg1) {
		this.choiceFlg1 = choiceFlg1;
	}

	public Character getChoiceFlg2() {
		return choiceFlg2;
	}

	public void setChoiceFlg2(Character choiceFlg2) {
		this.choiceFlg2 = choiceFlg2;
	}

	public Character getChoiceFlg3() {
		return choiceFlg3;
	}

	public void setChoiceFlg3(Character choiceFlg3) {
		this.choiceFlg3 = choiceFlg3;
	}

	public Character getChoiceFlg4() {
		return choiceFlg4;
	}

	public void setChoiceFlg4(Character choiceFlg4) {
		this.choiceFlg4 = choiceFlg4;
	}

	public Character getChoiceFlg5() {
		return choiceFlg5;
	}

	public void setChoiceFlg5(Character choiceFlg5) {
		this.choiceFlg5 = choiceFlg5;
	}

	public Character getChoiceFlg6() {
		return choiceFlg6;
	}

	public void setChoiceFlg6(Character choiceFlg6) {
		this.choiceFlg6 = choiceFlg6;
	}

	public Character getChoiceFlg7() {
		return choiceFlg7;
	}

	public void setChoiceFlg7(Character choiceFlg7) {
		this.choiceFlg7 = choiceFlg7;
	}

	public String getParagraphTxt() {
		return paragraphTxt;
	}

	public void setParagraphTxt(String paragraphTxt) {
		this.paragraphTxt = paragraphTxt;
	}

	public LMSTestResponseDetailsDTO(long testRollNumber, long qSeqNo, long paperSeqNo, String blankTxt1,
			String blankTxt2, String blankTxt3, String blankTxt4, String blankTxt5, String blankTxt6, String blankTxt7,
			Character choiceFlg1, Character choiceFlg2, Character choiceFlg3, Character choiceFlg4,
			Character choiceFlg5, Character choiceFlg6, Character choiceFlg7, String paragraphTxt) {
		super();
		this.testRollNumber = testRollNumber;
		this.qSeqNo = qSeqNo;
		this.paperSeqNo = paperSeqNo;
		this.blankTxt1 = blankTxt1;
		this.blankTxt2 = blankTxt2;
		this.blankTxt3 = blankTxt3;
		this.blankTxt4 = blankTxt4;
		this.blankTxt5 = blankTxt5;
		this.blankTxt6 = blankTxt6;
		this.blankTxt7 = blankTxt7;
		this.choiceFlg1 = choiceFlg1;
		this.choiceFlg2 = choiceFlg2;
		this.choiceFlg3 = choiceFlg3;
		this.choiceFlg4 = choiceFlg4;
		this.choiceFlg5 = choiceFlg5;
		this.choiceFlg6 = choiceFlg6;
		this.choiceFlg7 = choiceFlg7;
		this.paragraphTxt = paragraphTxt;
	}

	public LMSTestResponseDetailsDTO() {
		super();
	}

}