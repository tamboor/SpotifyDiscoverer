import auth.SpotifyAuthManager;
import facade.AlbumFacade;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

import java.net.URI;
import java.util.Arrays;
import java.util.Scanner;

public class testRunner {

    private static final String SPOTIFY_CLIENT_ID = "e5cec03b64614ccda237a3cef93c392d";
    private static final String SPOTIFY_SECRET = System.getenv("SPOTIFY_SECRET");
    private static final String REDIRECT_URL = "http://localhost:8080";


    public static void main(String[] args) {

        System.out.println(SPOTIFY_SECRET);

        SpotifyApi api = SpotifyApi.builder()
                .setClientId(SPOTIFY_CLIENT_ID)
                .setClientSecret(SPOTIFY_SECRET)
                .setRedirectUri(SpotifyHttpManager.makeUri(REDIRECT_URL))
                .build();

        URI authenticateURI = SpotifyAuthManager.authorizeClient(api);

        System.out.println(authenticateURI);

        Scanner scanner = new Scanner(System.in);

        String code = scanner.nextLine();

        SpotifyAuthManager.setTokens(api, code);

        AlbumFacade albumFacade = new AlbumFacade(api);
//        albumFacade.getAlbumsByUserTopTracks(10 , 0);
//        Arrays.stream(albumFacade.getAlbumsByUserTopTracks(10, 50))
//                .forEach(System.out::println);
        albumFacade.getUserAlbums().forEach(savedAlbum -> {System.out.println(savedAlbum.getAddedAt());
            System.out.println(savedAlbum.getAlbum().getArtists() +" - " + savedAlbum.getAlbum().getName());});

    }
}
