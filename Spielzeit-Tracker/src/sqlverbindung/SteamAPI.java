//Nutzt die Steam Web API for Java von Ipradel https://github.com/lpradel/steam-web-api-java

package sqlverbindung;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.ownedgames.Game;
import com.lukaspradel.steamapi.data.json.ownedgames.GetOwnedGames;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetOwnedGamesRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

import gui.Hauptseite;

public class SteamAPI {


	private SteamWebApiClient client;

	public SteamAPI() {
		client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
	}
	public int getTotalPlaytimeHours(String steamid, Integer[] appids) throws SteamApiException{
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		hashmap = getPlaytimeForGamesIfOwned(steamid,appids);
		int spielzeit = 0;
		for(int i = 0 ; i<appids.length; i++) {
			if (hashmap.get(appids[i]) != null) {
				spielzeit += hashmap.get(appids[i]);
			}
		}
		return spielzeit;
	}
	//Gibt eine HashMap, mit AppIds als Key, wieder aus der Spielzeit f�r jedes Game, dass f�r die Suche beigef�gt wurde (Integer[] games), entnommen werden kann
	public HashMap<Integer, Integer> getPlaytimeForGamesIfOwned(String steamid,Integer[] appids) throws SteamApiException{
		SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
		GetOwnedGamesRequest request = SteamWebApiRequestFactory.createGetOwnedGamesRequest(steamid);
		GetOwnedGames gowg = client.<GetOwnedGames> processRequest(request);
		//Speichere Resultset der Anfrage als List
		if (!gowg.getResponse().getGames().isEmpty()) {
		List<Game> s = gowg.getResponse().getGames();
		//Mache den Array zu einer Liste um Contains nutzen zu k�nnen
		List<Integer> ga = Arrays.asList(appids);
		//HashMap wird erstellt
		HashMap<Integer, Integer> result = new HashMap<>();
		for(int i = 0; i < s.size(); i++) {
			if (ga.contains(s.get(i).getAppid())) {
				result.put(s.get(i).getAppid(), s.get(i).getPlaytimeForever());
			}
		}
		return result;
		} else {
			throw new SteamApiException("NO STEAM RESPONSE");
		}
	}

}
