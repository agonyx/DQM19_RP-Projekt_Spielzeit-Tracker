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

	public Accessoire[] getAllAccessoire() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Accessoires";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
			}
			Accessoire[] accessoiree = new Accessoire[size];
			int count = 0;
			while(rs.next()) {
				accessoiree[count] = new Accessoire(rs.getInt("AccessoiresID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			} 
			return accessoiree;
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
	public Kostuem[] getAllKostuem() throws DB_FehlerException {
		try {
			conn = DriverManager.getConnection(url);

			String sql = "select * from Kostuem";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
				rs.first();
			}
			Kostuem[] kostuem = new Kostuem[size];
			int count = 0;
			while(rs.next()) {
				kostuem[count] = new Kostuem(rs.getInt("KostuemID"),rs.getString("Bezeichnung"), rs.getString("Bilder"));
				count++;
			} 
			return kostuem;
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
