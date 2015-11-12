package Manager;

import Model.PlaceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saint on 11/12/2015.
 */
public class PlaceManager {
    private List<PlaceModel> places = new ArrayList<PlaceModel>();

    public PlaceManager(){
        for(int i = 0; i < 5; i++){
            places.add(new PlaceModel(""+i, "Place"+i));
        }
    }

    public PlaceModel findById(int id){
        return places.get(id);
    }

    public void addPlace(PlaceModel model){
        places.add(model);
    }
}
