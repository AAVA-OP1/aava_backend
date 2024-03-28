package aava.kyselyprojekti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kysymys {    


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kysymysid;
    
    private String sisalto;

    public Kysymys() {
        this.kysymysid = 0;
        this.sisalto = null;
    }

    public Kysymys(long kysymysid, String sisalto) {
        this.kysymysid = kysymysid;
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
