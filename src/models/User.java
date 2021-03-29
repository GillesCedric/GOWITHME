package models;

import utilities.Utilitie;

public class User {
	private int id;
	private String name;
	private String lastName;
	private String password;
	private String picture;
	private boolean isAdmin;
	private boolean isActive;
	
	

	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param password
	 * @param picture
	 * @param isAdmin
	 * @param isActive
	 */
	public User(int id, String name, String lastName, String password, String picture, boolean isAdmin,
			boolean isActive) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.picture = picture;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}

	
	/**
	 * @param name
	 * @param lastName
	 * @param password
	 * @param isAdmin
	 * @param isActive
	 */
	public User(String name, String lastName, String password, boolean isAdmin, boolean isActive) {
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
		this.picture = "default.png";
	}

	

	/**
	 * @param name
	 * @param lastName
	 * @param password
	 * @param picture
	 * @param isAdmin
	 * @param isActive
	 */
	public User(String name, String lastName, String password, String picture, boolean isAdmin, boolean isActive) {
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.picture = picture;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password =  Utilitie.encyptPassword(password);;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", password=" + password + ", picture=" + picture + ", isAdmin=" + isAdmin
				+ ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}
	
}
