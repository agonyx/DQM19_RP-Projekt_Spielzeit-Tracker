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
	private Gesichter gesichter;
	private Gesichtsbedeckung gesichtsbedeckung;
	private Kopfbedeckung kopfbedeckung;
	private Oberteil oberteil;
	private Rahmen rahmen;
	private Spiele spiele;
	private Spielzeit spielzeit;
	private Koerper koerper;
		

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
						rs.getString("Email"), rs.getInt("Punkte"), rs.getInt("Admin"));
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

	//Auswahl der Avatare anhand der ID
	public Avatar selectAvatar(int avatarid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Avatar where AvatarID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, avatarid);
			rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(avatarid, rs.getInt("GesichterID"),
						rs.getInt("GBID"), rs.getInt("RahmenID"), rs.getInt("BenutzerID"), rs.getInt("KopfbedeckungID"), rs.getInt("OberteilID"), rs.getInt("KoerperID"));
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
	
	public Avatar selectUserAvatar(int benutzerid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Avatar where BenutzerID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, benutzerid);
			rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(benutzerid, rs.getInt("GesichterID"),
						rs.getInt("GBID"), rs.getInt("RahmenID"), rs.getInt("BenutzerID"), rs.getInt("KopfbedeckungID"), rs.getInt("OberteilID"), rs.getInt("KoerperID"));
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

	public Gesichter selectGesicht(int gesichterid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Gesicht where GesichterID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, gesichterid);
			rs = statement.executeQuery();
			if (rs.next()) {
				gesichter = new Gesichter(rs.getInt("GesichterID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return gesichter;
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
	
	public Gesichtsbedeckung selectGesichtsbedeckung(int gbid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Gesichtsbedeckungen where GBID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, gbid);
			rs = statement.executeQuery();
			if (rs.next()) {
				gesichtsbedeckung = new Gesichtsbedeckung(rs.getInt("GBID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return gesichtsbedeckung;
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
	
	public Kopfbedeckung selectKopfbedeckung(int kopfbedeckungenid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Kopfbedeckungen where KopfbedeckungenID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, kopfbedeckungenid);
			rs = statement.executeQuery();
			if (rs.next()) {
				kopfbedeckung = new Kopfbedeckung(rs.getInt("KopfbedeckungenID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return kopfbedeckung;
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
	
	public Oberteil selectOberteil(int oberteilid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Oberteil where OberteilID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, oberteilid);
			rs = statement.executeQuery();
			if (rs.next()) {
				oberteil = new Oberteil(rs.getInt("OberteilID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return oberteil;
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
	public Oberteil selectOberteil(int oberteilid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Oberteil where OberteilID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, oberteilid);
			rs = statement.executeQuery();
			if (rs.next()) {
				oberteil = new Oberteil(rs.getInt("OberteilID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return oberteil;
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
	}public Koerper selectOberteil(int koerperid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Oberteil where OberteilID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, koerperid);
			rs = statement.executeQuery();
			if (rs.next()) {
				koerper = new Koerper(rs.getInt("KoerperID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"));
				return koerper;
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


	public Benutzer getIfBenutzerWithAttributeExist(String inputTry, String tabellenAttribut) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Benutzer where " + tabellenAttribut + " = " + inputTry;
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			if(rs.next()) {
				 Benutzer b = new Benutzer(rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"), rs.getString("Email"), rs.getInt("Punkte"));
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
			rs = statement.executeQuery();
			if(rs.next()) {
				 Benutzer b = new Benutzer(rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"), rs.getString("Email"), rs.getInt("Punkte"));
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
	
}