package models;

import java.sql.Timestamp;

import utilities.Type;

public class Identifier {
	private int id;
	private Type type;
	private boolean isVerified;
	private Timestamp VerifiedDate;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int userId;
	
	
	public Identifier(int id, Type type, boolean isVerified, Timestamp verifiedDate, Timestamp createdAt,
			Timestamp updatedAt, int userId) {
		super();
		this.id = id;
		this.type = type;
		this.isVerified = isVerified;
		VerifiedDate = verifiedDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = userId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public boolean isVerified() {
		return isVerified;
	}


	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


	public Timestamp getVerifiedDate() {
		return VerifiedDate;
	}


	public void setVerifiedDate(Timestamp verifiedDate) {
		VerifiedDate = verifiedDate;
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


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VerifiedDate == null) ? 0 : VerifiedDate.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + (isVerified ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Identifier other = (Identifier) obj;
		if (VerifiedDate == null) {
			if (other.VerifiedDate != null)
				return false;
		} else if (!VerifiedDate.equals(other.VerifiedDate))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (isVerified != other.isVerified)
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
		return true;
	}


	@Override
	public String toString() {
		return "Identifier [id=" + id + ", type=" + type + ", isVerified=" + isVerified + ", VerifiedDate="
				+ VerifiedDate + ", createdAt=" + createdAt + ", updateAt=" + updatedAt + ", userId=" + userId + "]";
	}
	
	

}
