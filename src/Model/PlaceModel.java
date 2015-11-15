package Model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceModel {
    private String id;
    private String name;
    private int act;
    private int date;
    private int type;
    public PlaceModel(String id, String name, int act, int type){
        this.id = id;
        this.name = name;
        this.act = act;
        this.type = type;
    }
    public int getAct(){return this.act;}
    public int getType(){return this.type;}
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