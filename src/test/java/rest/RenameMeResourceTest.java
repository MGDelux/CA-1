package rest;

import entities.SolidCode;
import utils.EMF_Creator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.impl.bootstrap.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
//Uncomment the line below, to temporarily disable this test
@Disabled

public class RenameMeResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static SolidCode r1, r2,r3;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;



    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
         r1 = new SolidCode("Mathias", "cph-mt326","Game Of Thrones" );
         r2 = new SolidCode("Emil", "cph-ew45","Prison Break" );
         r3 = new SolidCode("Søren", "cph-sa343","brooklyn Nine-Nine");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("SolidCode.deleteAllRows").executeUpdate();
            em.persist(r1);
            em.persist(r2);
               em.persist(r3);
   
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    @AfterAll
    public static void closeTestServer() {
        //System.in.read();

        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
    
    }

    // Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the EntityClass used below to use YOUR OWN (renamed) Entity class


    @Test
    public void testServerIsUp() {
        System.out.println("Testing is server UP");
        given().when().get("/group/isalive").then().statusCode(200);
    }

    @Test
    public void doThisWhenYouHaveProblems(){
        given().log().all().when().get("/group/all").then().log().body();
    }
}
