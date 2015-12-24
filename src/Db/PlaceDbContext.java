package Db;

import Model.PlaceModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        InputStream fStream = null;
        fStream = getClass().getResourceAsStream("db.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

        String strLine;

        try {
            while( (strLine = br.readLine()) != null){
                String[] attr = strLine.split("\\|");
                String[] date = attr[attr.length-2].replace("[", "").replace("]", "").split(",");
                int[] dateInt = new int[date.length];
                for( int i = 0; i < dateInt.length; i++){
                    dateInt[i] = Integer.parseInt(date[i]);
                }
                placesList.add(new PlaceModel(attr[0], attr[1], Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), attr[4], attr[5], attr[6], attr[7],attr[8], attr[9], dateInt));

            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public PlaceModel findByName(String name){
        for( PlaceModel m : placesList){
             if(m.getName().equals(name)){
                 return m;
             }
        }
        return null;
    }

    public List<PlaceModel> findByActivity(int activity){
        List<PlaceModel> l = new ArrayList<PlaceModel>();
        for(PlaceModel m : placesList){
            if(m.getAct() == activity){
                l.add(m);
            }
        }
        return l;
    }

}
