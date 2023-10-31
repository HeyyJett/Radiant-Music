package com.cognixia.radiant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.cognixia.radiant.connection.ConnectionManager;

public class UserDaoImpl {
	private Connection connection = null;

//	@Override
//	public void establishConnection() throws ClassNotFoundException, SQLException {
//		
//		if(connection == null) {
//			connection = ConnectionManager.getConnection();
//		}
//	}
//	
//	@Override
//	public void closeConnection() throws SQLException {
//		connection.close();
//	}
	
	public Optional<User> getUserByUsernameAndPassword(User user) {
		
		try(PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")){
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				rs.close();
				
				User userObj = new User(user_id, username, password);
				Optional<User> userFound = Optional.of(userObj);
				
				return userFound;
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	
}
