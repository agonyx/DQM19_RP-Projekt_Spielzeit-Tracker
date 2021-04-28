package sqlverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

// Deklarierung und teilweisige
// Intialisierung von Databankverbindungsvariablen

	private String database;
	private String url;
	private Connection conn = null;
	private PreparedStatement statement = null;
	ResultSet rs = null;
	private Benutzer benutzer;
	private Avatar avatar;
	private Statistik statistik;

	public DAO() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		database = "resources/Spielzeittracker.db";
		url = "jdbc:sqlite:" + database;
	}

//SelectAnweisungen
	public Benutzer selectBenutzer(int benutzerid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Benutzer where BenutzerID = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, benutzerid);
			rs = statement.executeQuery();
			if (rs.next()) {
				benutzer = new Benutzer(rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"),
						rs.getString("SteamID"), rs.getInt("Admin"));
				return benutzer;
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
	/*
	 * public Avatar selectAvatar() { conn = DriverManager.getConnection(url);
	 * String sql = "select * from Benutzer where benutzer = ?"; PreparedStatement
	 * statement = conn.prepareStatement(sql); } public Statistik selectStatistik()
	 * {
	 * 
	 * }
	 */
}