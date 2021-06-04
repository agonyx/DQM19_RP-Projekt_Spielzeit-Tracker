package sqlverbindung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DAOStatistik {
	private String database;
	private String url;
	private Connection conn = null;
	private Statistik statistik;

	public DAOStatistik() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		database = "resources/Spielzeittracker.db";
		url = "jdbc:sqlite:" + database;
	}
	public boolean doesStatistikForUserExist(Benutzer b) throws DB_FehlerException{
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Statistik where BenutzerID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, b.getID());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new DB_FehlerException(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new DB_FehlerException(e.getMessage());
			}

		}
	
	}
	public void createStatistikForUser(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Statistik (BenutzerID,Gesamtspielzeit,Mitglied_seit) VALUES (?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, b.getID());
			statement.setLong(2, 0);
			statement.setString(3, getCurrentTime());
			statement.executeUpdate();
			System.out.println("[System] Statistik erstellt");
		} catch (SQLException e) {
			throw new DB_FehlerException(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new DB_FehlerException(e.getMessage());
			}

		}
	}
	public Statistik selectStatistikforUser(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Statistik where BenutzerID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, b.getID());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				statistik = new Statistik(rs.getInt("StatistikID"),rs.getDouble("Gesamtspielzeit"), rs.getString("Mitglied_seit"));
				return statistik;
			} else {
				throw new DB_FehlerException("Die ID existiert nicht");
			}
		} catch (SQLException e) {
			throw new DB_FehlerException(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new DB_FehlerException(e.getMessage());
			}

		}
	}
	private String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);  
	}

}
