package com.cognixia.radiant.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cognixia.radiant.connection.ConnectionManager;

public class MusicDaoImpl implements MusicDao{
	private Connection connection = null;

	@Override
	public void establishConnection() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			try {
				connection = ConnectionManager.getConnection();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public List<Music> getAllMusic() {
		
		List<Music> musicList= new ArrayList<>();
		
		try(Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM music")){
			
			while(rs.next()) {
				int id = rs.getInt("music_id");
				String title = rs.getString("title");
				String artist_name = rs.getString("artist_name");
				int length_sec = rs.getInt("length_sec");
				
				rs.close();
				
				Music music = new Music(id, title, artist_name, length_sec);
				musicList.add(music);
				
				return musicList;
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return musicList;
	}

	@Override
	public boolean addMusicById(int id, int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Music> getMusicByStatus(String status, int user_id) {
		// TODO Auto-generated method stub
		
		List<Music> musicList = new ArrayList<>();
		
		try(PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM music WHERE music_id IN (SELECT * FROM user_music WHERE status = ? AND user_id = ?)")){
			pstmt.setString(1, status);
			pstmt.setInt(2, user_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("music_id");
				String title = rs.getString("title");
				String artist_name = rs.getString("artist_name");
				int length_sec = rs.getInt("length_sec");
				
				rs.close();
				
				Music music = new Music(id, title, artist_name, length_sec);
				musicList.add(music);
				
				return musicList;
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return musicList;
	}

	@Override
	public boolean addMusicToStatus(String status, int user_id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
