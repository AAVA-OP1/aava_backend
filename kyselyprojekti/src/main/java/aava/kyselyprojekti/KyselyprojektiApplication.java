package aava.kyselyprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aava.kyselyprojekti.domain.Kysely;
import aava.kyselyprojekti.domain.KyselyRepository;
import aava.kyselyprojekti.domain.Kysymys;
import aava.kyselyprojekti.domain.KysymysRepository;

@SpringBootApplication
public class KyselyprojektiApplication {
	private static final Logger logger = LoggerFactory.getLogger(KyselyprojektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(KyselyRepository kyselyRepository, KysymysRepository kysymysRepository) {
		return (args) -> {

			// testikysely ja -kysymys
			Kysely testikysely = new Kysely("Alina", "Ensimmäinen testikysely");
			kyselyRepository.save(testikysely);

			Kysymys kysymys1 = new Kysymys("Mikä on lempikurssisi?", testikysely);
			kysymysRepository.save(kysymys1);

			Kysymys kysymys2 = new Kysymys("Mikä on haaveammattisi?", testikysely);
			kysymysRepository.save(kysymys2);

			Kysymys kysymys3 = new Kysymys("Milloin valmistut?", testikysely);
			kysymysRepository.save(kysymys3);

			Kysely testikysely2 = new Kysely("AlinaTaas", "Toinen testikysely");
			kyselyRepository.save(testikysely2);

			Kysymys kysymys3 = new Kysymys("Mikä on lempiohjelmointikielesi?", testikysely2);
			kysymysRepository.save(kysymys3);

			Kysymys kysymys4 = new Kysymys("Miksi valitsit juuri tämän tutkinnon?", testikysely2);
			kysymysRepository.save(kysymys4);


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
