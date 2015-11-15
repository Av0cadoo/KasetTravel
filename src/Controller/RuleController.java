package Controller;

import Db.PlaceDbContext;
import Model.PlaceModel;
import Model.RuleModel;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saint on 11/13/2015.
 */
public class RuleController {
    private List<PlaceModel> lp = new ArrayList<PlaceModel>();
    private List<PlaceModel> lp2 = new ArrayList<PlaceModel>();
    private List<PlaceModel> lp3 = new ArrayList<PlaceModel>();
    private StatelessKieSession ks;
    List<String> commands = new ArrayList<String>();
    List<String> commands2 = new ArrayList<String>();
    List<String> commands3 = new ArrayList<String>();
    public RuleController(){

    }

    public List<PlaceModel> getResult(){
        return lp3;
    }
    public void addActivity(String s){
        commands.add(s);
    }

    public void addDate(String s){
        commands3.add(s);
    }

    public void addType(String s){
        commands2.add(s);
    }

    public void exec(){
        ks = new RuleModel("Rule/rules.drl").getKieSession();
        ks.setGlobal("resultList", lp);
        ks.setGlobal("ks", ks);
        ks.setGlobal("rc", this);
        ks.setGlobal("db", PlaceDbContext.getInstance());
        ks.execute(commands);

        ks = new RuleModel("Rule/type.drl").getKieSession();
        ks.setGlobal("resultList", lp2);
        ks.setGlobal("ks", ks);
        ks.setGlobal("rc", this);
        ks.execute(commands2);

        ks = new RuleModel("Rule/date.drl").getKieSession();
        ks.setGlobal("resultList", lp3);
        ks.setGlobal("ks", ks);
        ks.setGlobal("rc", this);
        ks.execute(commands3);
    }

    public void type(int x){

        for(int i = 0;i<lp.size();i++){

            if (lp.get(i).getType()==x){
                lp2.add(lp.get(i));
            }
        }
    }

    public void date(int x){
        for(int i = 0;i<lp2.size();i++) {
            for (int j = 0; j < lp2.get(i).getDate().length; j++) {
                if (x == lp2.get(i).getDate()[j]) {
                    if (lp3.contains(lp2.get(i))){
                        break;
                    }
                    lp3.add(lp2.get(i));
                    break;
                }
            }
        }
    }
}
