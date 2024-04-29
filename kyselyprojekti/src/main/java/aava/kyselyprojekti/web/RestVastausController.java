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
import aava.kyselyprojekti.domain.VastausDTO;
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




   


@RequestMapping(value="/uusivastaus", method = RequestMethod.POST)
    public void saveStudentRest (@RequestBody List<VastausDTO> vastausDTO) {
    
    for (int i = 0; i < vastausDTO.size(); i ++) {
        Vastaus vastaus = new Vastaus();
        vastaus.setVastaus(vastausDTO.get(i).getVastauksensisalto());

        Optional<Kysymys> kysymysOptional = kysymysRepository.findById(vastausDTO.get(i).getKysymysid());
        if (kysymysOptional.isPresent()) {
            Kysymys kysymys = kysymysOptional.get();
            vastaus.setKysymys(kysymys);
            


 

        vastausRepository.save(vastaus);
        
    }
}
   
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
