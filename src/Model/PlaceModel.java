package Model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceModel {
    private String id;
    private String name;
    private List<PlaceModel> placesList;
    public PlaceModel(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public JSONObject getJsonObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("Id", this.id);
            json.put("Name", this.name);
        }
        catch(JSONException e){
            System.out.println(e);
        }
        return json;
    }

    //init db
    public void init() throws ClassNotFoundException, SQLException {
        placesList = new ArrayList<PlaceModel>();
        for( int i = 0; i < 10; i++){
            placesList.add(new PlaceModel(i+"", "place "+1));
        }
    }

    public List getList(){
        return placesList;
    }
}
