package aava.kyselyprojekti.domain;


public class Kysely {

    private long kyselyid;
    private String tekija;

    public Kysely() {
        this.kyselyid = 0;
        this.tekija = null;
    }

    public Kysely(long kyselyid, String tekija) {
        this.kyselyid = kyselyid;
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
