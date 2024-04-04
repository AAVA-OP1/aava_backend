package aava.kyselyprojekti.web;

import java.util.List;
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

        return "uusikysely"; // .html
    }

    @RequestMapping(value = "/tallennakysely", method = RequestMethod.POST)
    public String tallennaKysely(Kysely uusiKysely, Model model) {

        kyselyRepository.save(uusiKysely);

        return "redirect:/index";
    }

    // Ottaa valitun kyselyn ID ja menee edit sivulle
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String tarkastelekyselya(@PathVariable Long id, Model model) {

        Optional<Kysymys> kysymykset = kysymysRepository.findById(id);
        if (kysymykset.isPresent()) {

            model.addAttribute("kysymykset", kysymykset);
            return "tarkastelekyselya"; // .html
        } else
            return "redirect:/index";
    }

    @RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
    public String uusiKysymys(Model model) {

        model.addAttribute("kysymys", new Kysymys());

        List<Kysely> kyselyt = (List<Kysely>) kyselyRepository.findAll();
        model.addAttribute("kyselyt", kyselyt);

        List<Kysymys> kysymykset = (List<Kysymys>) kysymysRepository.findAll();
        model.addAttribute("kysymykset", kysymykset);

        /*
         * Long size = (long) kyselyt.size();
         * Optional<Kysely> kysely = kyselyRepository.findById(size);
         * model.addAttribute("linkitettyKysely", kysely);
         */

        Long size = (long) kyselyt.size();
        Optional<Kysely> kysely = kyselyRepository.findById(size);
        if (kysely.isPresent()) {
            Kysely kysely1 = kysely.get();
            model.addAttribute("linkitettyKysely", kysely1);
        }

        return "uusikysymys"; // .html
    }

    @RequestMapping(value = "/tallennakysymys", method = RequestMethod.POST)
    public String tallennaKysymys(Kysymys uusiKysymys, Model model) {

        kysymysRepository.save(uusiKysymys);

        return "redirect:/uusikysymys";
    }

    // aloitettu avaakysely -metodi:
    // @RequestMapping(value = "/katsokysely/{id}", method = RequestMethod.GET)
    // public String katsoKysely() {

    // return "katsokysely"; //.html
    // }

}
