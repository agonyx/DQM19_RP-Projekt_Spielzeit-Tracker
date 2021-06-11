package sqlverbindung;

public class Oberteil {
	private int oberteilid;
	private String bezeichnung;
	private String bild;
	private int preis;
	
	public Oberteil(int oberteilid, String bezeichnung, String bild) {
		this.oberteilid = oberteilid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
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
	
}

