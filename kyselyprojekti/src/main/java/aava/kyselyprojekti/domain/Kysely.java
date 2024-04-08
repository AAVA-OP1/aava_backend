package aava.kyselyprojekti.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kyselyid;

    private KyselynTekija tekija;
    private String nimi;

    // Relaatio
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
    @JsonIgnoreProperties("kysely")
    private List<Kysymys> kysymykset;

    @ManyToOne
    @JsonIgnoreProperties("kyselyt")
    @JoinColumn(name = "kyselyid")
    private KyselynTekija kyselynTekija;

    public Kysely() {
        
    }

    // Konstruktori
    public Kysely(KyselynTekija tekija, String nimi) {
        this.tekija = tekija;
        this.nimi = nimi;
    }

    // Getterit ja setterit
    public long getKyselyid() {
        return kyselyid;
    }

    public void setKyselyid(long kyselyid) {
        this.kyselyid = kyselyid;
    }

    public KyselynTekija getTekija() {
        return tekija;
    }

    public void setTekija(KyselynTekija tekija) {
        this.tekija = tekija;
    }

    public List<Kysymys> getKysymykset() {
        return kysymykset;
    }

    public void setKysymykset(List<Kysymys> kysymykset) {
        this.kysymykset = kysymykset;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    // toString
    @Override
    public String toString() {
        return "Kysely [kyselyid=" + kyselyid + ", tekija=" + tekija + "]";
    }

}
