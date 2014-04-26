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
 * ORM  reprezentujcy Zadanie
 * @author Dominik T
 *
 */
@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@GeneratedValue
	@Column(name = "TASK_ID")
	private Long taskId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATIONDATE")
	private Date creationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATOR_ID")
	private User creator;

	@Column(name = "STATUS")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User owner;

	@Column(name = "DEADLINE")
	private Date deadline;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TASK_ID")
	@IndexColumn(name = "COMMENT_ID")
	private List<Comment> commentList;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", creationDate="
				+ creationDate + ", creator=" + creator + ", status=" + status
				+ ", owner=" + owner + ", deadline=" + deadline
				+ ", commentList=" + commentList + "]";
	}

}
