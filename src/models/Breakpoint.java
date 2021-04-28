package models;

import java.sql.Timestamp;

public class Breakpoint {
	private int id;
	private String point;
	private String time;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private int travelId;
	
	public Breakpoint() {
		
	}
	
	public Breakpoint(String point, String time) {
		this.point = point;
		this.time = time;
	}

	public Breakpoint(int id, String point, String time, Timestamp createdAt, Timestamp updatedAt, int travelId) {
		this(point,time);
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.travelId = travelId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + travelId;
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
		Breakpoint other = (Breakpoint) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (travelId != other.travelId)
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
		return "Breakpoint [id=" + id + ", point=" + point + ", time=" + time + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", travelId=" + travelId + "]";
	}
	
}
