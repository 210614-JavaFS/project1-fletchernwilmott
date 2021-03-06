package com.revature.models;

public class ReimbursmentStatus {

	int reimbStatusId;
	String reimbStatus;
	
	public ReimbursmentStatus(int reimbStatusId, String reimbStatus) {
		super();
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
	}
	
	public ReimbursmentStatus() {
		super();
	}

	public int getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + reimbStatusId;
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
		ReimbursmentStatus other = (ReimbursmentStatus) obj;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursmentStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + "]";
	}
	
}
