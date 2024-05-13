package aava.kyselyprojekti.web;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;

@CrossOrigin
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


    // alla koodia, jossa olisi tarkoitus tehdä uusikysymys, ja "Tallenna" -napin painamisen
    // jälkeen viedä käyttäjä takaisin kysely -sivulle, jossa ko. kyselyn
    // voi tallentaa tai uuden kysymyksen lisätä
    // // AKUN LISÄYS: tähän pitäisi myös liittää kyselyntekijä

    // @RequestMapping(value = "/uusikysymys", method = RequestMethod.GET)
    // public String uusiKysymys(Model model) {

    //     Kysymys kysymys = new Kysymys();



    //     return "uusikysymys";
    // }

     @RequestMapping(value = "/tallennakysymys", method = RequestMethod.POST)
     public String tallennaKysymys(Kysymys uusiKysymys, Model model) {


        kysymysRepository.save(uusiKysymys);

        return "redirect:/uusikysymys";
     }



     @RequestMapping(value = "/tallennakysymysmuokkauksessa", method = RequestMethod.POST)
     public String tallennaKysymysMuokkauksessa(Kysymys uusiKysymys, Model model) {

        kysymysRepository.save(uusiKysymys);

        // Menee takaisin indexiin, eikä jää tarkastele sivulle...
        return "redirect:/index";
     }

    // kysymystenmuokkaus
    @GetMapping("/muokkaakysymysta/{kysymysid}")
    public String muokkaaKysymysta(@PathVariable("kysymysid") Long kysymysid, Model model) {
        Optional<Kysymys> optionalKysymys = kysymysRepository.findById(kysymysid);
 
        if (optionalKysymys.isPresent()) {
            Kysymys kysymys = optionalKysymys.get();
           
            model.addAttribute("kysymys", kysymys);
            model.addAttribute("kysymysid", kysymysid);
            
            return "muokkaakysymysta";
        } else {
            return "redirect:/tarkastelekyselya";
        }
    }

    /* @PostMapping("/update/{kysymysid}")
    public String paivitettyKysymys(@PathVariable ("kysymysid") long kysymysid, @ModelAttribute("kysymys") Kysymys paivitettyKysymys) {
        kysymysRepository.save(paivitettyKysymys);
        return "redirect:/tarkastelekyselya";
    } */

  /*   @PostMapping("/update")
    public String updateKysymys( @PathVariable("kysymysid") Long kysymysid, 
            @ModelAttribute("kysymys") Kysymys updateKysymys) {
        kysymysRepository.save(updateKysymys);
        return "redirect:/tarkastelekyselya";
 
    } */
/* 
    @PostMapping("/muokkaakysymysta")
    public String updateKysymys(Kysymys editKysymys, Model model) {
        kysymysRepository.save(editKysymys);
        return "redirect:/tarkastelekyselya";
 
    } */

    @PostMapping("/muokkaakysymysta")
public String updateKysymys(@ModelAttribute("kysymys") Kysymys editKysymys, Model model) {
    kysymysRepository.save(editKysymys);
    return "redirect:/tarkastelekyselya";
}




}
