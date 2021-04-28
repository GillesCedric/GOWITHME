package models;

import java.sql.Timestamp;

public class Favorite {
	private int userIdFavoriter;
	private int userIdFavoritee;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Favorite() {
		
	}
	
	public Favorite(int userIdFavoriter, int userIdFavoritee, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.userIdFavoriter = userIdFavoriter;
		this.userIdFavoritee = userIdFavoritee;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getUserIdFavoriter() {
		return userIdFavoriter;
	}


	public void setUserIdFavoriter(int userIdFavoriter) {
		this.userIdFavoriter = userIdFavoriter;
	}


	public int getUserIdFavoritee() {
		return userIdFavoritee;
	}


	public void setUserIdFavoritee(int userIdFavoritee) {
		this.userIdFavoritee = userIdFavoritee;
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
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userIdFavoritee;
		result = prime * result + userIdFavoriter;
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
		Favorite other = (Favorite) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userIdFavoritee != other.userIdFavoritee)
			return false;
		if (userIdFavoriter != other.userIdFavoriter)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Favorite [userIdFavoriter=" + userIdFavoriter + ", userIdFavoritee=" + userIdFavoritee + ", createdAt="
				+ createdAt + ", updateAt=" + updatedAt + "]";
	}
	
	
}
