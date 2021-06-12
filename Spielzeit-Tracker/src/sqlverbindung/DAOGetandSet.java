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
	// Abfrage der Items (Gesichter)
	public Gesichter[] getAllGesichter() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichter";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Gesichter");
			Gesichter[] gesicht = new Gesichter[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					gesicht[count] = new Gesichter(rs.getInt("GesichterID"), rs.getString("Bezeichnung"),
							rs.getString("Bilder"));
				count++;
			}
			return gesicht;
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

	// Abfrage der Items (Gesichtsbedeckung)
	public Gesichtsbedeckung[] getAllGesichtsbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichtsbedeckungen";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Gesichtsbedeckungen");
			Gesichtsbedeckung[] gb = new Gesichtsbedeckung[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					gb[count] = new Gesichtsbedeckung(rs.getInt("GBID"), rs.getString("Bezeichnung"),
							rs.getString("Bilder"));
				count++;
			} 
			return gb;
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

	// Abfrage der Items (Kopfbedeckung)
	public Kopfbedeckung[] getAllKopfbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Kopfbedeckungen";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Kopfbedeckungen");
			Kopfbedeckung[] Kopfbedeckung = new Kopfbedeckung[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					Kopfbedeckung[count] = new Kopfbedeckung(rs.getInt("KopfbedeckungenID"),
							rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			} 
			return Kopfbedeckung;
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

	// Abfrage der Items (Koerper)
	public Koerper[] getAllKoerper() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Koerper";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Koerper");
			Koerper[] koerper = new Koerper[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					koerper[count] = new Koerper(rs.getInt("KoerperID"), rs.getString("Bezeichnung"),
							rs.getString("Bilder"));
				count++;
			} while (rs.next());
			return koerper;
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

	// Abfrage der Items (Oberteile)
	public Oberteil[] getAllOberteil() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Oberteil";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Oberteil");
			Oberteil[] Oberteil = new Oberteil[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					Oberteil[count] = new Oberteil(rs.getInt("OberteilID"), rs.getString("Bezeichnung"),
							rs.getString("Bilder"));
				count++;
			} while (rs.next());
			return Oberteil;
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

	// Abfrage der Items (Rahmen)
	public Rahmen[] getAllRahmen() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Rahmen";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Rahmen");
			Rahmen[] rahmen = new Rahmen[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					rahmen[count] = new Rahmen(rs.getInt("RahmenID"), rs.getString("Bezeichnung"),
							rs.getString("Bilder"));
				count++;
			} while (rs.next());
			return rahmen;
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

	// Erstellen eines angezeigten Benutzeravatars
	public void insertAvatarItems(Benutzer benutzer, Rahmen rahmen, Gesichter gesichter,
			Gesichtsbedeckung gesichtsbedeckung, Kopfbedeckung kopfbedeckung, Oberteil oberteil, Koerper koerper)
			throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Avatar (BenutzerID, RahmenID, GesichterID, GBID, KopfbedeckungenID, OberteilID, AvatarbildID) Values (?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, benutzer.getID());
			statement.setInt(2, rahmen.getRahmenID());
			statement.setInt(3, gesichter.getGesichterID());
			statement.setInt(4, gesichtsbedeckung.getGBID());
			statement.setInt(5, kopfbedeckung.getKopfbedeckungsID());
			statement.setInt(6, oberteil.getOberteilID());
			statement.setInt(7, koerper.getKoerperID());
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

	public void changeAvatar(int benutzerid, Rahmen rahmen, Gesichter gesichter, Gesichtsbedeckung gesichtsbedeckung, Kopfbedeckung kopfbedeckung, Oberteil oberteil, Koerper koerper) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "update Avatar Set RahmenID = ?, GesichterID = ?, GBID = ?, KopfbedeckungenID = ?, OberteilID = ?, AvatarbildID = ? where BenutzerID = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, rahmen.getRahmenID());
			statement.setInt(2, gesichter.getGesichterID());
			statement.setInt(3, gesichtsbedeckung.getGBID());
			statement.setInt(4, kopfbedeckung.getKopfbedeckungsID());
			statement.setInt(5, oberteil.getOberteilID());
			statement.setInt(6, koerper.getKoerperID());
			statement.setInt(7, benutzerid);
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

	public int getCount(String type) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select count(*) as count from " + type;
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getInt("count");
			} else {
				throw new DB_FehlerException("Fehler");
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
	public Spiele[] getAllGames() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Spiele";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			int size = getCount("Spiele");
			Spiele[] spiel = new Spiele[size];
			int count = 0;
			while (rs.next()) {
				if (count < size)
					spiel[count] = new Spiele(rs.getInt("SpielID"), rs.getInt("AppID"),
							rs.getString("Bezeichnung"));
				count++;
			}
			return spiel;
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
