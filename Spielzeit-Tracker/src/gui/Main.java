package gui;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.playerstats.GetUserStatsForGame;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetUserStatsForGameRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

public class Main {

	public static void main(String[] args) {
		//Anmeldung a = new Anmeldung();
		//Ist ein Test
		try {
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
		GetUserStatsForGameRequest request = SteamWebApiRequestFactory.createGetUserStatsForGameRequest(730, "76561198422471034");
		GetUserStatsForGame gusfg = client.<GetUserStatsForGame> processRequest(request);
		System.out.println(gusfg);
		} catch (SteamApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
