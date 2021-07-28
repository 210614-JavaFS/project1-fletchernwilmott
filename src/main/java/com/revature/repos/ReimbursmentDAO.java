package com.revature.repos;

import java.util.List;

import com.revature.models.Reimbursment;

public interface ReimbursmentDAO {
	
	// Employee actions
	boolean addReimbursmentRequest(Reimbursment reimbursment);
	List<Reimbursment> findAllPendingReimbursmentsByUserId(int userId);
	List<Reimbursment> findAllPastReimbursmentsByUserId(int userId);
	
	// Manager actions
	List<Reimbursment> findAllPendingReimbursments();
	List<Reimbursment> findAllReimbursmentsByUserId(int userId);
	boolean approveReimbursmentRequest(int reimbursmentId);
	boolean denyReimbursmentRequest(int reimbursmentId);
	
}
