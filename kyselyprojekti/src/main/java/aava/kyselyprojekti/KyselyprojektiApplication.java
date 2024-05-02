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
	public CommandLineRunner demo(KyselyRepository kyselyRepository, KysymysRepository kysymysRepository, KyselynTekijaRepository kTekijaRepository, VastausRepository vastausRepository, PelkatKysymysetRepository pelkatKysymysetRepository) {
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

			Kysymys kysymys4 = new Kysymys("Mikä on lempiohjelmointikielesi?", testikysely2);
			kysymysRepository.save(kysymys4);

			Kysymys kysymys5 = new Kysymys("Miksi valitsit juuri tämän tutkinnon?", testikysely2);
			kysymysRepository.save(kysymys5);

			Vastaus vastaus1 = new Vastaus("Moikkelismoi moi", kysymys4);
			vastausRepository.save(vastaus1);

			Vastaus vastaus2 = new Vastaus("jfilesjflisjfisjslifjiesjflijeslifjesfeslijifsjiljl", kysymys1);
			vastausRepository.save(vastaus2);

			Vastaus vastaus3 = new Vastaus("moimoimoi", kysymys2);
			vastausRepository.save(vastaus3);


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
