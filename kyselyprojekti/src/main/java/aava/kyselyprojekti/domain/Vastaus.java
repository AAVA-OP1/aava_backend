package aava.kyselyprojekti.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vastaus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vastausid;
    private String vastaus;

    // Relaatio
    @ManyToOne
    @JsonIgnoreProperties("vastaukset")
    @JoinColumn(name = "kysymysid")
    private Kysymys kysymys;

    public Vastaus(String vastaus) {
        this.vastaus = vastaus;
    }

    public Vastaus() {

    }

    public Long getVastausid() {
        return vastausid;
    }

    public void setVastausid(Long vastausid) {
        this.vastausid = vastausid;
    }

    public String getVastaus() {
        return vastaus;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

    public Kysymys getKysymys() {
        return kysymys;
    }

    public void setKysely(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

    @Override
    public String toString() {
        return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + ", kysymys=" + kysymys + "]";
    }

}
