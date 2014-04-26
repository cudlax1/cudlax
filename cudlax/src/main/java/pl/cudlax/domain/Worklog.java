package pl.cudlax.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ORM reprezentujcy zalogowany czas pracy uzytkownika nad zadaniem
 * 
 * @author Dominik T
 * 
 */
@Entity
@Table(name = "WORKLOG")
public class Worklog {

	@Id
	@GeneratedValue
	@Column(name = "WORKLOG_ID")
	private Long worklogId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_ID")
	private Task task;

	@Column(name = "WORK_DATE")
	private Date workDate;

	@Column(name = "WORK_TIME_IN_MINUTES")
	private Long workTimeInMinutes;

	public Long getWorklogId() {
		return worklogId;
	}

	public void setWorklogId(Long worklogId) {
		this.worklogId = worklogId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public Long getWorkTimeInMinutes() {
		return workTimeInMinutes;
	}

	public void setWorkTimeInMinutes(Long workTimeInMinutes) {
		this.workTimeInMinutes = workTimeInMinutes;
	}

	@Override
	public String toString() {
		return "Worklog [worklogId=" + worklogId + ", user=" + user + ", task="
				+ task + ", workDate=" + workDate + ", workTimeInMinutes="
				+ workTimeInMinutes + "]";
	}

}
