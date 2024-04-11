package aava.kyselyprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aava.kyselyprojekti.domain.Vastaus;
import aava.kyselyprojekti.domain.VastausRepository;

public class RestVastausController {

    @Autowired
    private VastausRepository vastausRepository;


    // IDEA TÄSSÄ:
    // kovakoodata vain että tallentaa uuden vastauksen. Sitten kun se toimii niin sitten vasta lähettää
    // frontista Vastaus-objekti ja se tallentaa.

    // RESTful metodi tallentamaan uusi kysymys
    @RequestMapping(value="/uusivastaus", method = RequestMethod.POST)
    /* public @ResponseBody Kysymys saveVastausRest(@RequestBody Kysymys kysymys) { */
    public void saveVastausRest() {
        Vastaus testiVastaus = new Vastaus("Hellou");
         vastausRepository.save(testiVastaus);
        
 }

}
