package sqlverbindung;

public class Oberteil {
	private int oberteilid;
	private String bezeichnung;
	private String bild;
	private int preis;
	private String typ;
	
	public Oberteil(int oberteilid, String bezeichnung, String bild, int preis, String typ) {
		this.oberteilid = oberteilid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
		this.typ = typ;
		this.preis = preis;
	}
	
	public int getOberteilID() {
		return oberteilid;	
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

