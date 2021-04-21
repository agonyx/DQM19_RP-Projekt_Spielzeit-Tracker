package Main;


import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.appnews.GetNewsForApp;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetNewsForAppRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import de.SweetCode.SteamAPI.SteamAPI;
import de.SweetCode.SteamAPI.interfaces.ISteamNews;
import de.SweetCode.SteamAPI.interfaces.ISteamUserAuth;

public class Test {

    public static void main(String[] args) throws SteamApiException {
        SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("ED23A4A111A5CE836DA67ED9DB8CABE4").build();
        GetNewsForAppRequest request = SteamWebApiRequestFactory.createGetNewsForAppRequest(570); // appId of Dota 2
        GetNewsForApp getNewsForApp = client.<GetNewsForApp> processRequest(request);
        System.out.println(getNewsForApp.toString());
        SteamAPI clients = new SteamAPI("ED23A4A111A5CE836DA67ED9DB8CABE4");
        de.SweetCode.SteamAPI.method.methods.GetNewsForApp n = new de.SweetCode.SteamAPI.method.methods.GetNewsForApp(ISteamNews);

    }
}
