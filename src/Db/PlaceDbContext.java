package Db;

import Model.PlaceModel;

import java.io.*;
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
        FileInputStream fStream = null;
        try {
            fStream = new FileInputStream("/Users/patawat/Desktop/KasetTravel/src/Db/db.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

        String strLine;

        try {
            while( (strLine = br.readLine()) != null){
                String[] attr = strLine.split("\\|");
                String[] date = attr[attr.length-1].replace("[", "").replace("]", "").split(",");
                int[] dateInt = new int[date.length];
                for( int i = 0; i < dateInt.length; i++){
                    dateInt[i] = Integer.parseInt(date[i]);
                }
                placesList.add(new PlaceModel(attr[0], attr[1], Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), attr[4], attr[5], attr[6], attr[7], dateInt));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        placesList = new ArrayList<PlaceModel>();
//        placesList = new ArrayList<PlaceModel>();
//        placesList.add(new PlaceModel("1", "place "+1, 1, 1, new int[]{1,2}));
//        placesList.add(new PlaceModel("2","place "+2, 2, 1, new int[]{3,4}));
//        placesList.add(new PlaceModel("3","place "+3, 3, 1, new int[]{4,5}));
//        placesList.add(new PlaceModel("4","place "+4, 2, 2, new int[]{4,3}));
//        placesList.add(new PlaceModel("5","place "+5, 1, 2, new int[]{6,7}));
//        placesList.add(new PlaceModel("6","place "+6, 3, 2, new int[]{8,9}));
//        placesList.add(new PlaceModel("7","place "+7, 1, 2, new int[]{10,11}));
//        placesList.add(new PlaceModel("8","place "+8, 2, 3, new int[]{11,12}));
//        placesList.add(new PlaceModel("9","place "+9, 2, 3, new int[]{10,12}));
//        placesList.add(new PlaceModel("10","place "+10, 1, 3, new int[]{1,2}));
//        placesList.add(new PlaceModel("11","place "+10, 1, 3, new int[]{1,2}));

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
