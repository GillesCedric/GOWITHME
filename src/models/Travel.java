package models;

import java.sql.Date;
import java.sql.Time;

public class Travel {
	private int id;
	private Date date;
	private Time time;
	private String departure;
	private String arrival;
	private String brand;
	private int seats;
	private String color;
	private String registration;
	private boolean isActive;
	private int amount;
	private String description;
	private int userId;
	
	/**
	 * @param date
	 * @param time
	 * @param departure
	 * @param arrival
	 * @param brand
	 * @param seats
	 * @param color
	 * @param registration
	 * @param isActive
	 * @param amount
	 * @param description
	 * @param userId
	 */
	public Travel(Date date, Time time, String departure, String arrival, String brand, int seats, String color,
			String registration, boolean isActive, int amount, String description, int userId) {
		this.date = date;
		this.time = time;
		this.departure = departure;
		this.arrival = arrival;
		this.brand = brand;
		this.seats = seats;
		this.color = color;
		this.registration = registration;
		this.isActive = isActive;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
	}
	/**
	 * @param id
	 * @param date
	 * @param time
	 * @param departure
	 * @param arrival
	 * @param brand
	 * @param seats
	 * @param color
	 * @param registration
	 * @param isActive
	 * @param amount
	 * @param description
	 * @param userId
	 */
	public Travel(int id, Date date, Time time, String departure, String arrival, String brand, int seats, String color,
			String registration, boolean isActive, int amount, String description, int userId) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.departure = departure;
		this.arrival = arrival;
		this.brand = brand;
		this.seats = seats;
		this.color = color;
		this.registration = registration;
		this.isActive = isActive;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
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
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
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
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}
	/**
	 * @param registration the registration to set
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	@Override
	public String toString() {
		return "Travel [id=" + id + ", date=" + date + ", time=" + time + ", departure=" + departure + ", arrival="
				+ arrival + ", brand=" + brand + ", seats=" + seats + ", color=" + color + ", registration="
				+ registration + ", isActive=" + isActive + ", amount=" + amount + ", description=" + description
				+ ", userId=" + userId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((arrival == null) ? 0 : arrival.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((registration == null) ? 0 : registration.hashCode());
		result = prime * result + seats;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Travel other = (Travel) obj;
		if (amount != other.amount)
			return false;
		if (arrival == null) {
			if (other.arrival != null)
				return false;
		} else if (!arrival.equals(other.arrival))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (registration == null) {
			if (other.registration != null)
				return false;
		} else if (!registration.equals(other.registration))
			return false;
		if (seats != other.seats)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
