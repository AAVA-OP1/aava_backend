package aava.kyselyprojekti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Kysymys {    


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kysymysid;

    private String sisalto;

    // Relaatio
    @ManyToOne
    @JsonIgnoreProperties("kysymykset")
    @JoinColumn(name = "kyselyid")
    private Kysely kysely; 

    public Kysymys() {
        
    }

    public Kysymys(String sisalto, Kysely kysely) {
        this.sisalto = sisalto;
        this.kysely = kysely;
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

    public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    

    
}
