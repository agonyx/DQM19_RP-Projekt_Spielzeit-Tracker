package sqlverbindung;

public class Koerper {

	private int koerperid;
	private String bezeichnung;
	private String bilder;
	private int preis;

	public Koerper(int koerperid, String bezeichnung, String bilder) {
		this.koerperid=koerperid;
		this.bezeichnung=bezeichnung;
		this.bilder = bilder;
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
}
