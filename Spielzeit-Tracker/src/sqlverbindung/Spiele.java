package sqlverbindung;

public class Spiele {
	
	private int spieleid;
	private int appid;
	private String name;
	
	public Spiele (int spieleid, int appid, String name) {
		this.spieleid = spieleid;
		this.appid = appid;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public int getSpielID() {
		return spieleid;
	}
	public int getAppID() {
		return appid;
	}
}
