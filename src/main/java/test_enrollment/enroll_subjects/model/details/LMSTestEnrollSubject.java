package test_enrollment.enroll_subjects.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_TEST_ENROLL_SUBJECTS database table.
 * 
 */
@Entity
@Table(name = "LMS_TEST_ENROLL_SUBJECTS")
public class LMSTestEnrollSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSTestEnrollSubjectPK id;

	public LMSTestEnrollSubject() {
	}

	public LMSTestEnrollSubjectPK getId() {
		return this.id;
	}

	public void setId(LMSTestEnrollSubjectPK id) {
		this.id = id;
	}

	public LMSTestEnrollSubject(LMSTestEnrollSubjectPK id) {
		super();
		this.id = id;
	}

}