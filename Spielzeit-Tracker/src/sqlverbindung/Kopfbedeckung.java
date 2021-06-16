package sqlverbindung;

public class Kopfbedeckung {
	private int kopfbedeckungenid;
	private String bezeichnung;
	private String bild;
	private int preis;
	private String typ;

	public Kopfbedeckung(int kopfbedeckungenid, String bezeichnung, String bild, int preis, String typ) {
		this.kopfbedeckungenid = kopfbedeckungenid;
		this.bezeichnung = bezeichnung;
		this.bild = bild;
		this.typ = typ;
		this.preis = preis;
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
	public String getBild() {
		return bild;
	}
	public String getType() {
		return typ;
	}
}
