import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by Saint on 11/12/2015.
 */
// The Java class will be hosted at the URI path "/api/test"
@Path("/api/test")
public class WebService {
    // The Java method will process HTTP GET requests
    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonProperty("Activities, Date")
    public Response findPlace(String json) {
        // Return some cliched textual content
        String activities = "invalid";
        String date = "invalid";
        JSONObject object;
        try {
            object = new JSONObject(json);
            activities = object.getString("Activities");
            date = object.getString("Date");
        }
        catch (JSONException e) {
            System.out.print(e);
        }

        String result = String.format("{\n" + "\t\"Activity\": \"%s\",\n" +
                                        "\t\"Date\": \"%s\"\n" + "}", activities, date);
        System.out.print(result);

        return Response.status(200).entity(result).build();
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
