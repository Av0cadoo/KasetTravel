package Db;

import Model.PlaceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saint on 11/14/2015.
 */
public class PlaceDbContext{

    public List<PlaceModel> placesList;
    private static PlaceDbContext instance;

    private PlaceDbContext(){
        placesList = new ArrayList<PlaceModel>();
        for( int i = 0; i < 10; i++){
            placesList.add(new PlaceModel(i+"", "place "+1));
        }
    }

    public static PlaceDbContext getInstance(){
        if (instance == null)
        {
            instance = new PlaceDbContext();
        }
        return instance;
    }

    public List<PlaceModel> all(){
        return placesList;
    }

    public void add(PlaceModel m){
        placesList.add(m);
    }

    public PlaceModel findById(int id){
        return placesList.get(id);
    }

    public PlaceModel findByName(String name){
        for( PlaceModel m : placesList){
             if(m.getName().equals(name)){
                 return m;
             }
        }
        return null;
    }
}
