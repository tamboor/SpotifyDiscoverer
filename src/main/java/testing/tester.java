package testing;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;

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
//
//
//        List<Track> tracks = getTracksFromTop(api , 500);
//
//        for (Track track : tracks) {
//            System.out.println("track");
//            System.out.println(track.getName());
////            for (:) {
//
//            }
        try {

            List<Track> tracks = new ArrayList<>();

            var request1 = api.getUsersTopTracks()
                    .time_range("long_term")
                    .build();
            var tracks1pagins = request1.execute();
            var tracks1list = tracks1pagins.getItems();
            tracks.addAll(Arrays.asList(tracks1list));

            var request2 = api.getUsersTopTracks()
                    .time_range("long_term")
                    .offset(20)
                    .build();
            var tracks2pagins = request2.execute();
            var tracks2list = tracks2pagins.getItems();
            tracks.addAll(Arrays.asList(tracks2list));

            var request3 = api.getUsersTopTracks()
                    .time_range("long_term")
                    .offset(40)
                    .build();
            var tracks3pagins = request3.execute();
            var tracks3list = tracks3pagins.getItems();
            tracks.addAll(Arrays.asList(tracks3list));

            var request4 = api.getUsersTopTracks()
                    .time_range("long_term")
                    .offset(60)
                    .build();
            var tracks4pagins = request4.execute();
            var tracks4list = tracks4pagins.getItems();
            tracks.addAll(Arrays.asList(tracks4list));


            for (Track track : tracks) {
                System.out.print(track.getArtists()[0].getName() + " - ");
                System.out.println(track.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


//    public static List<Track> getTracksFromTop(SpotifyApi api, Integer amount) {
//
//        List<Track> returnList = new ArrayList<>();
//        for (int i = 0; i <= (amount / 10)+1; i++) {
//            var request = api.getUsersTopTracks()
//                    .offset(i * 300)
//                    .build();
////            System.out.println("here " + i);
//            try {
//                Paging<Track> artistPaging = request.execute();
//                Track[] tracksArray = artistPaging.getItems();
//                for (Track track:tracksArray) {
//                    System.out.println(track.getName() );
//                }
//                returnList.addAll(Arrays.asList(tracksArray));
//            } catch (IOException | SpotifyWebApiException | ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        return returnList;
}



//https://open.spotify.com/artist/5JbXKReqHxzCVIrHTIvSIT?si=LIVdgeVcTEmndwHiDhzlcQ



