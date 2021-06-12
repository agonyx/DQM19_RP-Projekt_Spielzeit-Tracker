package sqlverbindung;

public class Rahmen {
	
	private int rahmenid;
	private String bezeichnung;
	private String bild;
	private int preis;
	
	public Rahmen (int rahmenid, String bezeichnung, String bild) {
		this.rahmenid = rahmenid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
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
}
