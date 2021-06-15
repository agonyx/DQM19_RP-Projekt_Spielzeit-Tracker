package sqlverbindung;

public class Benutzer {

	private String username;
	private String passwort;
	private String steamid;
	private String email;
	private int benutzerid;
	private int punkte;
	private int admin;
	private String daybonustime;

	


	public Benutzer(int benutzerid, String username, String passwort, String steamid, String email, int punkte, int admin, String daybonustime) {
		this.benutzerid = benutzerid;
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.punkte = punkte;
		this.admin = admin;
		this.daybonustime = daybonustime;
	}


	public Benutzer(String username, String passwort, String steamid, String email, int punkte, int admin, String daybonustime) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.punkte = punkte;
		this.admin = admin;
		this.daybonustime = daybonustime;
	}
	public Benutzer(String username, String passwort, String steamid, String email, int punkte, String daybonustime) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.punkte = punkte;
		this.email = email;
		this.daybonustime = daybonustime;
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
	public boolean isAdmin() {
		if(admin == 1) {
			return true;
		}
		return false;
	}
	public int getPunkte() {
		return punkte;
	}
	public int getID() {
		return benutzerid;
	}
	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}
	
	
}
