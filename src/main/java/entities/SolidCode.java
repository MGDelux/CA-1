package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "SolidCode.deleteAllRows", query = "DELETE from SolidCode")
public class SolidCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String studentName;
   private String StudentId;
   private String FavouriteTvSerires;
    
    
    public SolidCode() {
    }  

    public SolidCode( String studentName, String StudentId, String FavouriteTvSerires) {
        this.studentName = studentName;
        this.StudentId = StudentId;
        this.FavouriteTvSerires = FavouriteTvSerires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "Group{" + "id=" + id + ", studentName=" + studentName + ", StudentId=" + StudentId + ", FavouriteTvSerires=" + FavouriteTvSerires + '}';
    }
    
   
    

   
}
