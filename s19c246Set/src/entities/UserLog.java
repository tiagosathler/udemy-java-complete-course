package entities;

import java.util.Date;
import java.util.Objects;

public class UserLog {
	private String name;
	private Date access;

	public UserLog(String name, Date access) {
		this.name = name;
		this.access = access;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLog other = (UserLog) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "UserLog [name=" + name + ", access=" + access + "]";
	}

	public Date getAccess() {
		return access;
	}

	public void setAccess(Date access) {
		this.access = access;
	}

}
