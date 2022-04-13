package beans;

import java.util.List;

public class AppAlbum {
    public String title;
    public List<String> artistName;

    public AppAlbum(String title, List<String> artist) {
        this.title = title;
        this.artistName = artist;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getArtistName() {
        return artistName;
    }
}
