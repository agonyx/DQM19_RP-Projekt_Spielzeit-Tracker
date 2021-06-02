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
	private PreparedStatement statement = null;
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

	public Gesichter[] getAllGesichter() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichter";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
			}
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
	
	public Gesichtsbedeckung[] getAllGesichtsbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Gesichtsbedeckung";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
				rs.first();
			}
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
	
	public Kopfbedeckung[] getAllKopfbedeckung() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Kopfbedeckung";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
				rs.first();
			}
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
	
	public Oberteil[] getAllOberteil() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Oberteil";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
				rs.first();
			}
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
	
	public Rahmen[] getAllRahmen() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Rahmen";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
				rs.first();
			}
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
}
