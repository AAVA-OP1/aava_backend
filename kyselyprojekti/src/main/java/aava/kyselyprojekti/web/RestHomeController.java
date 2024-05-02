package aava.kyselyprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aava.kyselyprojekti.domain.Kysely;

@Controller

public class RestHomeController {


    

    @RequestMapping(value = "/resthome", method = RequestMethod.GET)
    public String returnRestHome() {
        return "resthome"; // html
    }
}
