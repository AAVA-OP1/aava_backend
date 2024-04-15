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

    private String nimi;
    private String kyselynKuvaus;

    // Relaatio
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
    @JsonIgnoreProperties("kysely")
    private List<Kysymys> kysymykset;

    @ManyToOne
    @JsonIgnoreProperties("kyselyt")
    @JoinColumn(name = "tekijaid")
    private KyselynTekija kyselynTekija;


    public Kysely() {
        
    }

    // Konstruktori
    public Kysely(KyselynTekija kyselynTekija, String nimi, String kyselynKuvaus) {
        this.kyselynTekija = kyselynTekija;
        this.nimi = nimi;
        this.kyselynKuvaus = kyselynKuvaus;
    }

    // Getterit ja setterit

    
    public String getKyselynKuvaus() {
        return kyselynKuvaus;
    }

    public void setKyselynKuvaus(String kyselynKuvaus) {
        this.kyselynKuvaus = kyselynKuvaus;
    }

    public long getKyselyid() {
        return kyselyid;
    }

    public void setKyselyid(long kyselyid) {
        this.kyselyid = kyselyid;
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


    public KyselynTekija getKyselynTekija() {
        return kyselynTekija;
    }

    public void setKyselynTekija(KyselynTekija kyselynTekija) {
        this.kyselynTekija = kyselynTekija;
    }

    @Override
    public String toString() {
        return "Kysely [kyselyid=" + kyselyid + ", nimi=" + nimi + "]";
    }


    
}
