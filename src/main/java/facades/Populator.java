/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.SolidCodeDTO;
import entities.SolidCode;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        GroupFacade fe = GroupFacade.getFacade(emf);
        fe.create(new SolidCodeDTO("Mathias", "cph-mt326","GOT"));
        fe.create(new SolidCodeDTO( "Emil", "Last 2","TBD"));
        fe.create(new SolidCodeDTO( "Søren", "Last 3","TBD"));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
