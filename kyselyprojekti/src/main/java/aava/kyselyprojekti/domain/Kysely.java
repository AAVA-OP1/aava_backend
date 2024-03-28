package aava.kyselyprojekti.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kyselyid;

    private String tekija;

    // Relaatio
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
    @JsonIgnoreProperties("kysely")
    private List<Kysymys> kysymykset;

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
