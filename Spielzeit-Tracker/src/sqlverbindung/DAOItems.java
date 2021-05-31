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
	private Accessoire accessoire;
	private Kostuem kostuem;
	private Rahmen rahmen;

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

			String sql = "select * from Accessoires";
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery();
			int size = 0;
			if(rs!=null) {
				rs.last();
				size = rs.getRow();
			}
			Kostuem[] kostuem = new Kostuem[size];
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
}
