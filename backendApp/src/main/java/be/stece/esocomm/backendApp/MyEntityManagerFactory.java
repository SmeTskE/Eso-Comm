package be.stece.esocomm.backendApp;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Stece on 15/06/2014.
 */
public class MyEntityManagerFactory {

    private static final String PERSISTENCE_NAME = "esoCommBackendPersistence";

    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory(PERSISTENCE_NAME);

    private MyEntityManagerFactory() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }

}
