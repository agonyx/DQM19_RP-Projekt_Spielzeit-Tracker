package sqlverbindung;

public class Gesichter {
	private int gesichterid;
	private String bezeichnung;
	private String bild;
	private int preis;
	private String typ;
	
	public Gesichter (int gesichterid, String bezeichnung, String bild,String typ) {
		this.gesichterid = gesichterid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
		this.typ = typ;
	}
	
	public int getGesichterID() {
		return gesichterid;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public int getPreis() {
		return preis;
	}

	public String getBild() {
		return bild;
	}
	public String getType() {
		return typ;
	}
}
