package aava.kyselyprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;

@CrossOrigin
@RestController
public class RestKysymysController {

    @Autowired
    private KysymysRepository kysymysRepository;

    @RequestMapping(value = "/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymysLista() {

        return (List<Kysymys>) kysymysRepository.findAll();
    }

}
