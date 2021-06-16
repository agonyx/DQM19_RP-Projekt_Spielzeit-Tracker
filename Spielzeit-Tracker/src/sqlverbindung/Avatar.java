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
	
	public Avatar ( int gesichterid, int gbid, int rahmenid, int benutzerid, int kopfbedeckungid, int oberteilid, int koerperid) {
		this.gesichterid = gesichterid;
		this.gbid = gbid;
		this.rahmenid = rahmenid;
		this.benutzerid = benutzerid;
		this.kopfbedeckungid = kopfbedeckungid;
		this.oberteilid = oberteilid;
		this.koerperid = koerperid;
	}

	public int getAvatarid() {
		return avatarid;
	}

	public int getRahmenid() {
		return rahmenid;
	}

	public int getBenutzerid() {
		return benutzerid;
	}

	public int getGesichterid() {
		return gesichterid;
	}

	public int getGbid() {
		return gbid;
	}

	public int getKopfbedeckungid() {
		return kopfbedeckungid;
	}

	public int getOberteilid() {
		return oberteilid;
	}

	public int getKoerperid() {
		return koerperid;
	}

	public void setAvatarid(int avatarid) {
		this.avatarid = avatarid;
	}

	public void setRahmenid(int rahmenid) {
		this.rahmenid = rahmenid;
	}

	public void setBenutzerid(int benutzerid) {
		this.benutzerid = benutzerid;
	}

	public void setGesichterid(int gesichterid) {
		this.gesichterid = gesichterid;
	}

	public void setGbid(int gbid) {
		this.gbid = gbid;
	}

	public void setKopfbedeckungid(int kopfbedeckungid) {
		this.kopfbedeckungid = kopfbedeckungid;
	}

	public void setOberteilid(int oberteilid) {
		this.oberteilid = oberteilid;
	}

	public void setKoerperid(int koerperid) {
		this.koerperid = koerperid;
	}
}