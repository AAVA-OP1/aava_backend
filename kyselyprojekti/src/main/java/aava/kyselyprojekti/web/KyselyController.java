package aava.kyselyprojekti.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;

@Controller
public class KyselyController {

    // Linkitetään repositoryt
    @Autowired
    private KyselyRepository kyselyRepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    // aloitussivun endpoint
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String aloitusSivu(Model model) {

        model.addAttribute("kyselyt", kyselyRepository.findAll());
        return "index"; // .html
    }

    // uuden kyselyn endpoint
    @RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
    public String uusiKysely(Model model) {

        /*
         * Kysely uusiKysely = kyselyRepository.save(new Kysely());
         * model.addAttribute("kysely", uusiKysely);
         */
        model.addAttribute("kysely", new Kysely());
        // tässä uuden kyselyn id aina 0, koska parametrittomassa konstruktorissa
        // asetetaan aina id = 0

        return "uusikysely"; // .html
    }

    // tallentaa kyselyn kyselyrepoon -> näkyy etusivulla
    @RequestMapping(value = "/tallennakysely", method = RequestMethod.POST)
    public String tallennaKysely(Kysely uusiKysely, Model model) {

        kyselyRepository.save(uusiKysely);

        return "redirect:/index";
    }

    @RequestMapping(value = "/tarkastelekyselya/{kysely}", method = RequestMethod.GET)
    public String tarkastelekyselya(@PathVariable("kysely") Kysely kysely, Model model) {


        model.addAttribute("kysymykset", kysymysRepository.findByKysely(kysely));

        return "tarkastelekyselya"; // .html

    } 

    

}
