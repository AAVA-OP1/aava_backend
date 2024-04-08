package aava.kyselyprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
public class RestKyselyController {

    @Autowired
    private KyselyRepository kyselyRepository;

    @RequestMapping(value = "/kyselyt", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> kyselyLista() {

        return (List<Kysely>) kyselyRepository.findAll();
    }

}
