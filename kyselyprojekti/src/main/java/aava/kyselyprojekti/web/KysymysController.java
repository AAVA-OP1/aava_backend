package aava.kyselyprojekti.web;

import java.util.List;
import java.util.Optional;

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
public class KysymysController {
    
    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private KyselyRepository kyselyRepository;

    @RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
    public String uusiKysymys(Model model) {

        model.addAttribute("kysymys", new Kysymys());

        List<Kysely> kyselyt = (List<Kysely>) kyselyRepository.findAll();
        model.addAttribute("kyselyt", kyselyt);

        List<Kysymys> kysymykset = (List<Kysymys>) kysymysRepository.findAll();
        model.addAttribute("kysymykset", kysymykset);


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

}
