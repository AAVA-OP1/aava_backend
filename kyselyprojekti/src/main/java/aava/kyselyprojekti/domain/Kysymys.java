package aava.kyselyprojekti.domain;

public class Kysymys {
    

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
