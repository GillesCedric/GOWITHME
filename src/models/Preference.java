package models;

import java.sql.Timestamp;

import utilities.PreferenceType;

public class Preference {
	private int id;
	private PreferenceType type;
	private boolean value;
	private int userId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Preference() {
		
	}
	
	public Preference(int id, PreferenceType type, boolean value, int userId, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.type = type;
		this.value = value;
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


	public PreferenceType getType() {
		return type;
	}


	public void setType(PreferenceType type) {
		this.type = type;
	}


	public boolean isValue() {
		return value;
	}


	public void setValue(boolean value) {
		this.value = value;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userId;
		result = prime * result + (value ? 1231 : 1237);
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
		Preference other = (Preference) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userId != other.userId)
			return false;
		if (value != other.value)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Preference [id=" + id + ", type=" + type + ", value=" + value + ", userId=" + userId + ", createdAt="
				+ createdAt + ", updateAt=" + updatedAt + "]";
	}
	
	
	
}
