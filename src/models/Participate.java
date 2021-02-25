package models;

public class Participate {
	private int id;
	private int seats;
	private int mark;
	private String comments;
	private int userId;
	private int travelId;
	/**
	 * @param seats
	 * @param mark
	 * @param comments
	 * @param userId
	 * @param travelId
	 */
	public Participate(int seats, int mark, String comments, int userId, int travelId) {
		this.seats = seats;
		this.mark = mark;
		this.comments = comments;
		this.userId = userId;
		this.travelId = travelId;
	}
	/**
	 * @param id
	 * @param seats
	 * @param mark
	 * @param comments
	 * @param userId
	 * @param travelId
	 */
	public Participate(int id, int seats, int mark, String comments, int userId, int travelId) {
		this.id = id;
		this.seats = seats;
		this.mark = mark;
		this.comments = comments;
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
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	/**
	 * @return the mark
	 */
	public int getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
		return "Participate [id=" + id + ", seats=" + seats + ", mark=" + mark + ", comments=" + comments + ", userId="
				+ userId + ", travelId=" + travelId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + id;
		result = prime * result + mark;
		result = prime * result + seats;
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
		Participate other = (Participate) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id != other.id)
			return false;
		if (mark != other.mark)
			return false;
		if (seats != other.seats)
			return false;
		if (travelId != other.travelId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
