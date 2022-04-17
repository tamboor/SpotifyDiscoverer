package facade;

import beans.AppAlbum;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.AlbumType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.exceptions.detailed.UnauthorizedException;
import se.michaelthelin.spotify.model_objects.specification.*;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AlbumFacade {
    private final SpotifyApi api;

    public AlbumFacade(SpotifyApi api) {
        this.api = api;
    }


    public AppAlbum getAlbumByTrack(Track track) {
        return new AppAlbum(track.getAlbum().getName(),
                Arrays.stream(track.getAlbum().getArtists()).map(ArtistSimplified::getName).collect(Collectors.toList()));
    }

    public List<SavedAlbum> getUserAlbums() {

        List<SavedAlbum> albums = new ArrayList<>();

        var request = api.getCurrentUsersSavedAlbums()
                .offset(10000)
                .limit(10)
                .build();

        try {
            var res = request.execute();


            albums.addAll(Arrays.asList(res.getItems()));


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return albums;
    }

//    public void getSavedAlbums


    public AppAlbum[] getAlbumsByUserTopTracks(int limit, int offset) {
        Set<AppAlbum> appAlbums = new HashSet<>();
        int processCounter = 0;
        int debugCounter = 1;
        while (processCounter < limit) {
            System.out.println("Run number " + debugCounter);
            GetUsersTopTracksRequest tracksRequest = api.getUsersTopTracks()
                    .time_range("long_term")
                    .offset(offset + processCounter)
                    .limit(limit - processCounter)
                    .build();
            try {
                Paging<Track> trackPaging = tracksRequest.execute();
                Track[] tracks = trackPaging.getItems();

                for (Track track : tracks) {
                    appAlbums.add(new AppAlbum(track.getAlbum()));


                }

            } catch (IOException | SpotifyWebApiException | ParseException e) {
//                //TODO: handle this shit
                e.printStackTrace();
            }
            debugCounter++;
//            appAlbums.forEach(System.out::println);
            processCounter = appAlbums.size();
        }

        return appAlbums.toArray(new AppAlbum[limit]);
    }
    /*

     */
//    public AppAlbum[] getAlbumsByUserTopTracks(int limit, int offset) {
//        List<AppAlbum> albumList = new ArrayList<>();
//        int processCounter = 0;
//
//        while (processCounter <= limit) {
//            GetUsersTopTracksRequest tracksRequest = api.getUsersTopTracks()
//                    .time_range("long_term")
//                    .offset(processCounter)
//                    .limit(limit - processCounter)
//                    .build();
//
//            try {
//                Paging<Track> trackPaging = tracksRequest.execute();
////                System.out.println(trackPaging.getItems());
//                Arrays.stream(trackPaging.getItems()).forEach(System.out::println);
//                Set<AppAlbum> albums = Arrays.stream(trackPaging.getItems())
//                        .filter(track -> track.getAlbum().getAlbumType() == AlbumType.ALBUM)
//                        .map(track -> new AppAlbum(track.getAlbum()))
//                        .collect(Collectors.toSet());
//                albumList.addAll(albums);
//
////                System.out.println(albumList);
//
//            } catch (IOException | SpotifyWebApiException | ParseException e) {
//                //TODO: handle this shit
//                e.printStackTrace();
//            }
//
//            //TODO: add general exception cath for itai
//            processCounter = albumList.size();
//            System.out.println(processCounter);
//        }
//
//        return albumList.toArray(new AppAlbum[limit]);
//    }

}
