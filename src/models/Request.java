package models;

import java.io.File;
import java.sql.Timestamp;

public class Request {
	private int id;
	private String object;
	private String message;
	private File logFile;
	private int userId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Request() {
		
	}
	
	public Request(String object, String message, File logFile, int userId, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.object = object;
		this.message = message;
		this.logFile = logFile;
		this.userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Request(int id, String object, String message, File logFile, int userId, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.object = object;
		this.message = message;
		this.logFile = logFile;
		this.userId = userId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getObject() {
		return object;
	}


	public void setObject(String object) {
		this.object = object;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public File getLogFile() {
		return logFile;
	}


	public void setLogFile(File logFile) {
		this.logFile = logFile;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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
		result = prime * result + id;
		result = prime * result + ((logFile == null) ? 0 : logFile.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userId;
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
		Request other = (Request) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (logFile == null) {
			if (other.logFile != null)
				return false;
		} else if (!logFile.equals(other.logFile))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Request [id=" + id + ", object=" + object + ", message=" + message + ", logFile=" + logFile
				+ ", userId=" + userId + ", createdAt=" + createdAt + ", updateAt=" + updatedAt + "]";
	}
	
	
	
	
	
}
