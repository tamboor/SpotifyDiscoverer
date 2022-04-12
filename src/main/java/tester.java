import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.User;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import java.io.IOException;
import java.util.Arrays;

public class tester {

//    private final static St myClientId = "";

    public static void main(String[] args) {
        SpotifyAuth spotifyAuth = new SpotifyAuth();
        spotifyAuth.authorizationCodeUri_Sync();


        SpotifyApi api = spotifyAuth.spotifyApi;
        var artists = api.getUsersTopArtists().build();
        try {
            Paging<Artist> artistPaging = artists.execute();
            Arrays.stream(artistPaging.getItems()).forEach(a -> System.out.println(a.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();
          final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = api.getCurrentUsersProfile()
                .build();

//            try {
//                final User user = getCurrentUsersProfileRequest.execute();
//
//                System.out.println("Display name: " + user.getDisplayName());
//            } catch (IOException | SpotifyWebApiException | ParseException e) {
//                System.out.println("Error: " + e.getMessage());
//            }

//        spotifyAuth.clientCredentials_Sync();
//
//        SpotifyApi spotifyApi = spotifyAuth.spotifyApi;
//
//        GetArtistRequest artistRequest = spotifyApi.getArtist("5JbXKReqHxzCVIrHTIvSIT").build();
//
//        try {
//            Artist rucci = artistRequest.execute();
//
//            System.out.println(rucci.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SpotifyWebApiException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
    }
}


//https://open.spotify.com/artist/5JbXKReqHxzCVIrHTIvSIT?si=LIVdgeVcTEmndwHiDhzlcQ



