import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.model_objects.specification.User;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tester {

//    private final static St myClientId = "";

    public static void main(String[] args) {
        SpotifyAuth spotifyAuth = new SpotifyAuth();
        spotifyAuth.authorizationCodeUri_Sync();


        SpotifyApi api = spotifyAuth.spotifyApi;


        List<Track> tracks = getTracksFromTop(api , 500);

//        tracks.forEach(track -> {
//            System.out.println("Artist: " + Arrays.stream(track.getArtists()).map() + ", Song name: " + track.getName());
//        });
        for (Track track : tracks) {
            System.out.println("track");
            System.out.println(track.getName());
//            for (:) {

            }
        }



    public static List<Track> getTracksFromTop(SpotifyApi api, Integer amount) {

        List<Track> returnList = new ArrayList<>();
        for (int i = 0; i <= (amount / 10)+1; i++) {
            var request = api.getUsersTopTracks()
                    .offset(i * 100)
                    .build();
//            System.out.println("here " + i);
            try {
                Paging<Track> artistPaging = request.execute();
                Track[] tracksArray = artistPaging.getItems();
                for (Track track:tracksArray) {
                    System.out.println(track.getName() );
                }
                returnList.addAll(Arrays.asList(tracksArray));
            } catch (IOException | SpotifyWebApiException | ParseException e) {
                e.printStackTrace();
            }
        }
        return returnList;
    }
}


//https://open.spotify.com/artist/5JbXKReqHxzCVIrHTIvSIT?si=LIVdgeVcTEmndwHiDhzlcQ



