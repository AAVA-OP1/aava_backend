package aava.kyselyprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;
import aava.kyselyprojekti.domain.PelkatVastaukset;
import aava.kyselyprojekti.domain.PelkatVastauksetRepository;
import aava.kyselyprojekti.domain.Vastaus;
import aava.kyselyprojekti.domain.VastausRepository;

@CrossOrigin
@RestController
public class RestVastausController {

    @Autowired
    private VastausRepository vastausRepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private PelkatVastauksetRepository pelkatVastauksetRepository;

    // IDEA TÄSSÄ:
    // kovakoodata vain että tallentaa uuden vastauksen. Sitten kun se toimii niin
    // sitten vasta lähettää
    // frontista Vastaus-objekti ja se tallentaa.

    // Tallennus POST toimii. Jos lähettää POSTMAN niin uusi vastaus tallentuu repoon.
    // Seuraavaksi FRONTISTA tulisi lähettää dataa ja käsitellä se täällä ja tallentaa

    // RESTful metodi tallentamaan uusi kysymys
    @RequestMapping(value = "/uusivastaus", method = RequestMethod.POST)
    public void saveVastausRest() {
        List<Kysymys> kLista = (List<Kysymys>) kysymysRepository.findAll();
        Vastaus testiVastaus = new Vastaus("hahaha", kLista.get(1));
        vastausRepository.save(testiVastaus);
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
