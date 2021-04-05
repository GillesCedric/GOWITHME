package models;

import java.sql.Timestamp;

public class Stripe {
	private int id;
	private int number;
	private int expirationMonth;
	private int expirationYear;
	private int cvv;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	
	public Stripe(int id, int number, int expirationMonth, int expirationYear, int cvv, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getId() {
		return id;
	}


	public int getNumber() {
		return number;
	}


	public int getExpirationMonth() {
		return expirationMonth;
	}


	public int getExpirationYear() {
		return expirationYear;
	}


	public int getCvv() {
		return cvv;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}


	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + cvv;
		result = prime * result + expirationMonth;
		result = prime * result + expirationYear;
		result = prime * result + id;
		result = prime * result + number;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Stripe other = (Stripe) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (cvv != other.cvv)
			return false;
		if (expirationMonth != other.expirationMonth)
			return false;
		if (expirationYear != other.expirationYear)
			return false;
		if (id != other.id)
			return false;
		if (number != other.number)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Stripe [id=" + id + ", number=" + number + ", expirationMonth=" + expirationMonth + ", expirationYear="
				+ expirationYear + ", cvv=" + cvv + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	

}
