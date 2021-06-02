package sqlverbindung;

public class Avatar {
	
	private int avatarid;
	private int rahmenid;
	private int benutzerid;
	private int gesichterid;
	private int gbid;
	private int kopfbedeckungid;
	private int oberteilid;
	private int koerperid;
	
	public Avatar (int avatarid, int gesichterid, int gbid, int rahmenid, int benutzerid, int kopfbedeckungid, int oberteilid, int koerperid) {
		this.avatarid = avatarid;
		this.gesichterid = gesichterid;
		this.gbid = gbid;
		this.rahmenid = rahmenid;
		this.benutzerid = benutzerid;
		this.kopfbedeckungid = kopfbedeckungid;
		this.oberteilid = oberteilid;
		this.koerperid = koerperid;
	}
	
	/*public Avatar(int accessoireid, int kostuemid, int rahmenid, int benutzerid) {
		this.accessoireid = accessoireid;
		this.kostuemid = kostuemid;
		this.rahmenid = rahmenid;
		this.benutzerid = benutzerid;
	}*/
}