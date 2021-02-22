import data.DBManager;
import data.interfaces.ForMna;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import repositories.MedRepos;
import repositories.interfaces.ForMedRepos;

public class MyAppB extends AbstractBinder {

    @Override
    protected void configure()
    {
        bind(DBManager.class).to(ForMna.class);
        
        bind(MedRepos.class).to(ForMedRepos.class);
    }
}
