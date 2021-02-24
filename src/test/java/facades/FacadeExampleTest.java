package facades;

import utils.EMF_Creator;
import entities.SolidCode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static GroupFacade facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
                EMF_Creator.startREST_TestWithDB();
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = GroupFacade.getFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }
@Test
public void testDBNotNull(){
            EntityManager em = emf.createEntityManager();
 int db_size = facade.getAll().size();
 try{
     if (db_size >= 1){
         System.out.println("<1");
          em.getTransaction().begin();
            em.persist(new SolidCode("Mathias B", "cph-TEST","test-movie"));
             em.persist(new SolidCode("Emil W", "cph-TEST","test-movie"));
              em.persist(new SolidCode("Søren D", "cph-TEST","test-movie"));
            em.getTransaction().commit();
     }else{
         System.out.println(">1");
          em.getTransaction().begin();
            em.persist(new SolidCode("Mathias B", "cph-TEST","test-movie"));
             em.persist(new SolidCode("Emil W", "cph-TEST","test-movie"));
              em.persist(new SolidCode("Søren D", "cph-TEST","test-movie"));
            em.getTransaction().commit();
     }
 }finally{
                 em.close();

 }
}
    // TODO: Delete or change this method 

    

}
