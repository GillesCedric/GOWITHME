package models;

import java.sql.Timestamp;

public class Payment {
	private int id;
	private String state;
	private String reference;
	private int customerId;
	private int seat;
	private int amount;
	private boolean isReceive;
	private Timestamp receiveDate;
	private boolean isRefund;
	private Timestamp refundDate;
	private int userId;
	private int travelId;
	private int payementMethodId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Payment() {
		
	}
	
	public Payment(int id, String state, String reference, int customerId, int seat, int amount, boolean isReceive,
			Timestamp receiveDate, boolean isRefund, Timestamp refundDate, int userId, int travelId,
			int payementMethodId, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.state = state;
		this.reference = reference;
		this.customerId = customerId;
		this.seat = seat;
		this.amount = amount;
		this.isReceive = isReceive;
		this.receiveDate = receiveDate;
		this.isRefund = isRefund;
		this.refundDate = refundDate;
		this.userId = userId;
		this.travelId = travelId;
		this.payementMethodId = payementMethodId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getReference() {
		return reference;
	}


	public void setRefernce(String refernce) {
		this.reference = refernce;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public boolean isReceive() {
		return isReceive;
	}


	public void setReceive(boolean isReceive) {
		this.isReceive = isReceive;
	}


	public Timestamp getReceiveDate() {
		return receiveDate;
	}


	public void setReceiveDate(Timestamp receiveDate) {
		this.receiveDate = receiveDate;
	}


	public boolean isRefund() {
		return isRefund;
	}


	public void setRefund(boolean isRefund) {
		this.isRefund = isRefund;
	}


	public Timestamp getRefundDate() {
		return refundDate;
	}


	public void setRefundDate(Timestamp refundDate) {
		this.refundDate = refundDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTravelId() {
		return travelId;
	}


	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}


	public int getPayementMethodId() {
		return payementMethodId;
	}


	public void setPayementMethodId(int payementMethodId) {
		this.payementMethodId = payementMethodId;
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
		result = prime * result + amount;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + customerId;
		result = prime * result + id;
		result = prime * result + (isReceive ? 1231 : 1237);
		result = prime * result + (isRefund ? 1231 : 1237);
		result = prime * result + payementMethodId;
		result = prime * result + ((receiveDate == null) ? 0 : receiveDate.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((refundDate == null) ? 0 : refundDate.hashCode());
		result = prime * result + seat;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + travelId;
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
		Payment other = (Payment) obj;
		if (amount != other.amount)
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (isReceive != other.isReceive)
			return false;
		if (isRefund != other.isRefund)
			return false;
		if (payementMethodId != other.payementMethodId)
			return false;
		if (receiveDate == null) {
			if (other.receiveDate != null)
				return false;
		} else if (!receiveDate.equals(other.receiveDate))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (refundDate == null) {
			if (other.refundDate != null)
				return false;
		} else if (!refundDate.equals(other.refundDate))
			return false;
		if (seat != other.seat)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (travelId != other.travelId)
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
		return "Payment [id=" + id + ", state=" + state + ", refernce=" + reference + ", customerId=" + customerId
				+ ", seat=" + seat + ", amount=" + amount + ", isReceive=" + isReceive + ", receiveDate=" + receiveDate
				+ ", isRefund=" + isRefund + ", refundDate=" + refundDate + ", userId=" + userId + ", travelId="
				+ travelId + ", payementMethodId=" + payementMethodId + ", createdAt=" + createdAt + ", updateAt="
				+ updatedAt + "]";
	}
	
	
	
}
