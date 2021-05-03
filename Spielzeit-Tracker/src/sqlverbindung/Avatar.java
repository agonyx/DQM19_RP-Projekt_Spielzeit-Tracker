package sqlverbindung;

public class Avatar {
	
	private int avatarid;
	private int accessoireid;
	private int kostuemid;
	private int rahmenid;
	private int benutzerid;
	
	public Avatar (int avatarid, int accessoireid, int kostuemid, int rahmenid, int benutzerid) {
		this.avatarid = avatarid;
		this.accessoireid = accessoireid;
		this.kostuemid = kostuemid;
		this.rahmenid = rahmenid;
		this.benutzerid = benutzerid;
	}
	
	public Avatar(int accessoireid, int kostuemid, int rahmenid, int benutzerid) {
		this.accessoireid = accessoireid;
		this.kostuemid = kostuemid;
		this.rahmenid = rahmenid;
		this.benutzerid = benutzerid;
	}
}