package sqlverbindung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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
	public void setTotalPlaytime(Benutzer b, double time) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Update Statistik Set Gesamtspielzeit = ? where BenutzerID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setDouble(1, time);
			statement.setInt(2, b.getID());
			statement.executeUpdate();
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
	public int getRank(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "SELECT BenutzerID,rank() OVER (Order by Gesamtspielzeit DESC) as Rang FROM Statistik";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt("BenutzerID") == b.getID()) {
					return rs.getInt("Rang");
				}
			}
			throw new DB_FehlerException("");
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
	public int getRankGames(Benutzer b,Spiele spiel) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "SELECT BenutzerID,rank() OVER (Order by Zeit DESC) as Rang FROM Spielzeit WHERE SpielID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, spiel.getSpielID());
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt("BenutzerID") == b.getID()) {
					return rs.getInt("Rang");
				}
			}
			throw new DB_FehlerException("");
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


}
