package sqlverbindung;

public class Gesichtsbedeckung {
	private int gbid;
	private String bezeichnung;
	private String bild;
	private int preis;

	public Gesichtsbedeckung(int gbid, String bezeichnung, String bild) {
		this.gbid = gbid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
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
}
