package sqlverbindung;

public class Koerper {

	private int koerperid;
	private String bezeichnung;
	private String bilder;
	private int preis;
	private String typ;

	public Koerper(int koerperid, String bezeichnung, String bilder, int preis, String typ) {
		this.koerperid=koerperid;
		this.bezeichnung=bezeichnung;
		this.bilder = bilder;
		this.typ = typ;
		this.preis = preis;
	}
	public int getKoerperID() {
		return koerperid;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public int getPreis() {
		return preis;
	}
	public String getBild() {
		return bilder;
	}
	public String getType() {
		return typ;
	}
}
