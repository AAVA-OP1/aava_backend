package aava.kyselyprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;
import aava.kyselyprojekti.domain.PelkatKysymysetRepository;
import aava.kyselyprojekti.domain.PelkatVastaukset;
import aava.kyselyprojekti.domain.PelkatVastauksetRepository;
import aava.kyselyprojekti.domain.Vastaus;
import aava.kyselyprojekti.domain.VastausRepository;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class RestVastausController {

    @Autowired
    private VastausRepository vastausRepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private PelkatVastauksetRepository pelkatVastauksetRepository;

    @Autowired
    private PelkatKysymysetRepository pelkatKysymysetRepository;

    // IDEA TÄSSÄ:
    // kovakoodata vain että tallentaa uuden vastauksen. Sitten kun se toimii niin
    // sitten vasta lähettää
    // frontista Vastaus-objekti ja se tallentaa.

    // Tallennus POST toimii. Jos lähettää POSTMAN niin uusi vastaus tallentuu
    // repoon.
    // Seuraavaksi FRONTISTA tulisi lähettää dataa ja käsitellä se täällä ja
    // tallentaa

    // RESTful metodi tallentamaan uusi kysymys

    // palauttaa vastukset frontista
   /*   @RequestMapping(value = "/uusivastaus", method = RequestMethod.POST)
     public void saveVastausRest(Vastaus tallennettuVastaus, Model Model) {


     List<Kysymys> kLista = (List<Kysymys>) kysymysRepository.findAll();
    
     vastausRepository.save(tallennettuVastaus);
     }  */


    /*  Vastaus testiVastaus = new Vastaus("hahaha", kLista.get(1)); */

    @RequestMapping(value = "/uusivastaus", method = RequestMethod.POST) // TOimii postmanin kautta kun lisää key (kysymysid ja vastauksen sisältö ja valuet näille! )
    public void saveVastausRest(@RequestParam("kysymysid") List<Long> kysymysid,
                                @RequestParam("vastauksensisalto") List<String> vastauksensisalto) {

        Optional<Kysymys> kysymys1 = kysymysRepository.findById(kysymysid.get(0));

        if (kysymys1.isPresent()){

            Kysymys kysymys = kysymys1.get();
            Vastaus vastaus = new Vastaus(vastauksensisalto.get(0), kysymys);
            vastausRepository.save(vastaus);
        }


        
        
        // Käsittele vastaanotetut kysymysid:t ja vastaukset tässä
    }
    



  

    
   

    // palauttaa kaikki vastaukset (palauttaa myös kysymykset)
    @RequestMapping(value = "/vastaukset", method = RequestMethod.GET)
    public @ResponseBody List<Vastaus> vastausLista() {

        return (List<Vastaus>) vastausRepository.findAll();
    }

    // palauttaa pelkät vastukset

    @RequestMapping(value = "/vainVastaukset", method = RequestMethod.GET)
    public @ResponseBody List<PelkatVastaukset> vastausListaIlmanKysymyksia() {
        List<Vastaus> vastaukset = (List<Vastaus>) vastausRepository.findAll();

        for (Vastaus vas : vastaukset) {
            var pelkatVastaukset = new PelkatVastaukset();

            var linkitettyKysely = new Kysely(); // ei toimi viel
            pelkatVastaukset.setVastaus(vas.getVastaus());

            pelkatVastauksetRepository.save(pelkatVastaukset);

        }
        return (List<PelkatVastaukset>) pelkatVastauksetRepository.findAll();
    }

}
