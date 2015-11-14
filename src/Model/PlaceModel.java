package Model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceModel {
    private String id;
    private String name;
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
}