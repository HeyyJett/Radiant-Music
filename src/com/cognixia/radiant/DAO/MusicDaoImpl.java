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

		try(PreparedStatement pstmt = connection.prepareStatement("INSERT INTO user_music (user_id, id, status) VALUES (?, ?, 'INCOMEPLETE')")) {
			pstmt.setInt(1, id);
			pstmt.setInt(1, user_id);
			int count=pstmt.executeUpdate();
			if(count>0) {
				return true;
			}

		}
		catch(SQLException e){
			System.out.println("Wrong ID Entered");
		}
		return false;
	}

	@Override
	public List<Music> getMusicByStatus(String status, int user_id) {

		List<Music> musicList = new ArrayList<>();

		try (PreparedStatement pstmt = connection.prepareStatement("SELECT music_id FROM music WHERE music_id IN (SELECT music_id FROM user_music WHERE status = ? AND user_id = ?)")) {
			pstmt.setString(1, status);
			pstmt.setInt(2, user_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("music_id");
				String title = rs.getString("title");
				String artist_name = rs.getString("artist_name");
				int length_sec = rs.getInt("length_sec");

				rs.close();

				Music music = new Music(id, title, artist_name, length_sec);
				musicList.add(music);

				return musicList;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return musicList;
	}

	@Override
	public boolean addMusicToStatus(String status, int user_id, int music_id){

		try(PreparedStatement pStmt = connection.prepareStatement("update user_music set status = ?, where user_id = ? AND music_id = ?")){

			pStmt.setString(1, status);
			pStmt.setInt(2, user_id);
			pStmt.setInt(3, music_id);

			int StatusChange = pStmt.executeUpdate();

			return StatusChange > 0;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
