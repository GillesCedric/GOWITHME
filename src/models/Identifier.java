package models;

import java.sql.Timestamp;

import utilities.IdentifierType;

public class Identifier {
	private int id;
	private IdentifierType type;
	private String identifier;
	private boolean isVerified;
	private Timestamp verifiedDate;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int userId;
	
	public Identifier() {
		
	}
	
	
	public Identifier(IdentifierType type, String identifier, int userId) {
		this.type = type;
		this.identifier = identifier;
		this.userId = userId;
	}


	/**
	 * @param id
	 * @param type
	 * @param identifier
	 * @param isVerified
	 * @param verifiedDate
	 * @param createdAt
	 * @param updatedAt
	 * @param userId
	 */
	public Identifier(int id, IdentifierType type, String identifier, boolean isVerified, Timestamp verifiedDate,
			Timestamp createdAt, Timestamp updatedAt, int userId) {
		this.id = id;
		this.type = type;
		this.identifier = identifier;
		this.isVerified = isVerified;
		this.verifiedDate = verifiedDate;
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


	public IdentifierType getType() {
		return type;
	}


	public void setType(IdentifierType type) {
		this.type = type;
	}


	public boolean isVerified() {
		return isVerified;
	}


	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


	public Timestamp getverifiedDate() {
		return verifiedDate;
	}


	public void setverifiedDate(Timestamp verifiedDate) {
		this.verifiedDate = verifiedDate;
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



	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}



	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}



	/**
	 * @return the verifiedDate
	 */
	public Timestamp getVerifiedDate() {
		return verifiedDate;
	}



	/**
	 * @param verifiedDate the verifiedDate to set
	 */
	public void setVerifiedDate(Timestamp verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (isVerified ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userId;
		result = prime * result + ((verifiedDate == null) ? 0 : verifiedDate.hashCode());
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
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
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
		if (verifiedDate == null) {
			if (other.verifiedDate != null)
				return false;
		} else if (!verifiedDate.equals(other.verifiedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Identifier [id=" + id + ", type=" + type + ", identifier=" + identifier + ", isVerified=" + isVerified
				+ ", verifiedDate=" + verifiedDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", userId=" + userId + "]";
	}
	
}
