package aava.kyselyprojekti.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepository extends CrudRepository<Kysely, Long> {


      Optional<Kysely> findByKyselynTekija(KyselynTekija kyselynTekija);  

 

}
