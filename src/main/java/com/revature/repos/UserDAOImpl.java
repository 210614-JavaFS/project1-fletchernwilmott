package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User findUsername(String ersUsername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int login(User user) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT user_role_id FROM ers_users WHERE ers_username = ? AND ers_password = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, user.getErsUsername());
			statement.setString(2, user.getErsPassword());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return 1;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}


	@Override
	public boolean addUser(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_users (ers_user_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			
			statement.setInt(++index, user.getErsUserId());
			statement.setString(++index, user.getErsUsername());
			statement.setString(++index, user.getErsPassword());
			statement.setString(++index, user.getUserFirstName());
			statement.setString(++index, user.getUserLastName());
			statement.setString(++index, user.getUserEmail());
			statement.setInt(++index, user.getUserRoleId());
			
			statement.execute();
			
			return true;
				
		}
		catch(SQLException e) {
			System.out.println("Something went wrong, account not added");
		}
		
		return false;
	}

}
