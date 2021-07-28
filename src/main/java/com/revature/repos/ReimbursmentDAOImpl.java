package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursment;
import com.revature.utils.ConnectionUtil;

public class ReimbursmentDAOImpl implements ReimbursmentDAO {

	// Employee
	@Override
	public boolean addReimbursmentRequest(Reimbursment reimbursment) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_reimbursment (reimb_id, reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			
			statement.setInt(++index, reimbursment.getReimbId());
			statement.setDouble(++index, reimbursment.getReimbAmount());
			statement.setString(++index, reimbursment.getReimbSubmitted());
			statement.setString(++index, reimbursment.getReimbDescription());
			statement.setInt(++index, reimbursment.getReimbAuthor());
			statement.setInt(++index, reimbursment.getReimbStatusId());
			statement.setInt(++index, reimbursment.getReimbTypeId());
			
			statement.execute();
			
			return true;
				
		}
		catch(SQLException e) {
			System.out.println("Something went wrong, account not added");
		}
		
		return false;
	}

	@Override
	public List<Reimbursment> findAllPendingReimbursmentsByUserId(int userId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursment WHERE reimb_author = ? AND reimb_status_id = 1;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, userId);
			
			ResultSet result = statement.executeQuery();
			
			List<Reimbursment> reimbursmentList = new ArrayList<>();
			
			while(result.next()) {
				Reimbursment reimbursment = new Reimbursment();
				reimbursment.setReimbId(result.getInt("reimb_id"));
				reimbursment.setReimbAmount(result.getDouble("reimb_amount"));
				reimbursment.setReimbSubmitted(result.getString("reimb_submitted"));
				reimbursment.setReimbResolved(result.getString("reimb_resolved"));
				reimbursment.setReimbDescription(result.getString("reimb_description"));
				reimbursment.setReimbAuthor(result.getInt("reimb_author"));
				reimbursment.setReimbResolver(result.getInt("reimb_resolver"));
				reimbursment.setReimbStatusId(result.getInt("reimb_status_id"));
				reimbursment.setReimbTypeId(result.getInt("reimb_type_id"));
				reimbursmentList.add(reimbursment);
			}
			
			return reimbursmentList;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursment> findAllPastReimbursmentsByUserId(int userId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursment WHERE reimb_author = ? AND reimb_status_id != 1;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, userId);
			
			ResultSet result = statement.executeQuery();
			
			List<Reimbursment> reimbursmentList = new ArrayList<>();
			
			while(result.next()) {
				Reimbursment reimbursment = new Reimbursment();
				reimbursment.setReimbId(result.getInt("reimb_id"));
				reimbursment.setReimbAmount(result.getDouble("reimb_amount"));
				reimbursment.setReimbSubmitted(result.getString("reimb_submitted"));
				reimbursment.setReimbResolved(result.getString("reimb_resolved"));
				reimbursment.setReimbDescription(result.getString("reimb_description"));
				reimbursment.setReimbAuthor(result.getInt("reimb_author"));
				reimbursment.setReimbResolver(result.getInt("reimb_resolver"));
				reimbursment.setReimbStatusId(result.getInt("reimb_status_id"));
				reimbursment.setReimbTypeId(result.getInt("reimb_type_id"));
				reimbursmentList.add(reimbursment);
			}
			
			return reimbursmentList;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	// Manager
	
	@Override
	public List<Reimbursment> findAllPendingReimbursments() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursment;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			List<Reimbursment> reimbursmentList = new ArrayList<>();
			
			while(result.next()) {
				Reimbursment reimbursment = new Reimbursment();
				reimbursment.setReimbId(result.getInt("reimb_id"));
				reimbursment.setReimbAmount(result.getDouble("reimb_amount"));
				reimbursment.setReimbSubmitted(result.getString("reimb_submitted"));
				reimbursment.setReimbResolved(result.getString("reimb_resolved"));
				reimbursment.setReimbDescription(result.getString("reimb_description"));
				reimbursment.setReimbAuthor(result.getInt("reimb_author"));
				reimbursment.setReimbResolver(result.getInt("reimb_resolver"));
				reimbursment.setReimbStatusId(result.getInt("reimb_status_id"));
				reimbursment.setReimbTypeId(result.getInt("reimb_type_id"));
				
				reimbursmentList.add(reimbursment);
			}
			
			return reimbursmentList;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursment> findAllReimbursmentsByUserId(int userId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_reimbursment WHERE reimb_author = ? AND reimb_status_id != 1;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, userId);
			
			ResultSet result = statement.executeQuery();
			
			List<Reimbursment> reimbursmentList = new ArrayList<>();
			
			while(result.next()) {
				Reimbursment reimbursment = new Reimbursment();
				reimbursment.setReimbId(result.getInt("reimb_id"));
				reimbursment.setReimbAmount(result.getDouble("reimb_amount"));
				reimbursment.setReimbSubmitted(result.getString("reimb_submitted"));
				reimbursment.setReimbResolved(result.getString("reimb_resolved"));
				reimbursment.setReimbDescription(result.getString("reimb_description"));
				reimbursment.setReimbAuthor(result.getInt("reimb_author"));
				reimbursment.setReimbResolver(result.getInt("reimb_resolver"));
				reimbursment.setReimbStatusId(result.getInt("reimb_status_id"));
				reimbursment.setReimbTypeId(result.getInt("reimb_type_id"));
				reimbursmentList.add(reimbursment);
			}
			
			return reimbursmentList;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean approveReimbursmentRequest(int reimbursmentId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE ers_reimbursment SET ers_status_id = 2 WHERE reimb_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, reimbursmentId);
			
			statement.executeQuery();
			
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyReimbursmentRequest(int reimbursmentId) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE ers_reimbursment SET ers_status_id = 3 WHERE reimb_id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, reimbursmentId);
			
			statement.executeQuery();
			
			return true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
