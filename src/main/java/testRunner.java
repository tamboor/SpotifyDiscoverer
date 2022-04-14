import auth.SpotifyAuthManager;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

import java.net.URI;
import java.util.Scanner;

public class testRunner {

    private static final String SPOTIFY_CLIENT_ID = "e5cec03b64614ccda237a3cef93c392d";
    private static final String SPOTIFY_SECRET = System.getenv("SPOTIFY_SECRET");
    private static final String REDIRECT_URL = "http://localhost:8080";


    public static void main(String[] args) {
        SpotifyApi api = SpotifyApi.builder()
                .setClientId(SPOTIFY_CLIENT_ID)
                .setClientSecret(SPOTIFY_SECRET)
                .setRedirectUri(SpotifyHttpManager.makeUri(REDIRECT_URL))
                .build();

        URI authenticateURI = SpotifyAuthManager.authorizeClient(api);

        System.out.println(authenticateURI);

        Scanner scanner = new Scanner(System.in);

        String code = scanner.nextLine();

        SpotifyAuthManager.setTokens(api , code);

    }
}
