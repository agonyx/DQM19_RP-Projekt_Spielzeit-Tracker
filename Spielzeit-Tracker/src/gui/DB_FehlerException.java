package gui;

public class DB_FehlerException extends Exception {

	String messagString;
	
	public DB_FehlerException(String messagString) {
		this.messagString = messagString;
	}
	
	public String getMessage()
	{
		//Naricht die beim Fehler auftreten Ausgegeben werden soll.
		return messagString;
	}

}
