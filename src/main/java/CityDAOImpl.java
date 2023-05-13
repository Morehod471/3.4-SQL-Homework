import javax.persistence.*;

public class CityDAOImpl implements CityDAO {

    @Override
    public void mergeCity(City city) {

        EntityManager entityManager = CityDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void saveCity(City city) {

        EntityManager entityManager = CityDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = CityDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void selectCity(City city, int a) {

        EntityManager entityManager = CityDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.find(City.class, a);

        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }
}
