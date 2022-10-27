import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PessoaService {
    private static HttpClient client = HttpClient.newHttpClient();
    private final String url;

    public void listar(){
        try{
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            var response = client.send(request, BodyHandlers.ofString());
            System.out.println(response.body());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
