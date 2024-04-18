package aava.kyselyprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.KyselynTekija;
import aava.kyselyprojekti.domain.KysymysRepository;
import aava.kyselyprojekti.domain.VastausRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
public class RestKyselyController {

    @Autowired
    private KyselyRepository kyselyRepository;


    // palauttaa kaikki kyselyt
    @RequestMapping(value = "/kyselyt", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> kyselyLista() {

        return (List<Kysely>) kyselyRepository.findAll();
    }

    // toimii, kyselynTekija haetaan id:lla esim 1
    @RequestMapping(value = "kysely/tekija/{kyselynTekija}", method = RequestMethod.GET)
            public @ResponseBody Optional<Kysely> getKyselyByMaker(@PathVariable("kyselynTekija") KyselynTekija kyselynTekija) {
            return (kyselyRepository.findByKyselynTekija(kyselynTekija));

    }  

    // Palauttaa yksittäisen (id) kyselyn
    @RequestMapping(value = "kysely/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Kysely> getKyselyById(@PathVariable("id") Long kyselyid) {
        return (kyselyRepository.findById(kyselyid));
    }
    


}
