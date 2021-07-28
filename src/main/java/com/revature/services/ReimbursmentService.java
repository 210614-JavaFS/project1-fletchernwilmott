package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursment;
import com.revature.repos.ReimbursmentDAO;
import com.revature.repos.ReimbursmentDAOImpl;

public class ReimbursmentService {
	
	private static ReimbursmentDAO reimbursmentDAO = new ReimbursmentDAOImpl();
	
	// Employee Actions
	// add new requests
	public boolean addReimbursmentRequest(Reimbursment reimbursment) {
		return reimbursmentDAO.addReimbursmentRequest(reimbursment);
	}
	
	// view their pending requests
	public List<Reimbursment> findAllPendingReimbursmentsByUserId(int userId) {
		return reimbursmentDAO.findAllPendingReimbursmentsByUserId(userId);
	}
	
	// view their past requests
	public List<Reimbursment> findAllPastReimbursmentsByUserId(int userId) {
		return reimbursmentDAO.findAllPastReimbursmentsByUserId(userId);
	}
	
	
	// Manager actions
	// find all pending reimbursement requests
	public List<Reimbursment> findAllPendingReimbursments() {
		return reimbursmentDAO.findAllPendingReimbursments();
	}
	
	// find all requests from a specific employee
	public List<Reimbursment> findAllReimbursmentsByUsername(int userId){
		return reimbursmentDAO.findAllReimbursmentsByUserId(userId);
	}
	
	// approve requests
	public boolean approveReimbursmentRequest(int reimbursmentId) {
		return reimbursmentDAO.approveReimbursmentRequest(reimbursmentId);
	}
	
	// deny requests
	public boolean denyReimbursmentRequest(int reimbursmentId) {
		return reimbursmentDAO.denyReimbursmentRequest(reimbursmentId);
	}
}
