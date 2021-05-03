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
						rs.getString("Email"), rs.getInt("Admin"));
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

	public Avatar selectAvatar(int avatarid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Avatar where AvatarID = ?";
			statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, avatarid);
			rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(rs.getInt("AccessoiresID"), rs.getInt("KostuemID"), rs.getInt("RahmenID"),
						rs.getInt("BenutzerID"));
				return avatar;
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

	public Statistik selectStatistik(int statistikid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Statistik where StatistikID = ?";
			statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, statistikid);
			rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(rs.getInt("Gesamtspielzeit"), rs.getInt("Mitglied_seit"), rs.getInt("Punkte"),
						rs.getInt("BenutzerID"));
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

//InsertIntoAnweisungen

	public void insertBenutzer(Benutzer benutzer) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Benutzer (Username, Passwort, SteamID, Email) Values (?,?,?,?)";
			statement = conn.prepareStatement(sql);
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

}