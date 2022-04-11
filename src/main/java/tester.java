import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public class tester {

//    private final static St myClientId = "";

    public static void main(String[] args) {

//        final String SPOTIFY_CLIENT_ID = "e5cec03b64614ccda237a3cef93c392d";
//        final String SPOTIFY_SECRET = "c3f46c9f3e6d4eec8989cbdadc6c9dbd";
//
//        SpotifyApi spotifyApi = SpotifyApi.builder()
//                .setClientId(SPOTIFY_CLIENT_ID)
//                .setClientSecret(SPOTIFY_SECRET)
//                .build();
//
//        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
//                .build();
//    }
//
//
//    public static void clientCredentials_Sync() {
//        try {
//            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
//
//            // Set access token for further "spotifyApi" object usage
//            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
//
//            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
//        } catch (IOException | SpotifyWebApiException | ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//
//    public static void clientCredentials_Async() {
//        try {
//            final CompletableFuture<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest.executeAsync();
//
//            // Thread free to do other tasks...
//
//            // Example Only. Never block in production code.
//            final ClientCredentials clientCredentials = clientCredentialsFuture.join();
//
//            // Set access token for further "spotifyApi" object usage
//            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
//
//            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
//        } catch (CompletionException e) {
//            System.out.println("Error: " + e.getCause().getMessage());
//        } catch (CancellationException e) {
//            System.out.println("Async operation cancelled.");
//        }
//    }
}}



