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
 * ORM reprezentujacy komentarze do zadania
 * 
 * @author Wojciech
 * 
 */

@Entity
@Table(name = "COMMENT")
public class Comment {
	@Id
	@GeneratedValue
	@Column(name = "COMMENT_ID")
	private Long commentId;

	@Column(name = "CONTENT")
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "DATE")
	private Date date;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content
				+ ", user=" + user + ", date=" + date + "]";
	}

}
