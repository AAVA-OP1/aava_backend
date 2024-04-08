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
        // tässä uuden kyselyn id aina 0, koska parametrittomassa konstruktorissa asetetaan aina id = 0

        return "uusikysely"; // .html
    }

    // tallentaa kyselyn kyselyrepoon -> näkyy etusivulla
    @RequestMapping(value = "/tallennakysely", method = RequestMethod.POST)
    public String tallennaKysely(Kysely uusiKysely, Model model) {

        kyselyRepository.save(uusiKysely);

        return "redirect:/index";
    }

    // Ottaa valitun kyselyn ID ja menee edit sivulle
    // Ei toimi vielä
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String tarkastelekyselya(@PathVariable("id") Long id, Model model) {

        // nyt hakee kyselyn id:n perusteella kysymysRepositorystä
        // eli jos kyselyn id = 0, hakee vain kysymykset joiden id = 0
        // List<Kysymys> kysymykset = (List<Kysymys>) kysymysRepository.findByKyselyId(id)?
        // -> vaatii siis findByKyselyId:n teon kysymysrepoon
        // en uskalla kokeilla t. Alina
        Optional<Kysymys> kysymykset = kysymysRepository.findById(id);
        if (kysymykset.isPresent()) {

            model.addAttribute("kysymykset", kysymykset);
            return "tarkastelekyselya"; // .html
        } else
            return "redirect:/index";
    } 

    
    
}
