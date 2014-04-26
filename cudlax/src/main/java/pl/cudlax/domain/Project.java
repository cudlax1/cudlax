package pl.cudlax.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/**
 * ORM reprezentujcy projekt
 * @author Dominik T
 *
 */

@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	@GeneratedValue
	@Column(name = "PROJECT_ID")
	private Long projectId;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEADER_ID")
	private User leader;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "DADLINE")
	private Date deadline;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PROJECT_ID")
	@IndexColumn(name = "TASK_ID")
	private List<Task> taskList;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PROJECT_ID")
	@IndexColumn(name = "USER_ID")
	private List<User> usersList;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name
				+ ", description=" + description + ", leader=" + leader
				+ ", createDate=" + createDate + ", deadline=" + deadline
				+ ", taskList=" + taskList + ", usersList=" + usersList + "]";
	}

	

}
