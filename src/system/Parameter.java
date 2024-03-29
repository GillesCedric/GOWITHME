package system;

import java.io.Serializable;

import utilities.Scheme;

public class Parameter implements Serializable{
	private static final long serialVersionUID = 1L;
	private Scheme name;
	private Enum<?> value;
	/**
	 * @param name
	 * @param value
	 */
	public Parameter(Scheme name, Enum<?> value) {
		this.name = name;
		this.value = value;
	}
	/**
	 * @return the name
	 */
	public Scheme getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Scheme name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public Enum<?> getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Enum<?> value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Parameter [name=" + name.name() + ", value=" + value.name() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Parameter other = (Parameter) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
