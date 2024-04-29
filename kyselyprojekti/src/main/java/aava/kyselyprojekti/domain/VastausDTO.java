package aava.kyselyprojekti.domain;

import jakarta.persistence.Entity;


public class VastausDTO {

    private Long kysymysid;
    private String vastauksensisalto;

    public VastausDTO(){
        
    }

    public VastausDTO(Long kysymysid, String vastauksensisalto) {
        this.kysymysid = kysymysid;
        this.vastauksensisalto = vastauksensisalto;
    }

    public Long getKysymysid() {
        return kysymysid;
    }

    public void setKysymysid(Long kysymysid) {
        this.kysymysid = kysymysid;
    }

    public String getVastauksensisalto() {
        return vastauksensisalto;
    }

    public void setVastauksensisalto(String vastauksensisalto) {
        this.vastauksensisalto = vastauksensisalto;
    }

    @Override
    public String toString() {
        return "VastausDTO [kysymysid=" + kysymysid + ", vastauksensisalto=" + vastauksensisalto + "]";
    }



}
