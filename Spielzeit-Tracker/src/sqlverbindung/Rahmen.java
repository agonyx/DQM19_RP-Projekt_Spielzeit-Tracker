package sqlverbindung;

public class Rahmen {
	
	private int rahmenid;
	private String bezeichnung;
	private String bild;
	
	public Rahmen (int rahmenid, String bezeichnung, String bild) {
		this.rahmenid = rahmenid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
	}

	public int getRahmenID() {
		return rahmenid;
	}
}
