package Model;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceModel {
    private String id;
    private String name;
    private int act;
    private int type;
    private int[] date;
    public PlaceModel(String id, String name, int act, int type,int[] date){
        this.id = id;
        this.name = name;
        this.act = act;
        this.type = type;
        this.date = date;
    }
    public int getAct(){return this.act;}
    public int getType(){return this.type;}
    public int[] getDate(){return this.date;}
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