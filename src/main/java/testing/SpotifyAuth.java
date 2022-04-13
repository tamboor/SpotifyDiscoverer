package testing;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SpotifyAuth {
    final String SPOTIFY_CLIENT_ID = "e5cec03b64614ccda237a3cef93c392d";

    //TODO: move to enviromental value
    final String SPOTIFY_SECRET = System.getenv("SPOTIFY_SECRET");


    private final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080");

    public SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(SPOTIFY_CLIENT_ID)
            .setClientSecret(SPOTIFY_SECRET)
            .setRedirectUri(redirectUri)
            .build();

    private final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
            .scope("user-top-read user-library-read")
            .build();

    public void authorizationCodeUri_Sync() {
        final URI uri = authorizationCodeUriRequest.execute();

        System.out.println("URI: " + uri.toString());

        Scanner myObj = new Scanner(System.in);
            final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(myObj.nextLine())
                .build();


        final AuthorizationCodeCredentials authorizationCodeCredentials;
        try {
            authorizationCodeCredentials = authorizationCodeRequest.execute();
            System.out.println(authorizationCodeCredentials.getAccessToken());
//            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
//            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());


//            spotifyApi = SpotifyApi.builder()
//                    .setAccessToken(authorizationCodeCredentials.getAccessToken())
//                    .setRefreshToken(authorizationCodeCredentials.getRefreshToken())
//                    .setClientSecret(SPOTIFY_SECRET)
//                    .build();
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}




/*
{
name: nir
schiff: cute
}
 */