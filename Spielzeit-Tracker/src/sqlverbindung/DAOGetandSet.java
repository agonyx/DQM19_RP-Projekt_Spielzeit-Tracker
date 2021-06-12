package sqlverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOGetandSet {

	private String database;
	private String url;
	private Connection conn = null;
	public DAOGetandSet() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		database = "resources/Spielzeittracker.db";
		url = "jdbc:sqlite:" + database;
	}

	public Benutzer getIfBenutzerWithAttributeExist(String inputTry, String tabellenAttribut) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Benutzer where " + tabellenAttribut + " = " + inputTry;
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				 Benutzer b = new Benutzer(rs.getInt("BenutzerID"),rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"), rs.getString("Email"), rs.getInt("Punkte"), 0);
				 return b;
			} else {
				throw new DB_FehlerException("Benuzter mit Attribut nicht gefunden!");
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
	
	public boolean getIfBenutzerWithAttributeExistWahr(String inputTry, String tabellenAttribut) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Benutzer where " + tabellenAttribut + " = " + inputTry;
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				 return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
			
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
	public Avatar getAvatar(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Avatar where BenutzerID = " + b.getID();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				Avatar a = new Avatar(rs.getInt("GesichterID"),rs.getInt("GBID") , rs.getInt("RahmenID"), b.getID(), rs.getInt("KopfbedeckungenID"), rs.getInt("OberteilID"), rs.getInt("KoerperID"));
				return a;
			} else {
				throw new DB_FehlerException("Der Avatar f�r diesen Benutzer konnte nicht gefunden werden");
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
	public void insertBenutzer(Benutzer benutzer) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Benutzer (Username, Passwort, SteamID, Email) Values (?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, benutzer.getUsername());
			statement.setString(2, benutzer.getPasswort());
			statement.setString(3, benutzer.getSteamid());
			statement.setString(4, benutzer.getEmail());
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
	

	public void createAvatar(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Avatar (BenutzerID, KoerperID) Values ("+b.getID()+",1)";
			PreparedStatement statement = conn.prepareStatement(sql);
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
}
