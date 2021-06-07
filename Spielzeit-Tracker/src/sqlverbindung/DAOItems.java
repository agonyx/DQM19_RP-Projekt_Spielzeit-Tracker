package sqlverbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOItems {
	private String database;
	private String url;
	private Connection conn = null;

	public DAOItems() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		database = "resources/Spielzeittracker.db";
		url = "jdbc:sqlite:" + database;
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
			do {
				if(count <size)
				gesicht[count] = new Gesichter(rs.getInt("GesichterID"), rs.getString("Bezeichnung"),rs.getString("Bilder"));
				count++;
			} while (rs.next());
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
			do {
				if(count <size)
				gb[count] = new Gesichtsbedeckung(rs.getInt("GBID"), rs.getString("Bezeichnung"),
						rs.getString("Bilder"));
				count++;
			} while (rs.next());
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
			do {
				if(count <size)
				Kopfbedeckung[count] = new Kopfbedeckung(rs.getInt("KopfbedeckungenID"), rs.getString("Bezeichnung"),
						rs.getString("Bilder"));
				count++;
			} while (rs.next());
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
			do {
				if(count <size)
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
			do {
				if(count <size)
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
			do {
				if(count <size)
				rahmen[count] = new Rahmen(rs.getInt("RahmenID"), rs.getString("Bezeichnung"), rs.getString("Bilder"));
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
	//Einfügen von Items
	public void insertAvatarItems(Benutzer benutzer, Rahmen rahmen, Gesichter gesichter, Gesichtsbedeckung gesichtsbedeckung, Kopfbedeckung kopfbedeckung, Oberteil oberteil, Koerper koerper) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Avatar (BenutzerID, RahmenID, GesichterID, GesichterID, GBID, KopfbedeckungenID, OberteilID, AvatarbildID) Values (?,?,?,?)";
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
}
