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
public class KyselynTekija {

    // hallojaa

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tekijaid;

    private String nimi;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kyselynTekija")
    @JsonIgnoreProperties("kyselynTekija")
    private List<Kysely> kyselyt;

    public KyselynTekija() {

    }

    public KyselynTekija(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Long getTekijaid() {
        return tekijaid;
    }

    public void setTekijaid(Long tekijaid) {
        this.tekijaid = tekijaid;
    }

    
    @Override
    public String toString() {
        return "KyselynTekija: [tekijaid=" + tekijaid + ", nimi=" + nimi + "]";
    }

    public List<Kysely> getKyselyt() {
        return kyselyt;
    }

    public void setKyselyt(List<Kysely> kyselyt) {
        this.kyselyt = kyselyt;
    }

    

}
