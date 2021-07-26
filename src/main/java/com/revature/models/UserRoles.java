package com.revature.models;

public class UserRoles {

	int ersUserRoleId;
	String ersUserRole;
	
	public UserRoles(int ersUserRoleId, String ersUserRole) {
		super();
		this.ersUserRoleId = ersUserRoleId;
		this.ersUserRole = ersUserRole;
	}
	
	public UserRoles() {
		super();
	}

	public int getErsUserRoleId() {
		return ersUserRoleId;
	}

	public void setErsUserRoleId(int ersUserRoleId) {
		this.ersUserRoleId = ersUserRoleId;
	}

	public String getErsUserRole() {
		return ersUserRole;
	}

	public void setErsUserRole(String ersUserRole) {
		this.ersUserRole = ersUserRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersUserRole == null) ? 0 : ersUserRole.hashCode());
		result = prime * result + ersUserRoleId;
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
		UserRoles other = (UserRoles) obj;
		if (ersUserRole == null) {
			if (other.ersUserRole != null)
				return false;
		} else if (!ersUserRole.equals(other.ersUserRole))
			return false;
		if (ersUserRoleId != other.ersUserRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRoles [ersUserRoleId=" + ersUserRoleId + ", ersUserRole=" + ersUserRole + "]";
	}

}
