//Nutzt die Steam Web API for Java von Ipradel https://github.com/lpradel/steam-web-api-java

package sqlverbindung;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.playerstats.GetUserStatsForGame;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetUserStatsForGameRequest;
import com.lukaspradel.steamapi.webapi.request.SteamWebApiRequest.SteamWebApiRequestBuilder;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

import gui.Hauptseite;

public class SteamAPI {
	
	private Benutzer benutzer = Hauptseite.getBenutzer();
	private SteamWebApiClient client;
	
	public SteamAPI() {
		client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
		
	}
	private String getUserStatsForGame(int appid, String steamid) throws SteamApiException {
		GetUserStatsForGameRequest request = SteamWebApiRequestFactory.createGetUserStatsForGameRequest(appid, steamid);
		GetUserStatsForGame gusfg = client.<GetUserStatsForGame> processRequest(request);
		return null;
	}
	
}
