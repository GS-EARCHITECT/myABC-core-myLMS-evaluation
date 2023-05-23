package test_batch_mgmt.model.dto;

import java.io.Serializable;

public class LMSTestBatchMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6455930370910643557L;
	private long testRollNumber;
	private Long enollSeqNo;
	private Long sourceStudentSeqNo;

	public long getTestRollNumber() {
		return testRollNumber;
	}

	public void setTestRollNumber(long testRollNumber) {
		this.testRollNumber = testRollNumber;
	}

	public Long getEnollSeqNo() {
		return enollSeqNo;
	}

	public void setEnollSeqNo(Long enollSeqNo) {
		this.enollSeqNo = enollSeqNo;
	}

	public Long getSourceStudentSeqNo() {
		return sourceStudentSeqNo;
	}

	public void setSourceStudentSeqNo(Long sourceStudentSeqNo) {
		this.sourceStudentSeqNo = sourceStudentSeqNo;
	}

	public LMSTestBatchMasterDTO(long testRollNumber, Long enollSeqNo, Long sourceStudentSeqNo) {
		super();
		this.testRollNumber = testRollNumber;
		this.enollSeqNo = enollSeqNo;
		this.sourceStudentSeqNo = sourceStudentSeqNo;
	}

	public LMSTestBatchMasterDTO() {
		super();
	}

}