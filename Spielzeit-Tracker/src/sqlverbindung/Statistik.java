package sqlverbindung;

public class Statistik {
	
	private int statistikid;
	private double gesamtzeit;
	private String date;
	
	public Statistik (int statistikid, double gesamtzeit, String date) {
		this.statistikid = statistikid;
		this.gesamtzeit = gesamtzeit;
		this.date = date;
	}
	
	public Statistik(double gesamtzeit, String date) {
		this.gesamtzeit = gesamtzeit;
		this.date = date;
	}
	
	public double getGesamtzeit() {
		return gesamtzeit;
	}
}