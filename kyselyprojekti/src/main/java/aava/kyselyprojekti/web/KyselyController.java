package aava.kyselyprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "index"; //.html
    }

    // uuden kyselyn endpoint
    @RequestMapping(value = "/uusikysely", method = RequestMethod.GET)
    public String uusiKysely(Model model) {

        model.addAttribute("kysely", new Kysely());

        return "uusikysely"; //.html
    }

    @RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
    public String uusiKysymys(Model model) {

        model.addAttribute("kysymys", new Kysymys());

        return "uusikysymys"; // .html
    }

    // aloitettu avaakysely -metodi:
    // @RequestMapping(value = "/katsokysely/{id}", method = RequestMethod.GET)
    // public String katsoKysely() {

    //     return "katsokysely"; //.html
    // }

    
}
