package additional;

import enums.*;


import java.io.Serializable;

import java.util.Objects;

public class Organization implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private OrganizationName name;
	private OrganizationRole role;
	 
	public Organization() {}
	
	public Organization(OrganizationName name, OrganizationRole role) {
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

	 public OrganizationRole getRole() {
	  return role;
	 }

	 public void setRole(OrganizationRole role) {
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
