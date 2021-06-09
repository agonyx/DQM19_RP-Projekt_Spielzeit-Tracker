package gui;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.playerstats.GetUserStatsForGame;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetUserStatsForGameRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

public class Main {

	public static void main(String[] args) {
		//Anmeldung a = new Anmeldung();
		
		try {
			System.out.println(getUserStatsForGame(730));
			System.out.println(getUserStatsForGame(1172470));
			System.out.println(getUserStatsForGame(594650));
			System.out.println(getUserStatsForGame(739630));
			System.out.println(getUserStatsForGame(493520));
			System.out.println(getUserStatsForGame(863550));
			
			
			
		} catch (SteamApiException e) {
			e.printStackTrace();
		}
	
	}
	private static String getUserStatsForGame(int appid) throws SteamApiException {
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
		GetUserStatsForGameRequest request = SteamWebApiRequestFactory.createGetUserStatsForGameRequest(appid, "76561198799205809");
		GetUserStatsForGame gusfg = client.<GetUserStatsForGame> processRequest(request);
		return gusfg.getPlayerstats().getStats().get(2).getValue().toString();
	}

}
