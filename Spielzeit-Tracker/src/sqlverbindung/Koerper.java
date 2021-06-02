package sqlverbindung;

public class Koerper {
	
	private int koerperid;
	private String bezeichnung;
	private String bilder;
	
	public Koerper(int koerperid, String bezeichnung, String bilder) {
		this.koerperid=koerperid;
		this.bezeichnung=bezeichnung;
		this.bilder = bilder;
	}

}
