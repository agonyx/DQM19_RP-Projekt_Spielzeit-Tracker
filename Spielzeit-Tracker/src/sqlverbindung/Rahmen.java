package sqlverbindung;

public class Rahmen {
	
	private int rahmenid;
	private String bezeichnung;
	private String bild;
	private int preis;
	private String typ;
	
	public Rahmen (int rahmenid, String bezeichnung, String bild, int preis, String typ) {
		this.rahmenid = rahmenid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
		this.typ = typ;
		this.preis = preis;
	}

	public int getRahmenID() {
		return rahmenid;
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
