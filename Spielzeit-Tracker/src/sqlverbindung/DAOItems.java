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
	ResultSet rs = null;

	public DAOItems() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		database = "resources/Spielzeittracker.db";
		url = "jdbc:sqlite:" + database;
	}
	//Abfrage der Items (Gesichter)
	public Gesichter[] getAllGesichter() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichter";
			System.out.println(1);
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println(2);
			rs = statement.executeQuery();
			System.out.println(3);
			int size = getCount("Gesichter");
			System.out.println(4);
			Gesichter[] gesicht = new Gesichter[size];
			int count = 0;
			while(rs.next()) {
				gesicht[count] = new Gesichter(rs.getInt("GesichterID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
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

	//Abfrage der Items (Gesichtsbedeckung)
	public Gesichtsbedeckung[] getAllGesichtsbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichtsbedeckung";
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = getCount("Gesichtsbedeckung");
			Gesichtsbedeckung[] gb = new Gesichtsbedeckung[size];
			int count = 0;
			while(rs.next()) {
				gb[count] = new Gesichtsbedeckung(rs.getInt("GesichtsbedeckungID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
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
	//Abfrage der Items (Kopfbedeckung)
	public Kopfbedeckung[] getAllKopfbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Kopfbedeckung";
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = getCount("Kopfbedeckung");
			Kopfbedeckung[] Kopfbedeckung = new Kopfbedeckung[size];
			int count = 0;
			while(rs.next()) {
				Kopfbedeckung[count] = new Kopfbedeckung(rs.getInt("KopfbedeckungID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
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
	//Abfrage der Items (Koerper)
	public Koerper[] getAllKoerper() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Koerper";
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = getCount("Koerper");
			Koerper[] koerper = new Koerper[size];
			int count = 0;
			while(rs.next()) {
				koerper[count] = new Koerper(rs.getInt("KoerperID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			}
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
	//Abfrage der Items (Oberteile)
	public Oberteil[] getAllOberteil() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Oberteil";
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = getCount("Oberteil");
			Oberteil[] Oberteil = new Oberteil[size];
			int count = 0;
			while(rs.next()) {
				Oberteil[count] = new Oberteil(rs.getInt("OberteilID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			}
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
	//Abfrage der Items (Rahmen)
	public Rahmen[] getAllRahmen() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from Rahmen";
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = getCount("Rahmen");
			Rahmen[] rahmen = new Rahmen[size];
			int count = 0;
			while(rs.next()) {
				rahmen[count] = new Rahmen(rs.getInt("RahmenID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			}
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
	public int getCount(String type) throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select count(*) as count from "+type;
			PreparedStatement statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			if(rs.next()) {
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
