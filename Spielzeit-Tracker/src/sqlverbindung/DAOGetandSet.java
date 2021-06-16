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
				Benutzer b = new Benutzer(rs.getInt("BenutzerID"),rs.getString("Username"), rs.getString("Passwort"), rs.getString("SteamID"), rs.getString("Email"), rs.getInt("Punkte"), rs.getInt("Admin"),rs.getString("daybonustime"));
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
				Avatar a = new Avatar(rs.getInt("GesichterID"),rs.getInt("GesichtsbedeckungenID") , rs.getInt("RahmenID"), b.getID(), rs.getInt("KopfbedeckungenID"), rs.getInt("OberteilID"), rs.getInt("KoerperID"));
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


	public void createDefaultAvatar(Benutzer b) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "Insert Into Avatar (BenutzerID, KoerperID, GesichterID, GesichtsbedeckungenID, KopfbedeckungenID, OberteilID) Values ("+b.getID()+",1,1,1,1,1)";
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
							rs.getString("Bilder"),rs.getString("Typ"));
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
		public int getOwnedItemcount(Benutzer b) throws DB_FehlerException {
			try {
				conn = DriverManager.getConnection(url);
				String sql = "select count(*) as count from Inventar where BenutzerID = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, b.getID());
				ResultSet rs = statement.executeQuery();
				return rs.getInt("count");
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
				gb[count] = new Gesichtsbedeckung(rs.getInt("GesichtsbedeckungenID"), rs.getString("Bezeichnung"),
						rs.getString("Bilder"),rs.getString("Typ"));
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
						rs.getString("Bezeichnung"), rs.getString("Bilder"),rs.getString("Typ"));
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
						rs.getString("Bilder"),rs.getString("Typ"));
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
						rs.getString("Bilder"),rs.getString("Typ"));
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
						rs.getString("Bilder"),rs.getString("Typ"));
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
		String sql = "Insert Into Avatar (BenutzerID, RahmenID, GesichterID, GesichtsbedeckungenID, KopfbedeckungenID, OberteilID, AvatarbildID) Values (?,?,?,?,?,?,?)";
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
		String sql = "update Avatar Set RahmenID = ?, GesichterID = ?, GesichtsbedeckungenID = ?, KopfbedeckungenID = ?, OberteilID = ?, AvatarbildID = ? where BenutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
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
public void changeAvatar(int benutzerid, int rahmenID, int gesichterID, int gesichtsbedeckungID, int kopfbedeckungID, int oberteilID, int koerperID) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "update Avatar Set RahmenID = ?, GesichterID = ?, GesichtsbedeckungenID = ?, KopfbedeckungenID = ?, OberteilID = ?, AvatarbildID = ? where BenutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, rahmenID);
		statement.setInt(2, gesichterID);
		statement.setInt(3, gesichtsbedeckungID);
		statement.setInt(4, kopfbedeckungID);
		statement.setInt(5, oberteilID);
		statement.setInt(6, koerperID);
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
public boolean doesSpielzeitEntryExist(Benutzer b, Spiele spiel) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "select * from Spielzeit where BenutzerID = "+b.getID() +" and "+ "SpielID = " +spiel.getSpielID();
		PreparedStatement statement = conn.prepareStatement(sql);
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
public void createSpielzeitEntry(Benutzer b, Spiele spiel) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "Insert Into Spielzeit (BenutzerID, SpielID) Values (?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, b.getID());
		statement.setInt(2, spiel.getSpielID());
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
public void setSpielzeit(Benutzer b, Spiele spiel, double spielzeit) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "Update Spielzeit Set Zeit = ? where BenutzerID = ? and SpielID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setDouble(1, spielzeit);
		statement.setInt(2, b.getID());
		statement.setInt(3, spiel.getSpielID());
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
public int getSpielZeit(Benutzer bb) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "select * from Statistik where BenutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, bb.getID());
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return rs.getInt("Gesamtspielzeit");
		} else {
			throw new DB_FehlerException(sql);
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
public void setPoints(Benutzer bb, int amount) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "Update Benutzer Set Punkte = ? where BenutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, amount);
		statement.setInt(2, bb.getID());
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
public void createBuyEntry(Benutzer b, int itemID, String type) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "Insert Into Inventar (BenutzerID, ItemID, Type) Values (?,?,?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, b.getID());
		statement.setInt(2, itemID);
		statement.setString(3, type);
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
public boolean itemOwnership(Benutzer b, int itemID, String type) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "select * from Inventar where BenutzerID = ? and ItemID = ? and Type = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, b.getID());
		statement.setInt(2, itemID);
		statement.setString(3, type);
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
public boolean doesItemExist(String type,int itemID) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "select * from "+type+" WHERE "+type+"ID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, itemID);
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
public void updateAdminStatus(int benutzerid, int adminask) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);
		String sql = "UPDATE Benutzer SET Admin = ? WHERE BenutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, adminask);
		statement.setInt(2, benutzerid);
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
public void updateDaybonustime(Benutzer benutzer, String daybonustime) throws DB_FehlerException {
	try {
		conn = DriverManager.getConnection(url);

		String sql = "update Benutzer set daybonustime = ? where benutzerID = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, daybonustime);
		statement.setInt(2, benutzer.getID());
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
