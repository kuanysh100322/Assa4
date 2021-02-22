import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyApp extends ResourceConfig {

    public MyApp() {

        register(new MyAppB());

        packages("con");
    }
}