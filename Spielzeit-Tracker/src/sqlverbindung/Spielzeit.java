package sqlverbindung;

public class Spielzeit {
	
	private int spielzeitid;
	private int benutzerid;
	private int spieleid;
	private double spielzeit;
	
	public Spielzeit (int spielzeitid, int benutzerid, int spieleid, double spielzeit) {
		this.spielzeitid = spielzeitid;
		this.benutzerid = benutzerid;
		this.spieleid = spieleid;
		this.spielzeit = spielzeit;
	}

}
