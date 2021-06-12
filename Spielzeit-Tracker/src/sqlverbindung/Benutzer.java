package sqlverbindung;

public class Benutzer {

	private String username;
	private String passwort;
	private String steamid;
	private String email;
	private int benutzerid;
	private int punkte;
	private int admin;

	


	public Benutzer(int benutzerid, String username, String passwort, String steamid, String email, int punkte, int admin) {
		this.benutzerid = benutzerid;
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.punkte = punkte;
		this.admin = admin;
	}


	public Benutzer(String username, String passwort, String steamid, String email, int punkte, int admin) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.punkte = punkte;
		this.admin = admin;
	}
	public Benutzer(String username, String passwort, String steamid, String email, int punkte) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.punkte = punkte;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPasswort() {
		return passwort;
	}
	public String getSteamid() {
		return steamid;
	}
	public String getEmail() {
		return email;
	}
	public int getAdmin() {
		return admin;
	}
	public int getPunkte() {
		return punkte;
	}
	public int getID() {
		return benutzerid;
	}
}
