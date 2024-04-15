package aava.kyselyprojekti.web;


import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.KyselynTekija;
import aava.kyselyprojekti.domain.KyselynTekijaRepository;
import aava.kyselyprojekti.domain.KysymysRepository;

@CrossOrigin
@Controller
public class KyselyController {

    // Linkitetään repositoryt
    @Autowired
    private KyselyRepository kyselyRepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private KyselynTekijaRepository kyselynTekijaRepository;

    // aloitussivun endpoint
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String aloitusSivu(Model model) {

        model.addAttribute("kyselyt", kyselyRepository.findAll());
        model.addAttribute("tekijat", kyselynTekijaRepository.findAll());
        return "index"; // .html
    }

    // uuden kyselyn endpoint
    @RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
    public String uusiKysely(Model model) {

        /*
         * Kysely uusiKysely = kyselyRepository.save(new Kysely());
         * model.addAttribute("kysely", uusiKysely);
         */
        Kysely kysely = new Kysely();
        model.addAttribute("kysely", kysely);
        // tässä uuden kyselyn id aina 0, koska parametrittomassa konstruktorissa
        // asetetaan aina id = 0
        kyselyRepository.save(kysely);

        return "uusikysely"; // .html
    }

    // tallentaa kyselyn kyselyrepoon -> näkyy etusivulla
    @RequestMapping(value = "/tallennakysely", method = RequestMethod.POST)
    public String tallennaKysely(@ModelAttribute("kysely") Kysely uusiKysely, @RequestParam("nimi") String nimi, @RequestParam("tekijaid") Long tekijaId,@RequestParam("kuvaus") String kuvaus, Model model) {
        // Set the name for the new kysely
        uusiKysely.setNimi(nimi);
        uusiKysely.setKyselynKuvaus(kuvaus);
    
        // Fetch the tekija object based on the ID and set it in the kysely
        KyselynTekija tekija = kyselynTekijaRepository.findById(tekijaId).orElseThrow(() -> new RuntimeException("Tekijä not found with id: " + tekijaId));
        uusiKysely.setKyselynTekija(tekija);
    
        // Save the modified kysely to the repository
        kyselyRepository.save(uusiKysely);
    
        return "redirect:/uusikysymys";
    }

    @RequestMapping(value = "/tarkastelekyselya/{kysely}", method = RequestMethod.GET)
    public String tarkastelekyselya(@PathVariable("kysely") Kysely kysely, Model model) {

        model.addAttribute("kysymykset", kysymysRepository.findByKysely(kysely));
        
        model.addAttribute("kysely", kysely);

        return "tarkastelekyselya"; // .html

    }

     

}
