package aava.kyselyprojekti.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PelkatKysymyset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kysymysid;

    private String sisalto;

   /*  private List<PelkatKysymyset> PelkatKysymyset; */

    // Relaatio
    @ManyToOne
    @JsonIgnoreProperties("kysymykset")
    @JoinColumn(name = "kyselyid")
    private Kysely kysely; 
 
  


    public PelkatKysymyset() {
        
    }

   


    public PelkatKysymyset(String sisalto/* , Kysely kysely */) {
        this.sisalto = sisalto;
        /* this.kysely = kysely; */
        
    }

    public long getKysymysid() {
        return kysymysid;
    }

    public void setKysymysid(long kysymysid) {
        this.kysymysid = kysymysid;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    @Override
    public String toString() {
        return "Kysymys [kysymysid=" + kysymysid + ", sisalto=" + sisalto + "]";
    }




   /*  public List<PelkatKysymyset> getPelkatKysymyset() {
        return PelkatKysymyset;
    } */




    /* public void setPelkatKysymyset(List<PelkatKysymyset> pelkatKysymyset) {
        PelkatKysymyset = pelkatKysymyset;
    }
 */
   /*  public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    } */

   



    

    
}