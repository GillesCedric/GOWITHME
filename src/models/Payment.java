package models;

import java.sql.Date;
import java.sql.Time;

public class Payment {
	private int id;
	private String mode;
	private boolean state;
	private int amount;
	private Date date;
	private Time time;
	private String reference;
	private int userId;
	private int travelId;
	/**
	 * @param mode
	 * @param state
	 * @param amount
	 * @param date
	 * @param time
	 * @param reference
	 * @param userId
	 * @param travelId
	 */
	public Payment(String mode, boolean state, int amount, Date date, Time time, String reference, int userId,
			int travelId) {
		this.mode = mode;
		this.state = state;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.reference = reference;
		this.userId = userId;
		this.travelId = travelId;
	}
	/**
	 * @param id
	 * @param mode
	 * @param state
	 * @param amount
	 * @param date
	 * @param time
	 * @param reference
	 * @param userId
	 * @param travelId
	 */
	public Payment(int id, String mode, boolean state, int amount, Date date, Time time, String reference, int userId,
			int travelId) {
		this.id = id;
		this.mode = mode;
		this.state = state;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.reference = reference;
		this.userId = userId;
		this.travelId = travelId;
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
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
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
	/**
	 * @return the travelId
	 */
	public int getTravelId() {
		return travelId;
	}
	/**
	 * @param travelId the travelId to set
	 */
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", mode=" + mode + ", state=" + state + ", amount=" + amount + ", date=" + date
				+ ", time=" + time + ", reference=" + reference + ", userId=" + userId + ", travelId=" + travelId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + (state ? 1231 : 1237);
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + travelId;
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
		Payment other = (Payment) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (state != other.state)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (travelId != other.travelId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
}
