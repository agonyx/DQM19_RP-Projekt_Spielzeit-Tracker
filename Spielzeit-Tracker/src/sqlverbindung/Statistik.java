package sqlverbindung;

public class Statistik {
	
	private int statistikid;
	private double gesamtzeit;
	private double date; //welcher typ?
	private int punkte;
	
	public Statistik (int statistikenid, double gesamtzeit, double date, int punkte) {
		this.statistikid = statistikid;
		this.gesamtzeit = gesamtzeit;
		this.date = date;
		this.punkte = punkte;
	}

}