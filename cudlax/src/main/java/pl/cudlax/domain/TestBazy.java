package pl.cudlax.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_BAZY")
public class TestBazy implements Serializable {

	private static final long serialVersionUID = 7152867378686902077L;

	@Id
	@GeneratedValue
	@Column(name = "TEST_ID")
	private Long testId;

	@Column(name = "TEST")
	public String test;

	public String getTest() {
		return test;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "TestBazy [test=" + test + "]";
	}

}
