/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.SolidCode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha / mathias
 */
public class SolidCodeDTO {
    private long id;
    String studentName;
    String StudentId;
    String FavouriteTvSerires;

    public SolidCodeDTO(String studentName, String StudentId, String FavouriteTvSerires) {
        this.studentName = studentName;
        this.StudentId = StudentId;
        this.FavouriteTvSerires = FavouriteTvSerires;
    }
    
    public SolidCodeDTO(SolidCode rm) {
        this.id = rm.getId();
        this.studentName = rm.getStudentName();
        this.StudentId = rm.getStudentId();
        this.FavouriteTvSerires = rm.getFavouriteTvSerires();
    }
        public static List<SolidCodeDTO> getDtos(List<SolidCode> rms){
        List<SolidCodeDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new SolidCodeDTO(rm)));
        return rmdtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getFavouriteTvSerires() {
        return FavouriteTvSerires;
    }

    public void setFavouriteTvSerires(String FavouriteTvSerires) {
        this.FavouriteTvSerires = FavouriteTvSerires;
    }

    @Override
    public String toString() {
        return "GroupDTO{" + "id=" + id + ", studentName=" + studentName + ", StudentId=" + StudentId + ", FavouriteTvSerires=" + FavouriteTvSerires + '}';
    }

 

   
    
    
    
    
    
}
