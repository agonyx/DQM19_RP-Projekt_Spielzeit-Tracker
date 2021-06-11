package sqlverbindung;

public class Gesichter {
	private int gesichterid;
	private String bezeichnung;
	private String bild;
	
	public Gesichter (int gesichterid, String bezeichnung, String bild) {
		this.gesichterid = gesichterid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
	}
	
	public int getGesichterID() {
		return gesichterid;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
}
