package facade;

import beans.AppAlbum;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class AlbumFacade {
    private final SpotifyApi api;

    public AlbumFacade(SpotifyApi api) {
        this.api = api;
    }


    public AppAlbum getAlbumByTrack(Track track) {
        return new AppAlbum(track.getAlbum().getName(),
                Arrays.stream(track.getAlbum().getArtists()).map(a -> a.getName()).collect(Collectors.toList()));
    }

    public AppAlbum[] getAlbumsByUserTopTracks(int limit, int offset) {
        List<Album> albumList = new ArrayList<>();
        while (albumList.size() < 10) {
            GetUsersTopTracksRequest tracksRequest = api.getUsersTopTracks()
                    .offset(offset)
                    .limit(limit).build();


            try {
                Paging<Track> trackPaging = tracksRequest.execute();
                List<Track> trackList = Arrays.asList(trackPaging.getItems());
                //TODO: check if duplicate albums apear in list
//                for (Track track : trackList) {
//                    AlbumSimplified currAlbum = track.getAlbum();
//                    for (:
//                         ) {
//
//                    }
//                }

                //TODO: handle this shit
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SpotifyWebApiException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
