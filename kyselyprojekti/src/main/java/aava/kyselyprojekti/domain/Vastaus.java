package aava.kyselyprojekti.domain;

public class Vastaus {

    private Long vastausid;
    private String vastaus;

    public Vastaus(Long vastausid, String vastaus) {
        this.vastausid = vastausid;
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

}
