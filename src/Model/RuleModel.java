package Model;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;

/**
 * Created by Saint on 11/12/2015.
 */
public class RuleModel {
    private StatelessKieSession ksession;

    public RuleModel(String drl){
        KieServices ks = KieServices.Factory.get();
        KieFileSystem kfs = ks.newKieFileSystem();
        kfs.write(ResourceFactory.newClassPathResource(drl));
        KieBuilder kbuilder = ks.newKieBuilder(kfs);
        kbuilder.buildAll();
        if (kbuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new IllegalArgumentException(kbuilder.getResults().toString());
        }
        ReleaseId relId = kbuilder.getKieModule().getReleaseId();
        KieContainer kcontainer = ks.newKieContainer(relId);
        KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
        KieBase kbase = kcontainer.newKieBase(kbconf);
        KieSessionConfiguration ksconf = ks.newKieSessionConfiguration();
        ksession = kbase.newStatelessKieSession(ksconf);
    }

    public StatelessKieSession getKieSession(){
        return this.ksession;
    }
}
