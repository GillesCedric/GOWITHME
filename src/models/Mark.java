package models;

import java.sql.Timestamp;

public class Mark {
	private int userIdMaker;
	private int userIdMakee;
	private double mark;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Mark() {
		
	}
	
	public Mark(int userIdMaker, int userIdMakee, double mark, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.userIdMaker = userIdMaker;
		this.userIdMakee = userIdMakee;
		this.mark = mark;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getUserIdMaker() {
		return userIdMaker;
	}


	public void setUserIdMaker(int userIdMaker) {
		this.userIdMaker = userIdMaker;
	}


	public int getUserIdMakee() {
		return userIdMakee;
	}


	public void setUserIdMakee(int userIdMakee) {
		this.userIdMakee = userIdMakee;
	}


	public double getMark() {
		return mark;
	}


	public void setMark(double mark) {
		this.mark = mark;
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
		long temp;
		temp = Double.doubleToLongBits(mark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + userIdMakee;
		result = prime * result + userIdMaker;
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
		Mark other = (Mark) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (Double.doubleToLongBits(mark) != Double.doubleToLongBits(other.mark))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userIdMakee != other.userIdMakee)
			return false;
		if (userIdMaker != other.userIdMaker)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Mark [userIdMaker=" + userIdMaker + ", userIdMakee=" + userIdMakee + ", mark=" + mark + ", createdAt="
				+ createdAt + ", updateAt=" + updatedAt + "]";
	}
	
	
	

}
