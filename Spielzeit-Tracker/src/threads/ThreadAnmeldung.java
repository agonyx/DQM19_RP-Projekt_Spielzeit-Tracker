package threads;

import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOStatistik;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Spiele;

public class ThreadAnmeldung extends Thread{
	private DAOStatistik ds = new DAOStatistik();
	private DAOGetandSet d = new DAOGetandSet();
	private Benutzer ben;

	public ThreadAnmeldung(Benutzer ben) {
		super();
		this.ben = ben;

	}
	public void run()  {
		System.out.println("[System] ThreadAnmeldung is running");
		try {
			if(!ds.doesStatistikForUserExist(ben)) {
				ds.createStatistikForUser(ben);
			}
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
		try {
			Spiele[] games = d.getAllGames();
			for(int i = 0; i < games.length; i++) {
				if (!d.doesSpielzeitEntryExist(ben, games[i])) {
					System.out.println("kommt rein");
					d.createSpielzeitEntry(ben, games[i]);
				}
			}
		} catch (DB_FehlerException e) {
			System.out.println("[System Error] Spielzeit Einträge existieren bereits");
		}

	}
}