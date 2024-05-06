package aava.kyselyprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.KyselynTekija;
import aava.kyselyprojekti.domain.KyselynTekijaRepository;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;
import aava.kyselyprojekti.domain.PelkatKysymysetRepository;
import aava.kyselyprojekti.domain.Vastaus;
import aava.kyselyprojekti.domain.VastausRepository;

@SpringBootApplication
public class KyselyprojektiApplication {
	private static final Logger logger = LoggerFactory.getLogger(KyselyprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(KyselyRepository kyselyRepository, KysymysRepository kysymysRepository,
			KyselynTekijaRepository kTekijaRepository, VastausRepository vastausRepository,
			PelkatKysymysetRepository pelkatKysymysetRepository) {
		return (args) -> {

			KyselynTekija t1 = new KyselynTekija("Alina");
			kTekijaRepository.save(t1);

			KyselynTekija t2 = new KyselynTekija("Aku");
			kTekijaRepository.save(t2);

			KyselynTekija t3 = new KyselynTekija("Anastasia");
			kTekijaRepository.save(t3);

			KyselynTekija t4 = new KyselynTekija("Valtteri");
			kTekijaRepository.save(t4);

			// testikysely ja -kysymys
			Kysely testikysely = new Kysely(t1, "Ensimmäinen testikysely", "Tämän on testi kysely testaukseen");
			kyselyRepository.save(testikysely);

			Kysymys kysymys1 = new Kysymys("Mikä on lempikurssisi?", testikysely);
			kysymysRepository.save(kysymys1);
			/* pelkatKysymysetRepository.save(kysymys1); */

			Kysymys kysymys2 = new Kysymys("Mikä on haaveammattisi?", testikysely);
			kysymysRepository.save(kysymys2);

			Kysymys kysymys3 = new Kysymys("Milloin valmistut?", testikysely);
			kysymysRepository.save(kysymys3);

			Kysely testikysely2 = new Kysely(t2, "Toinen testikysely", "Testi kuvaus testaukseen");
			kyselyRepository.save(testikysely2);

			Kysely testikysely3 = new Kysely(t3, "Kolmas testikysely", "Testi kuvaus testaukseen");
			kyselyRepository.save(testikysely3);

			Kysely testikysely4 = new Kysely(t4, "Kysely kouluruuasta", "Onko kouluruoka maittavaa?");
			kyselyRepository.save(testikysely4);

			Kysymys kysymys4 = new Kysymys("Mikä on lempiohjelmointikielesi?", testikysely2);
			kysymysRepository.save(kysymys4);

			Kysymys kysymys5 = new Kysymys("Miksi valitsit juuri tämän tutkinnon?", testikysely2);
			kysymysRepository.save(kysymys5);

			Kysymys kysymys6 = new Kysymys("Miten menee tänään?", testikysely3);
			kysymysRepository.save(kysymys6);

			Kysymys kysymys7 = new Kysymys("Miksi syöt juuri tätä ruokaa?", testikysely4);
			kysymysRepository.save(kysymys7);

			Vastaus vastaus1 = new Vastaus("Moikkelismoi moi", kysymys4);
			vastausRepository.save(vastaus1);

			Vastaus vastaus2 = new Vastaus("jfilesjflisjfisjslifjiesjflijeslifjesfeslijifsjiljl", kysymys1);
			vastausRepository.save(vastaus2);

			Vastaus vastaus3 = new Vastaus("moimoimoi", kysymys2);
			vastausRepository.save(vastaus3);

			Kysely koulukysely = new Kysely(t1, "Opiskeluajatusten kartoituskysely",
					"Opiskelijoiden yleisiä näkemyksiä opiskelusta");
			kyselyRepository.save(koulukysely);

			Kysymys k1 = new Kysymys("Minkä vuoden opiskelija olet?", koulukysely);
			Kysymys k2 = new Kysymys("Opiskeletko päivätoteutuksessa vai monimuotona?", koulukysely);
			Kysymys k3 = new Kysymys("Mitä tutkintoa opiskelet?", koulukysely);
			Kysymys k4 = new Kysymys("Mistä olet eniten nauttinut opinnoissasi?", koulukysely);
			Kysymys k5 = new Kysymys("Mikä on ollut opinnoissa haastavinta?", koulukysely);
			Kysymys k6 = new Kysymys("Koetko onnistuneesi opinnoissasi tähän asti?", koulukysely);
			Kysymys k7 = new Kysymys("Kuinka monta opintopistettä olet suorittanut tähän mennessä?", koulukysely);
			kysymysRepository.save(k1);
			kysymysRepository.save(k2);
			kysymysRepository.save(k3);
			kysymysRepository.save(k4);
			kysymysRepository.save(k5);
			kysymysRepository.save(k6);
			kysymysRepository.save(k7);

			Vastaus v1 = new Vastaus("Olen 2 vuoden opiskelija", k1);
			vastausRepository.save(v1);
			Vastaus v2 = new Vastaus("Olen päivätoteutuksessa", k2);
			vastausRepository.save(v2);
			Vastaus v3 = new Vastaus("Tiko", k3);
			vastausRepository.save(v3);
			Vastaus v4 = new Vastaus("Olen tykännyt kaikesta", k4);
			vastausRepository.save(v4);
			Vastaus v5 = new Vastaus("Byrokratia", k5);
			vastausRepository.save(v5);
			Vastaus v6 = new Vastaus("Olen onnistuja", k6);
			vastausRepository.save(v6);
			Vastaus v7 = new Vastaus("Satoja", k7);
			vastausRepository.save(v7);

			Vastaus v8 = new Vastaus("Olen toisen vuoden opiskelija", k1);
			vastausRepository.save(v8);
			Vastaus v9 = new Vastaus("Opiskelen päivätoteutuksessa", k2);
			vastausRepository.save(v9);
			Vastaus v10 = new Vastaus("Tietojenkäsittely", k3);
			vastausRepository.save(v10);
			Vastaus v11 = new Vastaus("Kaikki on ollut hauskaa", k4);
			vastausRepository.save(v11);
			Vastaus v12 = new Vastaus("Ajankäyttö", k5);
			vastausRepository.save(v12);
			Vastaus v13 = new Vastaus("Olen onnistunut", k6);
			vastausRepository.save(v13);
			Vastaus v14 = new Vastaus("En muista", k7);
			vastausRepository.save(v14);

			// sisällöt näkyville terminaaliin loggerin avulla
			for (Kysely kysely2 : kyselyRepository.findAll()) {
				logger.info(kysely2.toString());
			}

			for (Kysymys kyssari : kysymysRepository.findAll()) {
				logger.info(kyssari.toString());
			}

		};
	}

}
