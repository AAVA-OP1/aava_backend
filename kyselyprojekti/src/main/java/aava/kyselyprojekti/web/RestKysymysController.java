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
import aava.kyselyprojekti.domain.PelkatKysymyset;
import aava.kyselyprojekti.domain.PelkatKysymysetRepository;

@CrossOrigin
@RestController
public class RestKysymysController {

    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private PelkatKysymysetRepository pelkatKysymysetRepository;

    // palauttaa kaikki kysymykset JA Vastaukset

    @RequestMapping(value = "/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysLista() {

        return (List<Kysymys>) kysymysRepository.findAll();
    }

    // tee controlleri joka palauttaa VAIN KYSYMYSET

    @RequestMapping(value = "/vainKysymykset", method = RequestMethod.GET)
    public @ResponseBody List<PelkatKysymyset> kysymysListaIlmanVastauksia() {
        List<Kysymys> kysymykset = (List<Kysymys>) kysymysRepository.findAll();

        for (Kysymys kys : kysymykset) {
            var pelkatKysymykset = new PelkatKysymyset();
            var linkitettyKysely = new Kysely(); // ei toimi viel
            pelkatKysymykset.setSisalto(kys.getSisalto());


            // kyselyn linkitys ei vielä toimi
            linkitettyKysely.getKyselyid();
        
            pelkatKysymysetRepository.save(pelkatKysymykset);

        }
        return (List<PelkatKysymyset>) pelkatKysymysetRepository.findAll();
    }

    

}
