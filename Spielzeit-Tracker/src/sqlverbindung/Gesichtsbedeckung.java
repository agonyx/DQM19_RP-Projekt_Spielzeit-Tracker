package sqlverbindung;

public class Gesichtsbedeckung {
	private int gbid;
	private String bezeichnung;
	private String bild;
	private int preis;
	private String typ;

	public Gesichtsbedeckung(int gbid, String bezeichnung, String bild, String typ) {
		this.gbid = gbid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
		this.typ = typ;
	}

	public int getGBID() {
		return gbid;
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
