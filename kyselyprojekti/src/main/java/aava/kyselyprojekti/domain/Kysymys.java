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
        this.kysymysid = 0;
        this.sisalto = null;
    }

    public Kysymys(String sisalto) {
        this.sisalto = sisalto;
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

    

    
}
