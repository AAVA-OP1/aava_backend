package aava.kyselyprojekti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kyselyid;

    private String tekija;

    public Kysely() {
        this.kyselyid = 0;
        this.tekija = null;
    }

    public Kysely(String tekija) {
        this.tekija = tekija;
    }
    
    public long getKyselyid() {
        return kyselyid;
    }

    public void setKyselyid(long kyselyid) {
        this.kyselyid = kyselyid;
    }

    public String getTekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    @Override
    public String toString() {
        return "Kysely [kyselyid=" + kyselyid + ", tekija=" + tekija + "]";
    }

    

}
