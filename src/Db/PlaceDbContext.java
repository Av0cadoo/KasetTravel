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
        placesList.add(new PlaceModel("1", "place "+1, 1, 1, new int[]{1,2}));
        placesList.add(new PlaceModel("2", "place "+2, 2, 1, new int[]{3,4}));
        placesList.add(new PlaceModel("3", "place "+3, 3, 1, new int[]{4,5}));
        placesList.add(new PlaceModel("4", "place "+4, 2, 2, new int[]{4,3}));
        placesList.add(new PlaceModel("5", "place "+5, 1, 2, new int[]{6,7}));
        placesList.add(new PlaceModel("6", "place "+6, 3, 2, new int[]{8,9}));
        placesList.add(new PlaceModel("7", "place "+7, 1, 2, new int[]{10,11}));
        placesList.add(new PlaceModel("8", "place "+8, 2, 3, new int[]{11,12}));
        placesList.add(new PlaceModel("9", "place "+9, 2, 3, new int[]{10,12}));
        placesList.add(new PlaceModel("10", "place "+10, 1, 3, new int[]{1,2}));

//        for( int i = 0; i < 10; i++){
//            placesList.add(new PlaceModel(i+"", "place "+1));
//        }
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
