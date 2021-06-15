package sqlverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import gui.Hauptseite;

public class DAOSelect {


	private String database;
	private String url;
	private Connection conn = null;
	private Avatar avatar;
	private Gesichter gesichter;
	private Gesichtsbedeckung gesichtsbedeckung;
	private Kopfbedeckung kopfbedeckung;
	private Oberteil oberteil;
	private Rahmen rahmen;
	private Spiele spiele;
	private Spielzeit spielzeit;
	private Koerper koerper;
		

	public DAOSelect() {
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
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, benutzerid);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Benutzer benutzer = new Benutzer(rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"),
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
			ResultSet rs = statement.executeQuery();
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				avatar = new Avatar(benutzerid, rs.getInt("GesichterID"),
						rs.getInt("GBID"), rs.getInt("RahmenID"), rs.getInt("BenutzerID"), rs.getInt("KopfbedeckungenID"), rs.getInt("OberteilID"), rs.getInt("KoerperID"));
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
			String sql = "select * from Gesichter where GesichterID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, gesichterid);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				gesichter = new Gesichter(rs.getInt("GesichterID"),
						rs.getString("Bezeichnung"), rs.getString("Bilder"),rs.getString("Typ"));
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				gesichtsbedeckung = new Gesichtsbedeckung(rs.getInt("GBID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"),rs.getString("Typ"));
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				kopfbedeckung = new Kopfbedeckung(rs.getInt("KopfbedeckungenID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"),rs.getString("Typ"));
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				oberteil = new Oberteil(rs.getInt("OberteilID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"),rs.getString("Typ"));
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
	public Koerper selectKoerper(int koerperid) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Koerper where KoerperID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, koerperid);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				koerper = new Koerper(rs.getInt("KoerperID"),
						rs.getString("Bezeichnung"), rs.getString("Bilder"),rs.getString("Typ"));
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				rahmen = new Rahmen(rs.getInt("RahmenID"),
						rs.getString("Bezeichnung"), rs.getString("Bild"),rs.getString("Typ"));
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
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				spiele = new Spiele(rs.getInt("SpielID"),
						rs.getInt("AppID"), rs.getString("Bezeichnung"));
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
			ResultSet rs = statement.executeQuery();
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
	public Spiele selectGame(int appID) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Spiele where AppID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, appID);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Spiele spiel = new Spiele(rs.getInt("SpielID"), appID,rs.getString("Bezeichnung"));
				return spiel;
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