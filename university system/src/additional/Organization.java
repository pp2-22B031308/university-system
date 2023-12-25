package additional;

import java.io.Serializable;
import java.util.Objects;

public class Organization implements Serializable {
	private OrganizationName name;
	 private Role role;
	 
	public Organization() {
		
	}
	public Organization(OrganizationName name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}

	public OrganizationName getName() {
	  return name;
	 }

	 public void setName(OrganizationName name) {
	  this.name = name;
	 }

	 public Role getRole() {
	  return role;
	 }

	 public void setRole(Role role) {
	  this.role = role; 
	 }
	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		return name == other.name && role == other.role;
	}
	@Override
	public String toString() {
		return "Organization [name=" + name + ", role=" + role + ", getName()=" + getName() + ", getRole()=" + getRole()
				+ "]";
	}
	
}
