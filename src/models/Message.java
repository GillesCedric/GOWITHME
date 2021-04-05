package models;

import java.sql.Timestamp;

public class Message {
	private int userIdMessager;
	private int userIdMessagee;
	private String message;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
	public Message(int userIdMessager, int userIdMessagee, String message, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.userIdMessager = userIdMessager;
		this.userIdMessagee = userIdMessagee;
		this.message = message;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getUserIdMessager() {
		return userIdMessager;
	}


	public void setUserIdMessager(int userIdMessager) {
		this.userIdMessager = userIdMessager;
	}


	public int getUserIdMessagee() {
		return userIdMessagee;
	}


	public void setUserIdMessagee(int userIdMessagee) {
		this.userIdMessagee = userIdMessagee;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdateAt(Timestamp updateAt) {
		this.updatedAt = updateAt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userIdMessagee;
		result = prime * result + userIdMessager;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userIdMessagee != other.userIdMessagee)
			return false;
		if (userIdMessager != other.userIdMessager)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Message [userIdMessager=" + userIdMessager + ", usedrIdMessagee=" + userIdMessagee + ", message="
				+ message + ", createdAt=" + createdAt + ", updateAt=" + updatedAt + "]";
	}
	
	

}
