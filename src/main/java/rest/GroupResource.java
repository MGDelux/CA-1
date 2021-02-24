package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.SolidCodeDTO;
import utils.EMF_Creator;
import facades.GroupFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("group")
public class GroupResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final GroupFacade FACADE =  GroupFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
     @Path("isalive")    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"SolidCode API is up\"}";
    }
   
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        List<SolidCodeDTO> teamMemembers = FACADE.getAll();        
        return GSON.toJson(teamMemembers);
    }
    
    @Path("byid/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getById(@PathParam("id") long id) {
        SolidCodeDTO movie = FACADE.getById(id);        
        return GSON.toJson(movie);
    }
}
