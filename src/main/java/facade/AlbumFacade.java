package facade;

import beans.AppAlbum;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.util.Arrays;
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
}
