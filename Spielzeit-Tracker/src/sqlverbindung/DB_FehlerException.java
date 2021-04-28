package sqlverbindung;

public class DB_FehlerException extends Exception{

	private String message;
	
	public DB_FehlerException(String nachricht) {
		this.message = nachricht;
	}
	
	public String getMessage() {
		return message;
	}
}
