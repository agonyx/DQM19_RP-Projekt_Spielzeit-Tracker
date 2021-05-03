package sqlverbindung;

public class Benutzer {

	private String username;
	private String passwort;
	private String steamid;
	private String email;
	private int benutzerid;
	private int admin;
	
	public Benutzer(int benutzerid, String username, String passwort, String steamid, String email, int admin) {
		this.benutzerid = benutzerid;
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.admin = admin;
	}
	
	public Benutzer(String username, String passwort, String steamid, String email, int admin) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
		this.email = email;
		this.admin = admin;
	}
	public Benutzer(String username, String passwort, String steamid, String email) {
		this.username = username;
		this.passwort = passwort;
		this.steamid = steamid;
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
}
