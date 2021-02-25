package models;

import java.io.File;

public class Request {
	private int id;
	private String object;
	private String message;
	private File logFile;
	private int userId;
	
	/**
	 * @param object
	 * @param message
	 * @param logFile
	 * @param userId
	 */
	public Request(String object, String message, File logFile, int userId) {
		this.object = object;
		this.message = message;
		this.logFile = logFile;
		this.userId = userId;
	}

	/**
	 * @param id
	 * @param object
	 * @param message
	 * @param logFile
	 * @param userId
	 */
	public Request(int id, String object, String message, File logFile, int userId) {
		this.id = id;
		this.object = object;
		this.message = message;
		this.logFile = logFile;
		this.userId = userId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the object
	 */
	public String getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(String object) {
		this.object = object;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the logFile
	 */
	public File getLogFile() {
		return logFile;
	}

	/**
	 * @param logFile the logFile to set
	 */
	public void setLogFile(File logFile) {
		this.logFile = logFile;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((logFile == null) ? 0 : logFile.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
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
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
