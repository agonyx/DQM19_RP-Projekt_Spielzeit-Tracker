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
	private Accessoire accessoire;
	private Kostuem kostuem;
	private Rahmen rahmen;
	private Spiele spiele;
	private Spielzeit spielzeit;
	

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
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, avatarid);
			rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(rs.getInt("AccessoiresID"),
						rs.getInt("KostuemID"), rs.getInt("RahmenID"), rs.getInt("BenutzerID"));
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

	public Accessoire selectAccessoire(int accessoiresid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Accesoires where AccessoireID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, accessoiresid);
			rs = statement.executeQuery();
			if (rs.next()) {
				accessoire = new Accessoire(rs.getInt("AccessoireID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return accessoire;
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

	public Kostuem selectKostuem(int kostuemid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Kostuem where KostuemID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, kostuemid);
			rs = statement.executeQuery();
			if (rs.next()) {
				kostuem = new Kostuem(rs.getInt("KostuemID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return kostuem;
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
	public Rahmen selectRahmen(int rahmenid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Rahmen where RahmenID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, rahmenid);
			rs = statement.executeQuery();
			if (rs.next()) {
				rahmen = new Rahmen(rs.getInt("RahmenID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return rahmen;
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
	
	public Spiele selectSpiele(int spieleid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Spiele where SpielID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, spieleid);
			rs = statement.executeQuery();
			if (rs.next()) {
				spiele = new Spiele(rs.getInt("SpielID"),
						rs.getInt("AppID"), rs.getString("Name"));
				return spiele;
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
	public Spielzeit selectSpielzeit(int spielzeitid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Spielzeit where SpielzeitID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, spielzeitid);
			rs = statement.executeQuery();
			if (rs.next()) {
				spielzeit = new Spielzeit(rs.getInt("SpielzeitID"),
						rs.getInt("BenutzerID"), rs.getInt("SpielID"), rs.getDouble("Spielzeit"));
				return spielzeit;
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
}