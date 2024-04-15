package aava.kyselyprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Vastaus;
import aava.kyselyprojekti.domain.VastausRepository;

@CrossOrigin
@RestController
public class RestVastausController {

    @Autowired
    private VastausRepository vastausRepository;


    // IDEA TÄSSÄ:
    // kovakoodata vain että tallentaa uuden vastauksen. Sitten kun se toimii niin sitten vasta lähettää
    // frontista Vastaus-objekti ja se tallentaa.

    // RESTful metodi tallentamaan uusi kysymys
/*     @RequestMapping(value="/uusivastaus", method = RequestMethod.POST)
    /* public @ResponseBody Kysymys saveVastausRest(@RequestBody Kysymys kysymys) { 
    public void saveVastausRest() {
        Vastaus testiVastaus = new Vastaus("Hellou");
         vastausRepository.save(testiVastaus);
 } */

     // palauttaa kaikki vastaukset
     @RequestMapping(value = "/vastaukset", method = RequestMethod.GET)
     public @ResponseBody List<Vastaus> vastausLista() {
 
         return (List<Vastaus>) vastausRepository.findAll();
     }

}
