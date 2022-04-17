package auth;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import testing.SpotifyAuth;

import java.io.IOException;
import java.net.URI;

public class SpotifyAuthManager {

    public static URI authorizeClient(SpotifyApi api) {
        AuthorizationCodeUriRequest request = api.authorizationCodeUri()
                .scope("user-top-read user-library-read")
                .build();

        return request.execute();
    }

    public static void setTokens(SpotifyApi api, String code) {
        AuthorizationCodeRequest tokensRequest = api.authorizationCode(code)
                .build();

        try {
            AuthorizationCodeCredentials credentials = tokensRequest.execute();

            api.setAccessToken(credentials.getAccessToken());
            api.setRefreshToken(credentials.getRefreshToken());
            //TODO: handle all this shit(throw custom exception)
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
