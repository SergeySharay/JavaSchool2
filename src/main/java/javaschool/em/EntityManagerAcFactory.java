package javaschool.em;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAcFactory {
    private static class Hodor {
        private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clients");
    }

    public static EntityManagerAc createEntityManagerAc() {
        return new EntityManagerAcImpl(Hodor.entityManagerFactory.createEntityManager());
    }
}
