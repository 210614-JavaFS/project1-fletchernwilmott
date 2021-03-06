package com.revature.models;

public class ReimbursmentType {

	int reimbTypeId;
	String reimbType;
	
	public ReimbursmentType(int reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}
	
	public ReimbursmentType() {
		super();
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeId;
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
		ReimbursmentType other = (ReimbursmentType) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeId != other.reimbTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursmentType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + "]";
	}
	
	
}
