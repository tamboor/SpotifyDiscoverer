package beans;

import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AppAlbum {
    private final String title;
    private final List<String> artistName;


    public AppAlbum(String title, List<String> artist) {
        this.title = title;
        this.artistName = artist;
    }

    public AppAlbum(AlbumSimplified albumSimplified) {
        this.title = albumSimplified.getName();
        ArtistSimplified[] artists = albumSimplified.getArtists();
        this.artistName = Arrays.stream(artists)
                .map(ArtistSimplified::getName).collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public List<String> getArtistName() {
        return artistName;
    }

    @Override
    public String toString() {
        return "AppAlbum{" +
                "title='" + title + '\'' +
                ", artistName=" + artistName.get(0) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppAlbum appAlbum = (AppAlbum) o;
        return Objects.equals(title, appAlbum.title) && Objects.equals(artistName, appAlbum.artistName);
    }
}
