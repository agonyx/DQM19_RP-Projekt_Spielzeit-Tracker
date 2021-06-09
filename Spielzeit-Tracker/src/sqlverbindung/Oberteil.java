package sqlverbindung;

public class Oberteil {
	private int oberteilid;
	private String bezeichnung;
	private String bild;
	
	public Oberteil(int oberteilid, String bezeichnung, String bild) {
		this.oberteilid = oberteilid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
	}
	
	public int getOberteilID() {
		return oberteilid;	
	}
	
}

