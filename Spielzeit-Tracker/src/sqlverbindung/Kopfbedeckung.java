package sqlverbindung;

public class Kopfbedeckung {
	private int kopfbedeckungenid;
	private String bezeichnung;
	private String bild;
	private int preis;

	public Kopfbedeckung(int kopfbedeckungenid, String bezeichnung, String bild) {
		this.kopfbedeckungenid = kopfbedeckungenid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
	}

	public int getKopfbedeckungsID() {
		return kopfbedeckungenid;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}

	public int getPreis() {
		return preis;
	}
}
